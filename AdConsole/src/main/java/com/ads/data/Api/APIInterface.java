package com.ads.data.Api;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface APIInterface {
    @POST()
    @FormUrlEncoded
    Call<Recover> getadsdetail(@Field("packagename") String packagename, @Url String url);
}