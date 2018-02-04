package com.indexer.psi.rest;


import com.indexer.psi.model.PsiReturnObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {
    @GET("psi")
    Call<PsiReturnObject> getPsiValue();

    @GET("psi")
    Call<PsiReturnObject> getPsiValueWithDate(@Query("date") String date);
}
