package com.myapplication.main;

import android.app.Activity;
import android.content.Context;

import com.myapplication.AllActivitys;
import com.myapplication.R;
import com.myapplication.base.BaseAdapter;
import com.myapplication.base.MyViewHolder;

/**
 * Created by Mr_Wrong on 16/2/2.
 */
public abstract class ActivityAdapter extends BaseAdapter<Activity> {
    protected ActivityAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBind(MyViewHolder viewHolder, int Position) {
        Activity activity = get(Position);
        int start = activity.getClass().getName().lastIndexOf(".") + 1;
        String name = activity.getClass().getName().substring(start);
        viewHolder.setTextView(R.id.tv_item, name);
        viewHolder.getConvertView().setTag(AllActivitys.values()[Position]);
    }

    @Override
    protected int getLayout() {
        return R.layout.item;
    }
}
