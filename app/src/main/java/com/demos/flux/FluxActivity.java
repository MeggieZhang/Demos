package com.demos.flux;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demos.R;
import com.demos.flux.model.User;
import com.demos.flux.stores.MessageStore;
import com.demos.flux.stores.UserStore;
import com.demos.main.base.BaseAdapter;
import com.demos.main.base.MyViewHolder;
import com.socks.library.KLog;
import com.squareup.otto.Subscribe;

import butterknife.Bind;

/**
 * Created by Mr_Wrong on 16/3/25.
 * activity的职责只是去处理view的更新等操作
 */
public class FluxActivity extends FluxBaseActivity {

    @Bind(R.id.rv_flux)
    RecyclerView mRecyclerView;

    @Override
    public int getLayout() {
        return R.layout.flux;
    }

    MessageStore mStore = new MessageStore();
    UserStore mUserStore = new UserStore();
    UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStore(mStore);
        initStore(mUserStore);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new UserAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mActionsCreater.queryUser("70kg");
    }

    @Subscribe
    public void messagechange(MessageStore.MessageEvent event) {

    }

    @Subscribe
    public void userchange(UserStore.UserEvent event) {
        mAdapter.add(mUserStore.getUser());
    }

    class UserAdapter extends BaseAdapter<User> {

        protected UserAdapter(Context context) {
            super(context);
        }

        @Override
        protected void onItemClick(View v, int position) {

        }

        @Override
        public void onBind(MyViewHolder viewHolder, int Position) {
            User user = get(Position);
            KLog.e(user.getName());
            viewHolder.setTextView(R.id.tv_flux_name, user.getName());
        }

        @Override
        protected int getLayout() {
            return R.layout.flux_item;
        }
    }


}
