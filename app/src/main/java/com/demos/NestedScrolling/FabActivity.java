package com.demos.NestedScrolling;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demos.R;
import com.demos.main.base.BaseAdapter;
import com.demos.main.base.MyViewHolder;
import com.demos.main.base.ToolBarActivity;
import com.demos.support_23_2.MyBottomBehavior;
import com.socks.library.KLog;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Mr_Wrong on 16/2/24.
 */
public class FabActivity extends ToolBarActivity {
    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.coordinatorlayout)
    CoordinatorLayout coordinatorlayout;

    @Override
    public int getLayout() {
        return R.layout.fab_layout;
    }

    RecyclerView mRecyclerView;
    @Bind(R.id.nestedscrollview)
    NestedScrollView nestedscrollview;


    MyBottomBehavior behavior;

    @OnClick(R.id.fab)
    void _fab() {
        behavior.setState(MyBottomBehavior.STATE_EXPANDED);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerView = mTool.find(R.id.recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this);
        mRecyclerView.setAdapter(adapter);
        for (int i = 0; i < 20; i++) {
            adapter.add("位置--" + i);
        }

        behavior = MyBottomBehavior.from(nestedscrollview);
        behavior.setHideable(true);
        behavior.setPeekHeight(200);


        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {

                KLog.e(appBarLayout.getMeasuredHeight());//168
                KLog.e(mRecyclerView.getMeasuredHeight());//1845
                KLog.e(coordinatorlayout.getMeasuredHeight());//1845

            }
        });
    }

    class Adapter extends BaseAdapter<String> {

        protected Adapter(Context context) {
            super(context);
        }

        @Override
        protected void onItemClick(View v, int position) {

        }

        @Override
        public void onBind(MyViewHolder viewHolder, int Position) {
            viewHolder.setTextView(android.R.id.text1, get(Position));
        }

        @Override
        protected int getLayout() {
            return android.R.layout.simple_list_item_1;
        }
    }
}
