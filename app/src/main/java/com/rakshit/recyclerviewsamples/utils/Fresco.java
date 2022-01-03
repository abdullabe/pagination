package com.rakshit.recyclerviewsamples.utils;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.rakshit.recyclerviewsamples.R;


/**
 * Sample to load image via Fresco
 * @author Rakshit Nawani
 * Fresco takes care of image loading and display Using Fresco
 * dependencies implementation 'com.facebook.fresco:fresco:1.10.0'
 * how to use this class
 * example
 * Fresco.newBuilder((SimpleDraweeView) findViewById(R.id.my_image_view))
 * .setPlaceholderImage(R.color.grey200)
 * .withProgressBar(true)
 * .roundAsCircle(true)
 * .setProgressBarColor(R.color.colorAccent,R.color.grey500)
 * .setRoundCircleColor(R.color.colorAccent)
 * .setUri(Uri.parse("https://www.google.dz/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"))
 * .build(this);
 */
public class Fresco {
    private static Fresco loadImage;
    private SimpleDraweeView imageView;
    private Uri uri;
    private boolean withProgressBar = true;
    private boolean roundAsCircle = false;
    private boolean showBorder = true;

    private int ID_RES_PLACEHOLDER_IMAGE = R.color.white;

    private int ID_COLOR_BORDER_CIRCLE = R.color.white;

    private int ID_COLOR_PROGRESS = R.color.white;
    private int ID_COLOR_BACKGROUND_PROGRESS = R.color.white;

    public static Fresco newBuilder(@NonNull SimpleDraweeView imageView) {
        loadImage = new Fresco(imageView);
        return loadImage;
    }

    private Fresco(@NonNull SimpleDraweeView imageView) {
        this.imageView = imageView;
    }

    /**
     * progress bar
     *
     * @param withProgressBar default value: true
     */
    public Fresco withProgressBar(boolean withProgressBar) {
        this.withProgressBar = withProgressBar;
        return loadImage;
    }

    /**
     * @param placeholderImage The placeholder is shown until the image is ready.
     *                         default value : R.color.grey200
     */
    public Fresco setPlaceholderImage(@DrawableRes int placeholderImage) {

        this.ID_RES_PLACEHOLDER_IMAGE = placeholderImage;
        return loadImage;
    }

    /**
     * @param roundAsCircle default value : false
     */
    public Fresco roundAsCircle(boolean roundAsCircle) {
        this.roundAsCircle = roundAsCircle;
        return loadImage;
    }

    /**
     * @param color           R.color.colorAccent
     * @param backgroundColor R.color.grey500
     */
    public Fresco setProgressBarColor(@ColorRes int color, @ColorRes int backgroundColor) {
        this.ID_COLOR_PROGRESS = color;
        this.ID_COLOR_BACKGROUND_PROGRESS = backgroundColor;
        return loadImage;
    }

    public Fresco  setBorder(boolean setBorder){
        showBorder = setBorder;
        return loadImage;
    }

    /**
     * @param color default value: R.color.colorAccent
     */
    public Fresco setRoundCircleColor(@ColorRes int color) {
        this.ID_COLOR_BORDER_CIRCLE = color;
        return loadImage;
    }

    public Fresco setUri(Uri uri) {

        this.uri = uri;
        return loadImage;
    }

    /**
     * start downloading the image
     */
    public void build(@NonNull Context context) {
        if (imageView != null) {

            imageView.getHierarchy().setPlaceholderImage(ID_RES_PLACEHOLDER_IMAGE);
            imageView.getHierarchy().setFailureImage(ID_RES_PLACEHOLDER_IMAGE);
            imageView.getHierarchy().setRetryImage(ID_RES_PLACEHOLDER_IMAGE);
            imageView.getHierarchy().setProgressBarImage(ID_RES_PLACEHOLDER_IMAGE);

            if (uri != null) {
                imageView.setImageURI(uri);

                if (Uri.EMPTY.equals(uri)) {
                    imageView.setImageResource(R.mipmap.ic_launcher_round);
                }
            }
            if (roundAsCircle) {
                int color = context.getResources().getColor(ID_COLOR_BORDER_CIRCLE);
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(6f);
                if (showBorder)
                    roundingParams.setBorder(color, 7.0f);
                roundingParams.setRoundAsCircle(true);
                imageView.getHierarchy().setRoundingParams(roundingParams);
            }
        }
    }

    /**
     * clear cache of images using ImagePipeline
     */
    public static void clearCache() {
        //
        ImagePipeline imagePipeline = com.facebook.drawee.backends.pipeline.Fresco.getImagePipeline();
        imagePipeline.clearMemoryCaches();
        imagePipeline.clearDiskCaches();
        // combines above two lines
        imagePipeline.clearCaches();
    }
}