package com.example.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookService {
    @GET("book/{id}")
    Call<ResponseBody> getBook(@Path("id") int id);
}
