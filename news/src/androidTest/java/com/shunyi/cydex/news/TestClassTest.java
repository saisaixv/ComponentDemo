package com.shunyi.cydex.news;

import android.util.Log;

import org.junit.Test;

/**
 * Created by saisai on 2017/6/15.
 */
public class TestClassTest {
    String TAG=getClass().getSimpleName();
    @Test
    public void sum() throws Exception {

        TestClass tc=new TestClass();
        if(tc.sum(2,6)==8){
            Log.e(TAG,"true");
        }else {
            Log.e(TAG, "false");
        }
    }

    @Test
    public void sub() throws Exception {
        TestClass tc=new TestClass();
        if(tc.sub(2,6)==-4){
            Log.e(TAG,"true");
        }else {
            Log.e(TAG, "false");
        }
    }

}