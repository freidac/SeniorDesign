package seniordesign.seniordesign;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class MyView extends View
{// was View
    private Bitmap bmp;

    public MyView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.target_acc);
        // init();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius;
        radius = 10;
        Paint paint = new Paint();
        // paint.setStyle(Paint.Style.FILL);
        //paint.setColor(Color.TRANSPARENT);
        //canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawBitmap(bmp,0,0,null);
        canvas.drawCircle(x/2 , y/2 , radius, paint);
        canvas.drawCircle(450 , 450 , radius, paint);
        super.onDraw(canvas);
        //myImageView.setImage

    }
}