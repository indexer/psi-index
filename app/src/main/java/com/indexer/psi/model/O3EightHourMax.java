
package com.indexer.psi.model;

import com.google.gson.annotations.SerializedName;

public class O3EightHourMax {

    @SerializedName("central")
    private Long mCentral;
    @SerializedName("east")
    private Long mEast;
    @SerializedName("national")
    private Long mNational;
    @SerializedName("north")
    private Long mNorth;
    @SerializedName("south")
    private Long mSouth;
    @SerializedName("west")
    private Long mWest;

    public Long getCentral() {
        return mCentral;
    }

    public void setCentral(Long central) {
        mCentral = central;
    }

    public Long getEast() {
        return mEast;
    }

    public void setEast(Long east) {
        mEast = east;
    }

    public Long getNational() {
        return mNational;
    }

    public void setNational(Long national) {
        mNational = national;
    }

    public Long getNorth() {
        return mNorth;
    }

    public void setNorth(Long north) {
        mNorth = north;
    }

    public Long getSouth() {
        return mSouth;
    }

    public void setSouth(Long south) {
        mSouth = south;
    }

    public Long getWest() {
        return mWest;
    }

    public void setWest(Long west) {
        mWest = west;
    }

}
