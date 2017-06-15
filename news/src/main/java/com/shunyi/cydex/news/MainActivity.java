package com.shunyi.cydex.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.github.mzule.activityrouter.annotation.Router;
import com.shunyi.cydex.common.base.BaseApplication;
import com.shunyi.cydex.common.utils.DataType;
import com.shunyi.cydex.common.utils.HttpClient;
import com.shunyi.cydex.common.utils.ResponseListener;
import com.shunyi.cydex.news.adapter.NewsAdapter;
import com.shunyi.cydex.news.data.News;

import java.io.IOException;

import okhttp3.Call;

@Router("news")
public class MainActivity extends AppCompatActivity {

    String TAG=getClass().getSimpleName();

    private RecyclerView lvVews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_news);

//        Context context= NewsApplication.app;

        BaseApplication application = (BaseApplication) getApplication();
        Log.e(TAG,application.user);
        initView();
        initData();
    }

    private void initView() {
        lvVews = (RecyclerView) findViewById(R.id.lv_news);
    }

    private void initData() {

//        Retrofit build = new Retrofit.Builder()
//                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE)
//                .build();
//        NewsService newsService = build.create(NewsService.class);
//        retrofit2.Call<ResponseBody> call = newsService.getNews("20170613");
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                try {
//                    String string = response.body().string();
//
//                    final News news = DataParseUtil.parseObject(string, News.class);
//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            initAdapter(news);
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
//
//            }
//        });


//        HttpUtils httpUtils=new HttpUtils.Builder()
//                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE)
//                .url("20170613")
//                .bodyType(DataType.JSON_OBJECT, News.class)
//                .build();
//        httpUtils.get(new ResponseListener() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e(TAG,"onFailure : "+e.getMessage());
//            }
//
//            @Override
//            public void onError(int code, String msg) {
//                Log.e(TAG,"onError : code = "+code+"   msg = "+msg);
//            }
//
//            @Override
//            public void onSuccess(Object obj) {
//
//                final News news= (News) obj;
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        initAdapter(news);
//                    }
//                });
//
//            }
//        });


        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE)
                .url("20170613")
                .bodyType(DataType.JSON_OBJECT, News.class)
                .build();
        client.get(new ResponseListener() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onError(int code, String msg) {

            }

            @Override
            public void onSuccess(final Object obj) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initAdapter((News) obj);
                    }
                });
            }
        });

    }

    private void initAdapter(News news) {

        NewsAdapter adapter=new NewsAdapter(this,news.getStories());
        LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this);
        lvVews.setLayoutManager(manager);
        lvVews.setAdapter(adapter);
    }
}
