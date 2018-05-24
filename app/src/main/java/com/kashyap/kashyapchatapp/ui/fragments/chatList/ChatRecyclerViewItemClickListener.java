package com.kashyap.kashyapchatapp.ui.fragments.chatList;

import android.view.View;
import android.widget.ImageView;

import com.kashyap.kashyapchatapp.ui.models.ChatModel;

public interface ChatRecyclerViewItemClickListener {

    void onChatProfilePicClick(View view, ImageView sharedImageView, int position,ChatModel model);

    void onChatItemRowClick(View view, ChatModel chatModel, int position);



}
