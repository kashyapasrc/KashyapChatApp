package com.kashyap.kashyapchatapp.ui.fragments.status;

public class StatusPresenter implements StatusContract.Presenter {

    private final StatusContract.View mView;

    public StatusPresenter(StatusContract.View view) {
        this.mView = view;
    }
}
