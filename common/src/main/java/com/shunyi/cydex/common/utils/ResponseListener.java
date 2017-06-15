package com.shunyi.cydex.common.utils;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by saisai on 2017/6/15.
 */

public interface ResponseListener {

    void onFailure(Call call, IOException e);

    void onError(int code,String msg);

    void onSuccess(Object obj);
}
