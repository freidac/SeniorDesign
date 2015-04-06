package seniordesign.seniordesign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class MyView extends View
{// was View

    public MyView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

    }


    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius;

        radius = 10;//sets radius for bullet size
        Paint paint = new Paint();
        //paint.setStyle(Paint.Style.FILL);
        //paint.setColor(Color.TRANSPARENT);
        //canvas.drawPaint(paint);
        //Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1, 350, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x >> 1, y >> 1, 275, paint);
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1, 200, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x >> 1, y >> 1, 125, paint);
        paint.setColor(Color.parseColor("#800000"));
        canvas.drawCircle(x >> 1, y >> 1, 50, paint);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(500, 622, 10, paint);
        canvas.drawCircle(300, 300, radius, paint);
        canvas.drawCircle(600, 650, radius, paint);
        canvas.drawCircle(700, 650, radius, paint);
        canvas.drawCircle(800, 650, radius, paint);

        super.onDraw(canvas);
    }
}