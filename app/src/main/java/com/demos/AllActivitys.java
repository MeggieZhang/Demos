package com.demos;

import android.app.Activity;

import com.demos.ViewAnimation.CustomDialogActivity;
import com.demos.aidl.AidlActivity;
import com.demos.aidl.BookManagerActivity;
import com.demos.viewdraghelper.SwipBackActivity;

/**
 * Created by Mr_Wrong on 16/2/2.
 */
public enum AllActivitys {
    TestActivity(CustomDialogActivity.class),
    AidlActivity(AidlActivity.class),
    BookManagerActivity(BookManagerActivity.class),
    DragActivity(SwipBackActivity.class);


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
