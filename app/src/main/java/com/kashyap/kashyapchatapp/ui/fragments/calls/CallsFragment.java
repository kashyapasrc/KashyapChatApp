package com.kashyap.kashyapchatapp.ui.fragments.calls;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kashyap.kashyapchatapp.BasePresenter;
import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.fragments.BaseFragment;

/**
 * Created by XPS-Laptop on 21-Apr-18.
 */

public class CallsFragment extends BaseFragment implements CallsContract.View {


    private CallsContract.Presenter mPresenter;

    @Override
    protected int screenName() {
        return 0;
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_calls_layout;
    }

    @Override
    protected void initUI() {

    }


    @Override
    public void setPresenter(BasePresenter presenter) {
        this.mPresenter = (CallsContract.Presenter) presenter;
    }
}
