package com.kashyap.kashyapchatapp.ui.fragments.chatItem;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.Toast;

import com.kashyap.kashyapchatapp.BasePresenter;
import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.adapters.ChatItemAdapter;
import com.kashyap.kashyapchatapp.ui.fragments.BaseFragment;
import com.kashyap.kashyapchatapp.ui.models.ChatModel;
import com.kashyap.kashyapchatapp.utils.*;

import static com.kashyap.kashyapchatapp.ui.adapters.ChatItemAdapter.MY_MESSAGE;
import static com.kashyap.kashyapchatapp.ui.adapters.ChatItemAdapter.MY_OPPONENT_MESSAGE;

public class ChatItemFragment extends BaseFragment implements ChatItemContract.View {


    ChatItemAdapter mChatItemAdapter;
    ChatModel mChatModel;
    RecyclerView mRecyclerView;

    public static ChatItemFragment newInstance(ChatModel chatModel) {
        ChatItemFragment fragment = new ChatItemFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.CHAT_MODEL_KEY, chatModel);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected int screenName() {
        return 0;
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_chat_item;
    }

    @Override
    protected void initUI() {
        if (getActivity() != null)
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        mRecyclerView = findView(R.id.recycler_view);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {

            mChatModel = (ChatModel) bundle.getSerializable(Constants.CHAT_MODEL_KEY);
            mChatItemAdapter = new ChatItemAdapter(getContext(), mChatModel);

            CustomGridLayoutManager layoutManager = new CustomGridLayoutManager(mRecyclerView.getContext(), 2);

            layoutManager.setScrollEnabled(true);

            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(mChatItemAdapter);

            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return mChatModel.getModels().get(position).isMyMsg() ? 2 : 2;
                }
            });
        }

    }

    public void onActivityCreated(Bundle savedStateInstance) {
        super.onActivityCreated(savedStateInstance);

    }
}
