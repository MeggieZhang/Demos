package com.myapplication;

import android.app.Activity;

import com.myapplication.ViewAnimation.CustomDialogActivity;
import com.myapplication.aidl.AidlActivity;
import com.myapplication.aidl.BookManagerActivity;

/**
 * Created by Mr_Wrong on 16/2/2.
 */
public enum AllActivitys {
    TestActivity(CustomDialogActivity.class),
    AidlActivity(AidlActivity.class),
    BookManagerActivity(BookManagerActivity.class);

    private Class activityClazz;

    private AllActivitys(Class clazz) {
        activityClazz = clazz;
    }

    public Activity getActivity() {
        try {
            return (Activity) activityClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init Activity instance");
        }

    }
}
