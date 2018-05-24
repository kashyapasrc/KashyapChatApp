package com.kashyap.kashyapchatapp.ui.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.kashyap.kashyapchatapp.utils.*;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatModel implements Serializable {


    private int mId;
    private String mName = Constants.EMPTY;
    private String mChat = Constants.EMPTY;
    private String mProfileAvatar = Constants.EMPTY;

    public void setModels(ArrayList<DataModel> models) {
        this.models = models;
    }

    private ArrayList<DataModel> models = new ArrayList<>();


    public ChatModel(int mId, String mName, String mChat, String mProfileAvatar) {
        this.mId = mId;
        this.mName = mName;
        this.mChat = mChat;
        this.mProfileAvatar = mProfileAvatar;



    }




    public ArrayList<DataModel> getModels() {
        return models;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getChat() {
        return mChat;
    }

    public void setChat(String mChat) {
        this.mChat = mChat;
    }

    public String getProfileAvatar() {
        return mProfileAvatar;
    }

    public void setProfileAvatar(String mProfileAvatar) {
        this.mProfileAvatar = mProfileAvatar;
    }


}
