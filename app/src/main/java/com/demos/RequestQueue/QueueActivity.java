package com.demos.RequestQueue;

import android.os.Bundle;
import android.widget.TextView;

import com.demos.R;
import com.demos.main.base.ToolBarActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Mr_Wrong on 16/3/4.
 * 一个异步的消息队列
 */
public class QueueActivity extends ToolBarActivity {
    @Bind(R.id.tv_queue)
    TextView tvQueue;
    RequestQueue<String> queue;
    int index;

    @OnClick(R.id.btn_add_request)
    void _add() {
        queue.add("消息" + index++);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = new RequestQueue<String>() {
            @Override
            public void handleResult(String s) {
                tvQueue.setText(s);
            }
        };
        queue.start();


    }

    @Override
    public int getLayout() {
        return R.layout.queue;
    }

}
