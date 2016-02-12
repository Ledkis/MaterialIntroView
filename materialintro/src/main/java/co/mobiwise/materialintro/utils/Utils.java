package co.mobiwise.materialintro.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
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

    public static View prepareShowcaseView(Activity activity, View view) {

        RelativeLayout.LayoutParams showcaseParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        view.setLayoutParams(showcaseParams);

        // http://stackoverflow.com/questions/1016896/get-screen-dimensions-in-pixels
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int widthWin = size.x;
        int heightWin = size.y;

        // http://stackoverflow.com/questions/8200896/how-to-find-the-width-of-the-a-view-before-the-view-is-displayed
        view.measure(widthWin, heightWin);

        float width = view.getMeasuredWidth();
        float height = view.getMeasuredHeight();

        float xPx = (widthWin - width) / 2;
        float yPx = (heightWin - height) / 2;

        view.setX(xPx);
        view.setY(yPx);

        return view;
    }
}
