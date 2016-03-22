package com.demos.imageLoader;

import android.os.Bundle;
import android.widget.ImageView;

import com.demos.R;
import com.demos.imageLoader.config.ImageLoaderConfig;
import com.demos.main.base.ToolBarActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import butterknife.Bind;

/**
 * Created by Mr_Wrong on 16/3/22.
 */
public class ImageLoaderActivity extends ToolBarActivity {
    @Bind(R.id.iv_loader)
    ImageView ivLoader;

    @Override
    public int getLayout() {
        return R.layout.imageloader;
    }

    String imageurl = "http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageLoaderConfig config = new ImageLoaderConfig()
                .setLoadingPlaceholder(R.drawable.image_holder)
//                .setNotFoundPlaceholder(R.drawable.blank)
//                .setCache(new DoubleCache(this))
                .setThreadCount(4);
//                .setLoadPolicy(new ReversePolicy());
        ImageLoaderFor70kg.newInstance().init(config);
        ImageLoaderFor70kg.newInstance().displayImage(ivLoader, imageurl);


        UIL();
    }


    private void UIL() {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(configuration);

        ImageLoader.getInstance().displayImage(imageurl, ivLoader);
    }
}
