package com.myapplication.ViewAnimation;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.base.ToolBarActivity;

/**
 * Created by Mr_Wrong on 16/2/2.
 */
public class CustomDialogActivity extends ToolBarActivity {
    ImageView imageView;


    @Override
    public int getLayout() {
        return R.layout.test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageView = mTool.find(R.id.iv_view_animation);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomDialogActivity.this, R.style.color_dialog);
                View view = LayoutInflater.from(CustomDialogActivity.this).inflate(R.layout.dialog_layout, null);
                builder.setView(view);
                AlertDialog d = builder.create();
                TextView title = (TextView) view.findViewById(R.id.tvTitle);
                title.setText("hehe");
                TextView button = (TextView) view.findViewById(R.id.btnNegative);
                button.setText("取消");
                d.show();

                AnimationDialog dialog = new AnimationDialog(CustomDialogActivity.this);
//                dialog.show();
            }
        });


    }

}
