
package com.indexer.psi.model;


import com.google.gson.annotations.SerializedName;



public class Readings {

    @SerializedName("co_eight_hour_max")
    private CoEightHourMax mCoEightHourMax;
    @SerializedName("co_sub_index")
    private CoSubIndex mCoSubIndex;
    @SerializedName("no2_one_hour_max")
    private No2OneHourMax mNo2OneHourMax;
    @SerializedName("o3_eight_hour_max")
    private O3EightHourMax mO3EightHourMax;
    @SerializedName("o3_sub_index")
    private O3SubIndex mO3SubIndex;
    @SerializedName("pm10_sub_index")
    private Pm10SubIndex mPm10SubIndex;
    @SerializedName("pm10_twenty_four_hourly")
    private Pm10TwentyFourHourly mPm10TwentyFourHourly;
    @SerializedName("pm25_sub_index")
    private Pm25SubIndex mPm25SubIndex;
    @SerializedName("pm25_twenty_four_hourly")
    private Pm25TwentyFourHourly mPm25TwentyFourHourly;
    @SerializedName("psi_twenty_four_hourly")
    private PsiTwentyFourHourly mPsiTwentyFourHourly;
    @SerializedName("so2_sub_index")
    private So2SubIndex mSo2SubIndex;
    @SerializedName("so2_twenty_four_hourly")
    private So2TwentyFourHourly mSo2TwentyFourHourly;

    public CoEightHourMax getCoEightHourMax() {
        return mCoEightHourMax;
    }

    public void setCoEightHourMax(CoEightHourMax coEightHourMax) {
        mCoEightHourMax = coEightHourMax;
    }

    public CoSubIndex getCoSubIndex() {
        return mCoSubIndex;
    }

    public void setCoSubIndex(CoSubIndex coSubIndex) {
        mCoSubIndex = coSubIndex;
    }

    public No2OneHourMax getNo2OneHourMax() {
        return mNo2OneHourMax;
    }

    public void setNo2OneHourMax(No2OneHourMax no2OneHourMax) {
        mNo2OneHourMax = no2OneHourMax;
    }

    public O3EightHourMax getO3EightHourMax() {
        return mO3EightHourMax;
    }

    public void setO3EightHourMax(O3EightHourMax o3EightHourMax) {
        mO3EightHourMax = o3EightHourMax;
    }

    public O3SubIndex getO3SubIndex() {
        return mO3SubIndex;
    }

    public void setO3SubIndex(O3SubIndex o3SubIndex) {
        mO3SubIndex = o3SubIndex;
    }

    public Pm10SubIndex getPm10SubIndex() {
        return mPm10SubIndex;
    }

    public void setPm10SubIndex(Pm10SubIndex pm10SubIndex) {
        mPm10SubIndex = pm10SubIndex;
    }

    public Pm10TwentyFourHourly getPm10TwentyFourHourly() {
        return mPm10TwentyFourHourly;
    }

    public void setPm10TwentyFourHourly(Pm10TwentyFourHourly pm10TwentyFourHourly) {
        mPm10TwentyFourHourly = pm10TwentyFourHourly;
    }

    public Pm25SubIndex getPm25SubIndex() {
        return mPm25SubIndex;
    }

    public void setPm25SubIndex(Pm25SubIndex pm25SubIndex) {
        mPm25SubIndex = pm25SubIndex;
    }

    public Pm25TwentyFourHourly getPm25TwentyFourHourly() {
        return mPm25TwentyFourHourly;
    }

    public void setPm25TwentyFourHourly(Pm25TwentyFourHourly pm25TwentyFourHourly) {
        mPm25TwentyFourHourly = pm25TwentyFourHourly;
    }

    public PsiTwentyFourHourly getPsiTwentyFourHourly() {
        return mPsiTwentyFourHourly;
    }

    public void setPsiTwentyFourHourly(PsiTwentyFourHourly psiTwentyFourHourly) {
        mPsiTwentyFourHourly = psiTwentyFourHourly;
    }

    public So2SubIndex getSo2SubIndex() {
        return mSo2SubIndex;
    }

    public void setSo2SubIndex(So2SubIndex so2SubIndex) {
        mSo2SubIndex = so2SubIndex;
    }

    public So2TwentyFourHourly getSo2TwentyFourHourly() {
        return mSo2TwentyFourHourly;
    }

    public void setSo2TwentyFourHourly(So2TwentyFourHourly so2TwentyFourHourly) {
        mSo2TwentyFourHourly = so2TwentyFourHourly;
    }

}
