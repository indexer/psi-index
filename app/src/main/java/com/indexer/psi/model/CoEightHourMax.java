
package com.indexer.psi.model;


import com.google.gson.annotations.SerializedName;

public class CoEightHourMax {

    @SerializedName("central")
    private Double mCentral;
    @SerializedName("east")
    private Double mEast;
    @SerializedName("national")
    private Double mNational;
    @SerializedName("north")
    private Double mNorth;
    @SerializedName("south")
    private Double mSouth;
    @SerializedName("west")
    private Double mWest;

    public Double getCentral() {
        return mCentral;
    }

    public void setCentral(Double central) {
        mCentral = central;
    }

    public Double getEast() {
        return mEast;
    }

    public void setEast(Double east) {
        mEast = east;
    }

    public Double getNational() {
        return mNational;
    }

    public void setNational(Double national) {
        mNational = national;
    }

    public Double getNorth() {
        return mNorth;
    }

    public void setNorth(Double north) {
        mNorth = north;
    }

    public Double getSouth() {
        return mSouth;
    }

    public void setSouth(Double south) {
        mSouth = south;
    }

    public Double getWest() {
        return mWest;
    }

    public void setWest(Double west) {
        mWest = west;
    }

}
