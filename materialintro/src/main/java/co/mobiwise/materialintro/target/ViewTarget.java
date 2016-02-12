package co.mobiwise.materialintro.target;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by mertsimsek on 25/01/16.
 */
public class ViewTarget implements Target{

    private View view;

    private int x, y, width, height;

    public ViewTarget(View view) {
        this.view = view;
    }

    private void evalSpecs(){
        // If showcaseViewCase : the view specs has to be evaluated differently
        int[] location = new int[2];
        view.getLocationInWindow(location);

        if(0 == location[0] && 0 == location[1]){
            x = (int) view.getX();
            y = (int) view.getY();
        } else {
            x = location[0];
            y = location[1];
        }

        if(0 == view.getWidth()){
            width = view.getMeasuredWidth();
        } else {
            width = view.getWidth();
        }

        if(0 == view.getHeight()){
            height = view.getMeasuredHeight();
        } else {
            height = view.getHeight();
        }
    }

    @Override
    public Point getPoint() {

        evalSpecs();

        // Center of the view
        return new Point(x + (width / 2), y + (height / 2));
    }

    @Override
    public Rect getRect() {

        evalSpecs();

        return new Rect(
                x,
                y,
                x + width,
                y + height
        );
    }

    @Override
    public View getView() {
        return view;
    }

}
