package com.demos.viewdraghelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demos.R;
import com.demos.main.base.ToolBarActivity;

/**
 * Created by Mr_Wrong on 16/2/17.
 */
public class SwipBackActivity extends ToolBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = (Button) findViewById(R.id.btn_swipback);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTool.start(SecondActivity.class);
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.swipback;
    }
}
