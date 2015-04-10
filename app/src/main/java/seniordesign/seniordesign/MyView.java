package seniordesign.seniordesign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.util.Log;

/** */
//
public class MyView extends View {// was View
    //private Bitmap bmp;
    private int mWidth;
    private int mHeight;
    public static int center_point_x;
    public static int center_point_y;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        mHeight = View.MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(mWidth, mHeight);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        center_point_x = x >>1;
        center_point_y = y >>1;
        // Log.i("Center: ", String.valueOf(center_point_x));
        // Log.i("Center: ", String.valueOf(center_point_y));

        int radius;
        float cmtopix = (float) 35.43;
        radius = 10;//sets radius for bullet size
        Paint paint = new Paint();
        //paint.setStyle(Paint.Style.FILL);
        //paint.setColor(Color.TRANSPARENT);
        //canvas.drawPaint(paint);
        //Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1, 5*90, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x >> 1, y >> 1, 4*90, paint);
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1, 3*90, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x >> 1, y >> 1, 2*90, paint);
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1, 90, paint);
        //Log.i("VAlue of first", String.valueOf(MainActivity.target_shots[0]));

        for (int i = 0 ; i< MainActivity.target_shots.length ; i+=2)
        {
            if(MainActivity.target_shots[i]!= 99999) {
                paint.setColor(Color.WHITE);
                canvas.drawCircle(MainActivity.target_shots[i] *cmtopix + center_point_x , MainActivity.target_shots[i + 1]*cmtopix + center_point_y, 10, paint);
            }
            //Log.i("Where it should map", String.valueOf(MainActivity.target_shots[i]));
            // MainActivity.target_shots[i];
        }
        //paint.setColor(Color.WHITE);

        // canvas.drawCircle((float) (2.54 * cmtopix + center_point_x), 0 * cmtopix + center_point_y, 10, paint);
        Log.i("x coordinate", String.valueOf(2.54*1 * cmtopix + center_point_x));
        Log.i("y coordinate", String.valueOf(2.54*0*cmtopix+center_point_y));

        super.onDraw(canvas);
    }
}