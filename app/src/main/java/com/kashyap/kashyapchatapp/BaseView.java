package com.kashyap.kashyapchatapp;



public interface BaseView<Presenter extends BasePresenter> {

    void setPresenter(Presenter presenter);


}
