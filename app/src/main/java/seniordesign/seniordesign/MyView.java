package seniordesign.seniordesign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.util.Log;



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
        Log.i("Center: ", String.valueOf(center_point_x));
        Log.i("Center: ", String.valueOf(center_point_y));

        int radius;

        radius = 10;//sets radius for bullet size
        Paint paint = new Paint();
        //Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#800000"));//outer radius biggest
        canvas.drawCircle(center_point_x, center_point_y, 350, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(center_point_x, center_point_y, 275, paint);//next circle
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(center_point_x, center_point_y, 200, paint);//next circle
        paint.setColor(Color.BLACK);
        canvas.drawCircle(center_point_x, center_point_y, 125, paint);//so on
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(center_point_x, center_point_y, 50, paint);// you get the pic
        paint.setColor(Color.WHITE);
        canvas.drawCircle(500, 622, radius, paint);
        canvas.drawCircle(300, 300, radius, paint);
        canvas.drawCircle(600, 650, radius, paint);
        canvas.drawCircle(700, 650, radius, paint);
        canvas.drawCircle(800, 650, radius, paint);
        canvas.drawCircle(center_point_x, center_point_y, radius, paint);

        super.onDraw(canvas);
    }
}