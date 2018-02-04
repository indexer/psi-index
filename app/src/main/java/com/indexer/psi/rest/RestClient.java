package com.indexer.psi.rest;


import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static RestClient instance;
    private final RestService mService;

    private RestClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(
                new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE));
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);

        OkHttpClient client = builder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("api-key",
                        "2KeuML0dka7bMF1uJ6LHU6LlS35S45EF").build();
                return chain.proceed(request);
            }
        }).build();

        final Retrofit restAdapter =
                new Retrofit.Builder().baseUrl("https://api.data.gov.sg/v1/environment/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();
        mService = restAdapter.create(RestService.class);


    }

    public static synchronized RestService getService(Context mContext) {
        return getInstance().mService;
    }

    private static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }
}
