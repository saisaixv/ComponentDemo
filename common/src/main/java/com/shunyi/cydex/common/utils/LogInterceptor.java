package com.shunyi.cydex.common.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by saisai on 2017/6/15.
 */

public class LogInterceptor implements Interceptor {
    String TAG=getClass().getSimpleName();
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        logRequest(request);

        Response response=null;
        try {

             response= chain.proceed(request);
        }catch (Exception e){

            Log.e(TAG,e.getMessage());
        }
        return logResponse(response);
    }

    private Response logResponse(Response response) {

        Response.Builder builder = response.newBuilder();
        Response clone = builder.build();

        Log.e(TAG,"response : url = "+clone.request().url()
                + " || code = "+clone.code()+" || protocol = "+clone.protocol());

//        if(!TextUtils.isEmpty(clone.message())){
//            ResponseBody body = clone.body();
//            if(body!=null){
//                MediaType mediaType = body.contentType();
//
//                if(mediaType!=null){
//
//                    if(){
//
//                    }
//                }
//
//            }
//        }
        return response;
    }

    private void logRequest(Request request){
//        Log.e(TAG,"request : url = "+request.url()+"  "+request.body().toString());
        Log.e(TAG,"request : url = "+request.url());
    }
}
