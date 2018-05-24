package com.kashyap.kashyapchatapp.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.models.ChatModel;

public class ChatItemAdapter extends RecyclerView.Adapter {

    public static final int MY_MESSAGE = 0;
    public static final int MY_OPPONENT_MESSAGE = 1;
    private final ChatModel mChatModel;
    private final Context mContext;


    public ChatItemAdapter(Context context, ChatModel chatModel) {
        this.mContext = context;
        this.mChatModel = chatModel;

    }

    class MyMessage extends RecyclerView.ViewHolder {

        public MyMessage(View itemView) {
            super(itemView);
        }
    }

    class MyOpponentMessage extends RecyclerView.ViewHolder {

        public MyOpponentMessage(View itemView) {
            super(itemView);
        }
    }

    private View mapXmlWithView(ViewGroup parent, @LayoutRes int xmlFile) {
        return LayoutInflater.from(parent.getContext()).inflate(xmlFile, parent, false);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == MY_MESSAGE) {
            holder = new MyMessage(mapXmlWithView(parent, R.layout.chat_item_my_message));
        } else if (viewType == MY_OPPONENT_MESSAGE)
            holder = new MyOpponentMessage(mapXmlWithView(parent, R.layout.chat_item_my_opponent_message));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mChatModel.getModels().size();
    }


    @Override
    public int getItemViewType(int position) {
        return mChatModel.getModels().get(position).isMyMsg() ? MY_MESSAGE : MY_OPPONENT_MESSAGE;

    }

}
