package com.beshoy.development.util;

import android.view.View;

import com.blankj.utilcode.util.SnackbarUtils;

/**
 * Created by Bsamy on 14/12/2017.
 */

public class ShowSnackBar {

    private ShowSnackBar() {}

    public static void showMSG(View parent, String msg){
        SnackbarUtils.with(parent)
                .setMessage(msg)
                .show();
    }

    public static void showError(View parent, String msg){
        SnackbarUtils.with(parent)
                .setDuration(SnackbarUtils.LENGTH_LONG)
                .setMessage(msg)
                .showError();
    }

    public static void showWarning(View parent, String msg){
        SnackbarUtils.with(parent)
                .setMessage(msg)
                .showWarning();
    }

    public static void showSuccess(View parent, String msg){
        SnackbarUtils.with(parent)
                .setMessage(msg)
                .showSuccess();
    }

}
