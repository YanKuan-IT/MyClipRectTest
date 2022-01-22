package com.example.mycliprecttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class MyClipRectView extends View {
    public MyClipRectView(Context context) {
        super(context);
    }
    public MyClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyClipRectView(Context context, @Nullable AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // ****** 先给当前的屏幕设置一个矩形画面 **********
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, measuredWidth, measuredHeight, paint);

        // ***************************** 演示1 *****************************
//        Rect rect = new Rect(0, 0, measuredWidth/2, measuredHeight/3);
//        canvas.clipRect(rect);
//        canvas.drawColor(Color.BLUE);

        // ***************************** 演示2 *****************************
//        // 第一次
//        Rect rect = new Rect(0, 0, 500, 500);
//        canvas.clipRect(rect);
//        // 第二次
//        rect = new Rect(300, 300, 800, 800);
//        canvas.clipRect(rect, Region.Op.DIFFERENCE);
//        canvas.drawColor(Color.RED);

        // ***************************** 演示3 *****************************
        canvas.save();

        // 第一次
        Rect rect = new Rect(0, 0, 500, 500);
        canvas.clipRect(rect);
        canvas.drawColor(Color.BLUE);

        canvas.restore();

        // 第二次
        rect = new Rect(300, 300, 800, 800);
        canvas.clipRect(rect, Region.Op.INTERSECT);
        canvas.drawColor(Color.RED);

    }
}