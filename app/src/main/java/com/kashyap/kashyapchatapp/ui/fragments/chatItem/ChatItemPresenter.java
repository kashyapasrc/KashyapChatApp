package com.kashyap.kashyapchatapp.ui.fragments.chatItem;

public class ChatItemPresenter implements ChatItemContract.Presenter {


    private final ChatItemContract.View mView;

    public ChatItemPresenter(ChatItemContract.View view) {
        this.mView = view;
    }
}
