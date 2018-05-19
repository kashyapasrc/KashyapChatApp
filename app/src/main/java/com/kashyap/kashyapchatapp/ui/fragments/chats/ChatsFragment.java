package com.kashyap.kashyapchatapp.ui.fragments.chats;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kashyap.kashyapchatapp.BasePresenter;
import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.adapters.ChatAdapter;
import com.kashyap.kashyapchatapp.ui.fragments.BaseFragment;
import com.kashyap.kashyapchatapp.ui.models.ChatModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XPS-Laptop on 21-Apr-18.
 */

public class ChatsFragment extends BaseFragment implements ChatContract.View {

    private RecyclerView chatFragmentRecyclerView;
    List<ChatModel> chatModelList = new ArrayList<>();
    ChatAdapter mAdapter;

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
                mAdapter = new ChatAdapter(chatModelList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                chatFragmentRecyclerView.setLayoutManager(mLayoutManager);
                chatFragmentRecyclerView.setItemAnimator(new DefaultItemAnimator());
                chatFragmentRecyclerView.setAdapter(mAdapter);
                prepareDataSet();
            }
        }

    }


    private void prepareDataSet() {
        chatModelList.clear();
        for (int i = 1; i < 11; i++)
            chatModelList.add(new ChatModel(i, "", "", ""));
        mAdapter.notifyDataSetChanged();


    }

    public void onActivityCreated(Bundle savedInstanceSpace) {
        super.onActivityCreated(savedInstanceSpace);


    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }
}
