package com.kashyap.kashyapchatapp.ui.models;

/**
 * Created by XPS-Laptop on 21-Apr-18.
 */

public class ChatModel {


    private int mId;
    private String mName;
    private String mChat;

    private String mProfileAvatar;


    public ChatModel(int mId, String mName, String mChat, String mProfileAvatar) {
        this.mId = mId;
        this.mName = mName;
        this.mChat = mChat;
        this.mProfileAvatar = mProfileAvatar;
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
