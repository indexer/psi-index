
package com.indexer.psi.model;

import com.google.gson.annotations.SerializedName;


public class ApiInfo {

    @SerializedName("status")
    private String mStatus;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
