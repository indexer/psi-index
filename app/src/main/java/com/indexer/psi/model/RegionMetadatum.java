
package com.indexer.psi.model;


import com.google.gson.annotations.SerializedName;

public class RegionMetadatum {

    @SerializedName("label_location")
    private LabelLocation mLabelLocation;
    @SerializedName("name")
    private String mName;

    public LabelLocation getLabelLocation() {
        return mLabelLocation;
    }

    public void setLabelLocation(LabelLocation labelLocation) {
        mLabelLocation = labelLocation;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
