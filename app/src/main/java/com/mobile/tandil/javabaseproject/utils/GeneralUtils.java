package com.mobile.tandil.javabaseproject.utils;

import android.content.Context;
import android.widget.Toast;

public class GeneralUtils {

    public static void showToast(Context context, String output) {
        if (context != null) {
            Toast.makeText(context, output, Toast.LENGTH_SHORT).show();
        }
    }

}
