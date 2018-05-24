package com.kashyap.kashyapchatapp.ui.fragments.chatList;

public class ChatPresenter implements ChatContract.Presenter {

    private final ChatContract.View mChatView;

    public ChatPresenter(ChatContract.View chatView) {
        this.mChatView=chatView;
    }
}
