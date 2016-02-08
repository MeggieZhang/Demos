package com.myapplication.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.myapplication.AllActivitys;
import com.myapplication.R;
import com.myapplication.base.ToolBarActivity;

public class MainActivity extends ToolBarActivity {
    RecyclerView mRecyclerView;
    ActivityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbar.setNavigationIcon(null);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ActivityAdapter(this) {
            @Override
            protected void onItemClick(View v, int position) {
                AllActivitys allactivitys = (AllActivitys) v.getTag();
                Activity activity = allactivitys.getActivity();
                mTool.start(activity.getClass());
            }
        };
        mRecyclerView.setAdapter(mAdapter);
        for (int i = 0; i < AllActivitys.values().length; i++) {
            mAdapter.add(AllActivitys.values()[i].getActivity());
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

}
