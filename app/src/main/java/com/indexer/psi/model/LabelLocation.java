
package com.indexer.psi.model;


import com.google.gson.annotations.SerializedName;



public class LabelLocation {

    @SerializedName("latitude")
    private Double mLatitude;
    @SerializedName("longitude")
    private Double mLongitude;

    public Double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(Double latitude) {
        mLatitude = latitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(Double longitude) {
        mLongitude = longitude;
    }

}
