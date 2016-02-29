package com.demos;

import android.app.Activity;

import com.demos.TwoBallsSeekbar.SeekBarActivity;
import com.demos.ViewAnimation.CustomDialogActivity;
import com.demos.aidl.AidlActivity;
import com.demos.aidl.BookManagerActivity;
import com.demos.asynchronous.AsyncTaskActivity;
import com.demos.viewdraghelper.SwipBackActivity;
import com.demos.window.WindowActivity;


/**
 * Created by Mr_Wrong on 16/2/2.
 */
public enum AllActivitys {
    TestActivity(CustomDialogActivity.class),
    AidlActivity(AidlActivity.class),
    BookManagerActivity(BookManagerActivity.class),
    DragActivity(SwipBackActivity.class),
    AsyncTaskActivity(AsyncTaskActivity.class),
    WindowActivity(WindowActivity.class),
    CheckBoxActivity(com.demos.checkbox.CheckBoxActivity.class),
    SeekBarActivity(SeekBarActivity.class),
    BehaviorActivity(com.demos.NestedScrolling.BehaviorActivity.class),
    DayNightActivity(com.demos.support_23_2.DayNightActivity.class);


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
