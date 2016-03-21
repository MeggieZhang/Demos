package com.demos.imageLoader.core;

import android.widget.ImageView;

import com.demos.imageLoader.ImageLoaderFor70kg;
import com.demos.imageLoader.config.DisplayConfig;
import com.demos.imageLoader.policy.LoadPolicy;
import com.demos.imageLoader.utils.Md5Helper;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Comparator;

/**
 * Created by Mr_Wrong on 16/3/21.
 */
public class BitmapRequest implements Comparator<BitmapRequest> {
    //请求序列号 用于加载策略
    public int serialNum = 0;
    public String imageUri = "";
    public String imageUriMd5 = "";
    Reference<ImageView> mImageViewRef;
    public ImageLoaderFor70kg.ImageListener imageListener;
    public boolean isCancel = false;

    public LoadPolicy mLoadPolicy = ImageLoaderFor70kg.newInstance().getLoaderConfig().loadPolicy;
    public DisplayConfig displayConfig;

    public BitmapRequest(ImageView imageView, String uri, DisplayConfig config, ImageLoaderFor70kg.ImageListener listener) {
        mImageViewRef = new WeakReference<ImageView>(imageView);
        displayConfig = config;
        imageListener = listener;
        imageUri = uri;
        imageView.setTag(uri);
        imageUriMd5 = Md5Helper.toMD5(imageUri);
    }

    @Override
    public int compare(BitmapRequest lhs, BitmapRequest rhs) {
        return mLoadPolicy.compare(this, rhs);
    }

    @Override
    public int hashCode() {//用于hash的时候
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imageUri == null) ? 0 : imageUri.hashCode());
        result = prime * result + ((mImageViewRef == null) ? 0 : mImageViewRef.get().hashCode());
        result = prime * result + serialNum;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BitmapRequest other = (BitmapRequest) obj;
        if (imageUri == null) {
            if (other.imageUri != null)
                return false;
        } else if (!imageUri.equals(other.imageUri))
            return false;
        if (mImageViewRef == null) {
            if (other.mImageViewRef != null)
                return false;
        } else if (!mImageViewRef.get().equals(other.mImageViewRef.get()))
            return false;
        if (serialNum != other.serialNum)
            return false;
        return true;
    }
}
