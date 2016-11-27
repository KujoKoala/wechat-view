package com.kaifa.weixinjiemian;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.kaifa.View.Bullet1;
import com.kaifa.View.Enemy1;
import com.kaifa.View.PlaneView;

import java.util.ArrayList;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/19 11:27
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class PlayActivity extends Activity {
    private int speed = 10;
    PlaneView planeView;
    private Context mContext;
    private RelativeLayout relativeLayout;
    //private ArrayList<Bullet1> al = new ArrayList<>();
    private ArrayList<Enemy1> al_Enemy = new ArrayList<>();
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x123){
                Bullet1 mBullet1 = new Bullet1(mContext);
                mBullet1.currentX = planeView.currentX + 150;
                mBullet1.currentY = planeView.currentY;
                relativeLayout.addView(mBullet1);

//                al.add(mBullet1);
                new Thread(new BulletGuiJi(mBullet1)).start();
            }
        }
    };
    private Handler mHandler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x456){
                WindowManager windowManager = getWindowManager();
                Display display = windowManager.getDefaultDisplay();
                final DisplayMetrics metrics = new DisplayMetrics();
                display.getMetrics(metrics);
                Enemy1 enemy1 = new Enemy1(mContext);
                enemy1.currentX = (int)((Math.random()*metrics.widthPixels)-130);
                //             enemy1.currentX = 400;
                enemy1.currentY = -5;
                if(al_Enemy.size()>2)
                    al_Enemy.clear();
                al_Enemy.add(enemy1);
               relativeLayout.addView(enemy1);
                new Thread(new EnemyGuiji(enemy1)).start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mContext = this;
        //final LinearLayout layout = new LinearLayout(mContext);
        relativeLayout = new RelativeLayout(mContext);
        setContentView(relativeLayout);
        planeView  = new PlaneView(this);
        relativeLayout.addView(planeView);
        relativeLayout.setBackgroundResource(R.drawable.background);
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        final DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        planeView.currentX = metrics.widthPixels /2 -150;
        planeView.currentY = metrics.heightPixels /2+450;
        //不断生成子弹
        new Thread(){
            @Override
            public void run() {
                while(true){
                    Message message = new Message();
                    message.what = 0x123;
                    mHandler.sendMessage(message);
                    try{Thread.sleep(300);}catch (Exception e){}
                }
            }
         }.start();
        //不断生成敌机
        new Thread(){
            @Override
            public void run() {
                while(true){
                    Message message = new Message();
                    message.what = 0x456;
                    mHandler2.sendMessage(message);
                    try{Thread.sleep(3000);}catch (Exception e){}
                }
            }
        }.start();
        /*final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            Bullet1 bullet1;
            @Override
            public void run() {
                                    int t = al.size();
                                    for(int i=0; i<t; i++) {
                                        bullet1 = al.get(i);
                                        bullet1.currentY -= 10;
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                bullet1.invalidate();
                                                Log.d("BulletGuiJi","我已经改变了");
                                            }
                                        });
                                    }
            }
        },0,200);*/


    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getX()-planeView.currentX<360 && event.getY()-planeView.currentY<360
                && planeView.currentX-event.getX()<180 && planeView.currentY - event.getY()<180){
            planeView.currentX = event.getX()-180;
            planeView.currentY = event.getY()-180;
            planeView.invalidate();

        }

        return true;
    }
    class BulletGuiJi extends Thread{
        Bullet1 bullet1;
        public BulletGuiJi(Bullet1 bulletGuiJi){
            bullet1 = bulletGuiJi;
        }
        @Override
        public void run() {
        int account = 0;
            while(true){
                bullet1.currentY-=35;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bullet1.invalidate();
                    }
                });
                if(check_bullet(bullet1)){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Snackbar.make(planeView,"打中了",Snackbar.LENGTH_SHORT).show();
                        }
                    });
                }
               try{Thread.sleep(20);}catch (Exception e){}
                account++;
                if(account>55)
                    break;
            }
        }
    }
    class EnemyGuiji extends Thread{
        Enemy1 mEnemy1;
        public EnemyGuiji(Enemy1 enemy1){
            mEnemy1 = enemy1;
        }
        @Override
        public void run() {
           int account = 0;
            while(true){

          /*      runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TranslateAnimation ta = new TranslateAnimation(0,0,0,mEnemy1.currentY);
                        ta.setDuration(5000); //设置动画执行的时间
                        ta.setFillAfter(true);//当动画结束后 动画停留在结束位置

                        //开始动画
                        mEnemy1.startAnimation(ta);
                    }
                });
*/
               mEnemy1.currentY+=30;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEnemy1.invalidate();
                    }
                });
                if(check_enemy(mEnemy1)){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Snackbar.make(planeView,"撞机了",Snackbar.LENGTH_SHORT).show();
                        }
                    });

                }
                try{Thread.sleep(80);}catch (Exception e){}
                account++;
                if(account>65)
                    break;

            }
        }
    }
    public boolean check_enemy(Enemy1 enemy1){
        if(enemy1.currentX>planeView.currentX && enemy1.currentX+160<planeView.currentX+360 && enemy1.currentY>planeView.currentY
                   && enemy1.currentY+160<planeView.currentY+360)
            return true;
        if(enemy1.currentX<planeView.currentX && enemy1.currentX+160>planeView.currentX && enemy1.currentY+160>planeView.currentY
                && enemy1.currentY<planeView.currentY+360)
            return true;

        if(enemy1.currentX+160>planeView.currentX+360 && enemy1.currentX<planeView.currentX+360 && enemy1.currentY+160>planeView.currentY
                && enemy1.currentY<planeView.currentY+160)
            return true;

        if(enemy1.currentX>planeView.currentX && enemy1.currentX+160<planeView.currentX+360 && enemy1.currentY+43>planeView.currentY
                && enemy1.currentY<planeView.currentY+160)
            return true;

        return false;
    }
    public boolean check_bullet(Bullet1 bullet1){
        for(int i=0; i<al_Enemy.size(); i++){
            if(bullet1.currentX+5>al_Enemy.get(i).currentX && bullet1.currentX+5<al_Enemy.get(i).currentX+160 && bullet1.currentY<al_Enemy.get(i).currentY+160){
                return true;
            }
        }

        return false;
    }
}


