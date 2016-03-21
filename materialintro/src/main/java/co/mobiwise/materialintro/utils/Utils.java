package co.mobiwise.materialintro.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by mertsimsek on 29/01/16.
 */
public class Utils {

    public static int pxToDp(int px){
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int dpToPx(int dp){
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static boolean isViewTouched(MotionEvent event, View view){
        // TODO
        
        float x = event.getX();
        float y = event.getY();

        float vx = view.getX();
        float vy = view.getY();

        float vWidth = view.getWidth();
        float vHeight = view.getHeight();
        
        return x > (vx - vWidth / 2) &&
                x < (vx + vWidth / 2) &&
                y > (vy - vHeight / 2) &&
                y < (vy + vHeight / 2);
    }

    public static View prepareShowcaseView(View view) {

        RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        newParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        view.setLayoutParams(newParams);

        return view;
    }

    public static String valueOrDefault(String string, String defaultString) {
        return isNullOrEmpty(string) ? defaultString : string;
    }

    public static boolean isNullOrEmpty(CharSequence s) {
        return s == null || s.length() == 0;
    }
}
