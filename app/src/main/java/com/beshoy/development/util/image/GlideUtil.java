package com.beshoy.development.util.image;

import android.content.Context;
import android.widget.ImageView;

import com.beshoy.development.R;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Created by Beshoy Samy on 16-Dec-17.
 */

public class GlideUtil {

    private GlideUtil() {}

    public static void loadImageURL(Context mContext, String imageURL, ImageView imageView){
        GlideApp.with(mContext)
                .load(imageURL)
                //.placeholder(R.color.image_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

}
