package com.kashyap.kashyapchatapp.ui.fragments.chats;

public class ChatPresenter implements ChatContract.Presenter {

    private final ChatContract.View mChatView;

    public ChatPresenter(ChatContract.View chatView) {
        this.mChatView=chatView;
    }
}
