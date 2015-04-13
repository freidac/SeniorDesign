package seniordesign.seniordesign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.util.Log;


public class MyView extends View {// was View
    private int mWidth;
    private int mHeight;


    public static int center_point_x;
    public static int center_point_y;
    public static int Radius1 ;
    public static int Radius2 ;
    public static int Radius3 ;
    public static int Radius4 ;
    public static int Radius5 ;
    public static int pixels;
    public static double cmtopix;



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
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final float screenWidthInDp=metrics.widthPixels/metrics.density;
        final float screenHeightInDp=metrics.heightPixels/metrics.density;//get dps height of the screen
        int density = metrics.densityDpi;
        pixels = (int) (screenHeightInDp/22 *(density / 160));
        Radius1 = 4 *pixels;
        Radius2 = 3 *pixels;
        Radius3 = 2*pixels;
        Radius4 = pixels;
        Radius5 = pixels/2;
        int x = getWidth();
        int y = getHeight();
        center_point_x = x >>1;
        center_point_y = y >>1;

        cmtopix = pixels/2.54;
        Log.i("1 Cm :", String.valueOf(cmtopix));

        Paint paint = new Paint();
        //Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1,Radius1, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x >> 1, y >> 1, Radius2, paint);
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1, Radius3, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x >> 1, y >> 1, Radius4, paint);
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1, Radius5, paint);

//must negate on y axis in cm to pix. 0,0 is top left corner x,x with x being largest size of screen cordinates is in bottom right.
        for (int i = 0 ; i< Startsession.count; i+=2)
            {
                    paint.setColor(Color.WHITE);
                    canvas.drawCircle((int)(Startsession.target_shots[i] *cmtopix + center_point_x) , (int)(Startsession.target_shots[i+1] *-cmtopix + center_point_y), pixels/9, paint);
            }


        super.onDraw(canvas);
        invalidate();// redraws canvas
    }

}