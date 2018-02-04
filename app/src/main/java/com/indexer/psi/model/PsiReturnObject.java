
package com.indexer.psi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PsiReturnObject {

    @SerializedName("api_info")
    private ApiInfo mApiInfo;
    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("region_metadata")
    private List<RegionMetadatum> mRegionMetadata;

    public ApiInfo getApiInfo() {
        return mApiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        mApiInfo = apiInfo;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

    public List<RegionMetadatum> getRegionMetadata() {
        return mRegionMetadata;
    }

    public void setRegionMetadata(List<RegionMetadatum> regionMetadata) {
        mRegionMetadata = regionMetadata;
    }

}
