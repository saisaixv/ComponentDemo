package com.shunyi.cydex.girls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.github.mzule.activityrouter.annotation.Router;
import com.shunyi.cydex.common.base.BaseApplication;
import com.shunyi.cydex.common.utils.DataType;
import com.shunyi.cydex.common.utils.HttpUtils;
import com.shunyi.cydex.common.utils.ResponseListener;
import com.shunyi.cydex.girls.adapter.GirlsAdapter;
import com.shunyi.cydex.girls.data.Girls;

import java.io.IOException;

import okhttp3.Call;

@Router("girls")
public class MainActivity extends AppCompatActivity {

    String TAG=getClass().getSimpleName();
    private RecyclerView lvGirls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_girls);

//        Context context=GirlsApplication.app;

        BaseApplication application = (BaseApplication) getApplication();
        Log.e(TAG,application.user);
        initView();
        initData();

    }

    private void initView() {

        lvGirls = (RecyclerView) findViewById(R.id.lv_girls);
    }

    private void initData() {

        HttpUtils build = new HttpUtils.Builder()
                .baseUrl(Constants.GAN_HUO_API)
                .url("福利/" + 20 + "/" + 1)
                .bodyType(DataType.JSON_OBJECT, Girls.class)
                .build();

        build.get(new ResponseListener() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG,"onFailure : "+e.getMessage());
            }

            @Override
            public void onError(int code, String msg) {
                Log.e(TAG,"onError : code = "+code +"  msg = "+msg);
            }

            @Override
            public void onSuccess(Object obj) {

                final Girls girls= (Girls) obj;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initAdapter(girls);
                    }
                });
            }
        });
    }

    private void initAdapter(Girls girls) {
        GirlsAdapter adapter=new GirlsAdapter(this,girls.getResults());
        GridLayoutManager manager=new GridLayoutManager(this,2);
        lvGirls.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        lvGirls.setAdapter(adapter);
    }
}
