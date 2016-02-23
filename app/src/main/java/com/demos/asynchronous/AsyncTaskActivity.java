package com.demos.asynchronous;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.demos.R;
import com.demos.main.base.ToolBarActivity;

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
        new Task().execute(1);
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
            textView.setText(values[0]+"");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            textView.setText("执行结束了");
        }
    }

}
