package com.shunyi.cydex.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
@Router("main")
public class MainActivity extends AppCompatActivity {

    private Button btnNews;
    private Button btnGirls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        initListener();
    }

    private void initView() {
        btnNews = (Button) findViewById(R.id.btn_news);
        btnGirls = (Button) findViewById(R.id.btn_girls);
    }

    private void initListener() {
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Routers.open(MainActivity.this,"module://news");
            }
        });
        btnGirls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Routers.open(MainActivity.this,"module://girls");

            }
        });
    }
}
