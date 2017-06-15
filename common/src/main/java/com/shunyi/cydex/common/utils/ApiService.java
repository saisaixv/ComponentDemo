package com.shunyi.cydex.common.utils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by saisai on 2017/6/15.
 */

public interface ApiService {

    @GET
    Call<ResponseBody> executeGet(@Url String url);



}
