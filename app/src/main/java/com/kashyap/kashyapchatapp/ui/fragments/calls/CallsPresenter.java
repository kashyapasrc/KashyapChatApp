package com.kashyap.kashyapchatapp.ui.fragments.calls;

public class CallsPresenter implements CallsContract.Presenter {

    private final CallsContract.View mView;

    public CallsPresenter(CallsContract.View view) {
        this.mView = view;
    }
}
