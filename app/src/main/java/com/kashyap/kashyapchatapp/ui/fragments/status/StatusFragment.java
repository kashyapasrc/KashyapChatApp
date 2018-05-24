package com.kashyap.kashyapchatapp.ui.fragments.status;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kashyap.kashyapchatapp.BasePresenter;
import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.fragments.BaseFragment;


public class StatusFragment extends BaseFragment implements StatusContract.View {

    private StatusPresenter mPresenter;

    @Override
    protected int screenName() {
        return 0;
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_status;
    }

    @Override
    protected void initUI() {
        //init the View using findView();
    }


    @Override
    public void setPresenter(BasePresenter presenter) {
        this.mPresenter = (StatusPresenter) presenter;
    }
}
