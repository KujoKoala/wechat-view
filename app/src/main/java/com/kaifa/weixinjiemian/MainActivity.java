package com.kaifa.weixinjiemian;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kaifa.Bean.MenuPopwindowBean;
import com.kaifa.fragment.FourFragment;
import com.kaifa.fragment.OneFragment;
import com.kaifa.fragment.ThreeFragment;
import com.kaifa.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private View view1, view2, view3,view4;
    private ViewPager      mViewPager;  //对应的viewPager
    private TabLayout      mTablayout;
    private List<View>     viewList;//view数组
    private TabLayout.Tab  one;
    private TabLayout.Tab  two;
    private TabLayout.Tab  three;
    private TabLayout.Tab  four;
    private List<Fragment> mList;
    public static Context mContext;
    private TextView mTextView_jiaHao;
    private TextView mTextView_suoSuo;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this;
        //----------------
        mTablayout= (TabLayout) findViewById(R.id.tabLayout);
        mViewPager= (ViewPager) findViewById(R.id.viewPager);
        mTextView_jiaHao = (TextView) findViewById(R.id.tv_menu_item);
        mTextView_suoSuo = (TextView) findViewById(R.id.tv_menu_item_sousuo);
        mList = new ArrayList<>();
   //     mList.add(OneFragment.(mTitles[0], "fragment_1"));
        mList.add(new OneFragment());
        mList.add(new TwoFragment());
        mList.add(new ThreeFragment());
        mList.add(new FourFragment());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mList.get(position);
            }
            private String[] mTitles = new String[]{"微信", "通讯录", "发现","我"};
            @Override
            public int getCount() {
                return mTitles.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

        });

        mTablayout.setupWithViewPager(mViewPager);

        one = mTablayout.getTabAt(0);
        two = mTablayout.getTabAt(1);
        three = mTablayout.getTabAt(2);
        four = mTablayout.getTabAt(3);

        one.setIcon(getResources().getDrawable(R.drawable.al_));
        two.setIcon(getResources().getDrawable(R.drawable.al9));
        three.setIcon(getResources().getDrawable(R.drawable.alc));
        four.setIcon(getResources().getDrawable(R.drawable.ale));

        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == mTablayout.getTabAt(0)) {
                    one.setIcon(getResources().getDrawable(R.drawable.al_));
                    mViewPager.setCurrentItem(0,false);
                } else if (tab == mTablayout.getTabAt(1)) {
                    two.setIcon(getResources().getDrawable(R.drawable.al8));
                    mViewPager.setCurrentItem(1,false);
                } else if (tab == mTablayout.getTabAt(2)) {
                    three.setIcon(getResources().getDrawable(R.drawable.alb));
                    mViewPager.setCurrentItem(2,false);
                }else if (tab == mTablayout.getTabAt(3)){
                    four.setIcon(getResources().getDrawable(R.drawable.ald));
                    mViewPager.setCurrentItem(3,false);
                }
                picXiuFu(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
            public void picXiuFu(TabLayout.Tab tab){
                if (tab == mTablayout.getTabAt(0)) {

                    two.setIcon(getResources().getDrawable(R.drawable.al9));
                    three.setIcon(getResources().getDrawable(R.drawable.alc));
                    four.setIcon(getResources().getDrawable(R.drawable.ale));
                } else if (tab == mTablayout.getTabAt(1)) {
                    one.setIcon(getResources().getDrawable(R.drawable.ala));
                    three.setIcon(getResources().getDrawable(R.drawable.alc));
                    four.setIcon(getResources().getDrawable(R.drawable.ale));

                } else if (tab == mTablayout.getTabAt(2)) {
                    one.setIcon(getResources().getDrawable(R.drawable.ala));
                    two.setIcon(getResources().getDrawable(R.drawable.al9));
                    four.setIcon(getResources().getDrawable(R.drawable.ale));

                }else if (tab == mTablayout.getTabAt(3)){
                    one.setIcon(getResources().getDrawable(R.drawable.ala));
                    two.setIcon(getResources().getDrawable(R.drawable.al9));
                    three.setIcon(getResources().getDrawable(R.drawable.alc));


                }
            }
        });

        mTextView_jiaHao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int[] icons = {R.drawable.filehelper_1479002840556_92, R.drawable.filehelper_1479002840608_8
                        ,R.drawable.filehelper_1479002840622_79,R.drawable.filehelper_1479002840635_42
                        ,R.drawable.filehelper_1479002840647_95};
                String[] texts = {"发起群聊", "添加朋友","扫一扫","收付款","帮助与反馈"};
                List<MenuPopwindowBean> list = new ArrayList<>();
                MenuPopwindowBean bean = null;
                for (int i = 0; i < icons.length; i++) {
                    bean = new MenuPopwindowBean();
                    bean.setIcon(icons[i]);
                    bean.setText(texts[i]);
                    list.add(bean);
                }

                MenuPopwindow pw = new MenuPopwindow(MainActivity.this, list,mTablayout);


                pw.showPopupWindow(mTextView_jiaHao);
            }
        });
        mTextView_suoSuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"你点击了搜索菜单",Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }



}
