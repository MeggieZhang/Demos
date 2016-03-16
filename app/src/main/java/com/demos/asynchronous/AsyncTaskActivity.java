package com.demos.asynchronous;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.demos.R;
import com.demos.main.base.ToolBarActivity;
import com.socks.library.KLog;

/**
 * Created by Mr_Wrong on 16/2/22.
 */
public class AsyncTaskActivity extends ToolBarActivity {
    @Override
    public int getLayout() {
        return R.layout.astyntcask;
    }

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = mTool.find(R.id.tv_text);
//        AsyncTask task = new Task().execute(1);
        taskFor70kg();
    }

    class Task extends AsyncTask<Integer, Integer, Boolean> {
        int count = 0;

        @Override
        protected void onPreExecute() {
            textView.setText(count + "");
        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            while (count < 10) {
                count += 2;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(count);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.setText(values[0] + "");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            textView.setText("执行结束了");
        }
    }

    private void taskFor70kg() {
        for (int i = 0; i < 6; i++) {
            AsyncTaskFor70kg<String, Integer, String> taskFor70kg = new AsyncTaskFor70kg<String, Integer, String>() {
                @Override
                protected String doInBackground(String... params) {
//                KLog.e("开始睡觉---" + params[0] + "--" + params[1]);
                    KLog.e(Thread.currentThread().getName());
                    for (int i = 0; i < 10; i++) {
                        publishProgress(i);
                    }
                    return "睡完觉了";
                }

                @Override
                protected void onProgressUpdate(Integer... values) {
//                KLog.e("进度---" + values[0]);
                }

                @Override
                protected void onPostExecute(String s) {
//                KLog.e("在主线程的结果---" + s);
                    KLog.e("结束---" + Thread.currentThread().getName());
                }
            };
            taskFor70kg.execute("arg1", "arg2");
        }
    }

}
