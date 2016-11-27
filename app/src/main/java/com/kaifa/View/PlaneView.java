package com.kaifa.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.kaifa.weixinjiemian.R;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/19 11:28
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class PlaneView extends View {
    public float currentX;
    public float currentY;
    Bitmap plane;
    public PlaneView(Context context){
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        setFocusable(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(plane, currentX, currentY, p);
    }
}
