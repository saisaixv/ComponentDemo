package com.shunyi.cydex.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by saisai on 2017/6/15.
 */

public class HttpClient {

    private static HttpClient client=null;
    private final OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private Builder builder;

    private HttpClient(){

        final Map<String,List<Cookie>> cookieStore=new HashMap<>();

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10*1000, TimeUnit.MILLISECONDS)
                .addInterceptor(new LogInterceptor())
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

                        cookieStore.put(url.host(),cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(url);
                        return cookies!=null?cookies:new ArrayList<Cookie>();
                    }
                })
                .build();

    }

    private static HttpClient getInstance(){
        if(client==null){
            synchronized (HttpClient.class){
                if(client==null){
                    client=new HttpClient();
                }
            }
        }
        return client;
    }

    private void getRetrofit(String baseUrl){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    private void setBuilder(Builder builder){
        this.builder =builder;
    }

    public void get(ResponseListener responseListener){

        Call<ResponseBody> call = retrofit.create(ApiService.class).executeGet(builder.url);

        request(call,responseListener);
    }

    private void request(Call<ResponseBody> call, final ResponseListener responseListener) {

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code()!=200){
                    responseListener.onError(response.code(),response.message());
                }else {
                    try {
                        parseData(response.body().string(),builder.type,builder.clazz,responseListener);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseListener.onFailure(null,null);
            }
        });
    }

    private void parseData(String s,int type,Class clazz,ResponseListener responseListener){

        switch (type){
            case DataType.STRING:
                responseListener.onSuccess(s);
                break;
            case DataType.JSON_ARRAY:
                responseListener.onSuccess(DataParseUtil.parseToArrayList(s,clazz));
                break;
            case DataType.JSON_OBJECT:
                responseListener.onSuccess(DataParseUtil.parseObject(s,clazz));
                break;
            case DataType.XML:
                responseListener.onSuccess(DataParseUtil.parseXML(s,clazz));
                break;
        }
    }

    public static final class Builder{

        int type;
        Class clazz;
        String baseUrl;
        String url;
        public Builder baseUrl(String baseUrl){
            this.baseUrl=baseUrl;
            return this;
        }

        public Builder url(String url){
            this.url=url;
            return this;
        }

        public <T> Builder bodyType(int type,Class<T> clazz){

            this.type=type;
            this.clazz=clazz;
            return this;
        }

        public HttpClient build(){
            HttpClient client=HttpClient.getInstance();
            client.getRetrofit(baseUrl);
            client.setBuilder(this);
            return client;
        }
    }
}
