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
 * @创建时间   2016/11/19 12:31
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class Bullet1 extends View {
    public float currentX;
    public float currentY;
    Bitmap bullet;
    public Bullet1(Context context){
        super(context);
        bullet = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet1);
        setFocusable(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(bullet,currentX,currentY,p);
    }
}
