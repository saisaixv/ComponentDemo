package com.shunyi.cydex.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by saisai on 2017/6/15.
 */

public class HttpUtils {

    String TAG=getClass().getSimpleName();
    private static HttpUtils instance=null;
    private final OkHttpClient okHttpClient;
    private Builder builder;

    private HttpUtils(){

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

    private static HttpUtils getInstance(){
        if(instance==null){
            synchronized (HttpUtils.class){
                if(instance==null){
                    instance=new HttpUtils();
                }
            }
        }
        return instance;
    }

    private void setBuilder(Builder builder){

        this.builder=builder;
    }

    public void get(ResponseListener responseListener){
        request(builder,responseListener);
    }

    private void request(final Builder builder, final ResponseListener responseListener) {

        final Request request=new Request.Builder()
                .url(builder.baseUrl+builder.url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                responseListener.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if(response.code()!=200){

                    responseListener.onError(response.code(),response.message());
                }else {

                    parseData(response.body().string(),builder.bodyType,builder.cls,responseListener);
                }
            }
        });
    }

    private void parseData(String string, int bodyType, Class cls, ResponseListener responseListener) {

        switch (bodyType){
            case DataType.STRING:
                responseListener.onSuccess(string);
                break;
            case DataType.XML:
                responseListener.onSuccess(DataParseUtil.parseXML(string,cls));
                break;
            case DataType.JSON_OBJECT:
                responseListener.onSuccess(DataParseUtil.parseObject(string,cls));
                break;
            case DataType.JSON_ARRAY:
                responseListener.onSuccess(DataParseUtil.parseToArrayList(string,cls));
                break;
        }
    }


    public static final class Builder{
        String baseUrl="";
        String url="";
        ResponseListener responseListener;
        int bodyType;
        Class cls;

        public Builder baseUrl(String baseUrl){

            this.baseUrl=baseUrl;
            return this;
        }

        public Builder url(String url){
            this.url=url;
            return this;
        }

        public Builder bodyType(int type,Class cls){

            this.bodyType=type;
            this.cls=cls;
            return this;
        }

        public HttpUtils build(){

            HttpUtils instance = HttpUtils.getInstance();
            instance.setBuilder(this);

            return instance;
        }
    }
}
