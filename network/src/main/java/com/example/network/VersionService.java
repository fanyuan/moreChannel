package com.example.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface VersionService {
    @POST("hlplay/appversion/appAndroidVer")
    Call<ResponseBody> getVersion();
    @POST("hlplay/appversion/appAndroidVer")
    Call<VersionResult<String>> getVersion02();
    @POST("hlplay/appversion/appAndroidVer")
    Call<VersionResult<VersionBean>> getVersionResult();

    @GET
    @Streaming
    Call<ResponseBody> downLoad(@Url String fileUrl);
}
