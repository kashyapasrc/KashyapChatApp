package com.kashyap.kashyapchatapp.ui.fragments.chatList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kashyap.kashyapchatapp.BasePresenter;
import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.activities.ChatActivity;
import com.kashyap.kashyapchatapp.ui.activities.SharedElementAnimation;
import com.kashyap.kashyapchatapp.ui.adapters.ChatListAdapter;
import com.kashyap.kashyapchatapp.ui.fragments.BaseFragment;
import com.kashyap.kashyapchatapp.ui.models.ChatModel;
import com.kashyap.kashyapchatapp.ui.models.DataModel;
import com.kashyap.kashyapchatapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;


public class ChatsFragment extends BaseFragment implements ChatContract.View, ChatRecyclerViewItemClickListener {


    private RecyclerView chatFragmentRecyclerView;
    List<ChatModel> chatModelList = new ArrayList<>();
    ChatListAdapter mAdapter;

    @Override
    protected int screenName() {
        return 0;
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_chats_fragment;
    }

    @Override
    protected void initUI() {
        if (getView() != null) {
            chatFragmentRecyclerView = findView(R.id.recycler_view);
            if (chatFragmentRecyclerView != null) {
                mAdapter = new ChatListAdapter(chatModelList, this);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                chatFragmentRecyclerView.setLayoutManager(mLayoutManager);
                chatFragmentRecyclerView.setItemAnimator(new DefaultItemAnimator());
                chatFragmentRecyclerView.setAdapter(mAdapter);
                prepareDataSet();
            }
        }

    }

    private ArrayList<DataModel> prepareSampleData() {
        ArrayList<DataModel> models = new ArrayList<>();
        models.add(new DataModel(false, "Hi", ""));
        models.add(new DataModel(true, "Hi", ""));
        models.add(new DataModel(false, "Hi", ""));
        models.add(new DataModel(true, "Hi", ""));
        models.add(new DataModel(false, "Hi", ""));
        models.add(new DataModel(true, "Hi", ""));
        return models;
    }

    private void prepareDataSet() {
        chatModelList.clear();
        for (int i = 1; i < 11; i++) {
            ChatModel chatModel = new ChatModel(i, "", "", "");
            chatModel.setModels(prepareSampleData());
            chatModelList.add(chatModel);
        }
        mAdapter.notifyDataSetChanged();


    }

    public void onActivityCreated(Bundle savedInstanceSpace) {
        super.onActivityCreated(savedInstanceSpace);


    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void onChatProfilePicClick(View view, ImageView sharedImageView, int position, ChatModel chatModel)

    {
        Intent intent = new Intent(getContext(), SharedElementAnimation.class);
        intent.putExtra(Constants.SharedElementTransistionKey, ViewCompat.getTransitionName(sharedImageView));
        intent.putExtra(Constants.CHAT_MODEL_KEY, chatModel);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(),
                sharedImageView,
                ViewCompat.getTransitionName(sharedImageView));

        startActivity(intent, options.toBundle());
    }

    @Override
    public void onChatItemRowClick(View view, ChatModel chatModel, int position) {

        Intent intent = ChatActivity.getIntentWithNewTask(getContext());
        intent.putExtra(Constants.CHAT_MODEL_KEY, chatModel);
        startActivity(intent);
    }
}
