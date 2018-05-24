package com.kashyap.kashyapchatapp.ui.adapters;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.fragments.chatList.ChatRecyclerViewItemClickListener;
import com.kashyap.kashyapchatapp.ui.models.ChatModel;

import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyViewHolder> {

    private final ChatRecyclerViewItemClickListener mClickListener;
    private List<ChatModel> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView profile_avatar;
        View mRootView;

        public MyViewHolder(View view) {
            super(view);
            mRootView = view;
            profile_avatar = view.findViewById(R.id.profile_avatar);
        }

        public void onBind(final int position, final ChatModel model) {
            ViewCompat.setTransitionName(profile_avatar, model.getName());

            mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClickListener != null)
                        mClickListener.onChatItemRowClick(mRootView, model, position);
                }
            });

            profile_avatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClickListener != null)
                        mClickListener.onChatProfilePicClick(itemView, profile_avatar, position,model);
                }
            });

            Log.i("key",""+model.getModels().size());


        }
    }


    public ChatListAdapter(List<ChatModel> moviesList, ChatRecyclerViewItemClickListener clickListener) {
        this.moviesList = moviesList;
        this.mClickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_chats_item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChatModel movie = moviesList.get(position);
        holder.onBind(position, movie);


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
