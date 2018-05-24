package com.kashyap.kashyapchatapp.ui.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.kashyap.kashyapchatapp.utils.Constants;

import java.io.Serializable;

public class DataModel implements Serializable {

    private boolean isMyMsg = false;
    private String message = Constants.EMPTY;
    private String utcTime = Constants.EMPTY;


    public DataModel(boolean isMyMsg, String message, String utcTime) {
        this.isMyMsg = isMyMsg;
        this.message = message;
        this.utcTime = utcTime;
    }



    public String getMessage() {
        return message;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public boolean isMyMsg() {
        return isMyMsg;
    }

}
