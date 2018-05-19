package com.kashyap.kashyapchatapp.ui.fragments.chats;

import android.view.View;
import android.widget.ImageView;

public interface ChatRecyclerViewItemClickListener {

     void onChatItemClick(View view, ImageView sharedImageView, int position);
}
