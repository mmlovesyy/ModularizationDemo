package com.mcxtzhang.modularizationdemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.widget.Toast;

import java.util.List;

/**
 * 介绍：跳转工具类，类似其他的Router 不过没有黑科技
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/14.
 */

public class JumpUtils {

    private static final String PK_NAME = "com.mcxtzhang";

    public static void jumpToModule1(Context context) {
        //startActivity(new Intent(MainActivity.this, BbsMainActivity.class));
        Intent intent = new Intent();
        try {
            intent.setClass(context,Class.forName("com.mcxtzhang.bbs.BbsMainActivity"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        jumpToActivity(context, intent);
    }

    public static void jumpToActivity(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        if (!activities.isEmpty()) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "该Activity没找到:" + intent, Toast.LENGTH_SHORT).show();
        }
    }
}