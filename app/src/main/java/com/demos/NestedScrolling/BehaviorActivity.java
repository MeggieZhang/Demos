package com.demos.NestedScrolling;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demos.R;
import com.demos.main.base.ToolBarActivity;

/**
 * Created by Mr_Wrong on 16/2/24.
 */
public class BehaviorActivity extends ToolBarActivity {
    @Override
    public int getLayout() {
        return R.layout.behavior_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button1 = mTool.find(R.id.btn_behavior1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTool.start(NestedScrollingActivity.class);
            }
        });
        Button button2 = mTool.find(R.id.btn_behavior2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTool.start(FabActivity.class);
            }
        });
    }
}
