
package com.indexer.psi.model;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


public class Item implements Comparable<Item> {

    @SerializedName("readings")
    private Readings mReadings;
    @SerializedName("timestamp")
    private String mTimestamp;
    @SerializedName("update_timestamp")
    private String mUpdateTimestamp;

    public Readings getReadings() {
        return mReadings;
    }

    public void setReadings(Readings readings) {
        mReadings = readings;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

    public String getUpdateTimestamp() {
        return mUpdateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        mUpdateTimestamp = updateTimestamp;
    }

    @Override
    public int compareTo(@NonNull Item o) {
        return getTimestamp().compareTo(o.getTimestamp());

    }
}
