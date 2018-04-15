package com.nero.liveshow.util;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;

public class TencentApi {
    public static final String LIVE_API_URL = "http://statcgi.video.qcloud.com/common_access";

    private static final int APP_ID = 1256383050;

    public void getLiveState() {
        OkHttpClient okHttpClient = new OkHttpClient();
        //Form表单格式的参数传递
        FormBody formBody = new FormBody
                .Builder()
                .add("cmd", APP_ID + "")//设置参数名称和参数值

                .build();
        Request request = new Request
                .Builder()
               .post(formBody)//Post请求的参数传递，此处是和Get请求相比，多出的一句代码</font>
//                .url(Config.POST_URL)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String result = response.body().string();
//            Log.d("androixx.cn", result);
            response.body().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("获取系统毫秒数方法1："+System.currentTimeMillis()/1000L);
    }
}



