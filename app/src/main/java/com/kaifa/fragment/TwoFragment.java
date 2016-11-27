package com.kaifa.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.kaifa.Bean.ViewTwoBean;
import com.kaifa.adapter.ViewTwoAdapter;
import com.kaifa.weixinjiemian.R;
import com.kaifa.weixinjiemian.SideBar;

import java.util.ArrayList;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/12 21:11
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class TwoFragment extends Fragment {
    private ListView               lv;
    private ArrayList<ViewTwoBean> al;//用户好友数据
    private ArrayList<ViewTwoBean> al_weiXinShuJu; //微信客户端数据
    private ViewTwoBean            bean;
    private SideBar sidebar;
    private TextView dialog;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        al = new ArrayList<>();
        al_weiXinShuJu = new ArrayList<>();
        ViewTwoBean bean1 = new ViewTwoBean();
        bean1.setIcon(R.drawable.a_b);
        bean1.setText("新朋友");

        ViewTwoBean bean2 = new ViewTwoBean();
        bean2.setIcon(R.drawable.default_chatroom);
        bean2.setText("群聊");

        ViewTwoBean bean3 = new ViewTwoBean();
        bean3.setIcon(R.drawable.a_n);
        bean3.setText("标签");

        ViewTwoBean bean4 = new ViewTwoBean();
        bean4.setIcon(R.drawable.default_servicebrand_contact);
        bean4.setText("公众号");
        al_weiXinShuJu.add(bean1);
        al_weiXinShuJu.add(bean2);
        al_weiXinShuJu.add(bean3);
        al_weiXinShuJu.add(bean4);

        //模拟数据
        for(int i=0; i<120; i++){
            bean = new ViewTwoBean();
            if(i<10){
                bean.setText("a"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("A");
                if(i==0)bean.setType(0);
                else bean.setType(1);
            }else if (i<20){
                bean.setText("b"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("B");
                if(i==10)bean.setType(0);
                else bean.setType(1);
            }else if (i<30){
                bean.setText("c"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("C");
                if(i==20)bean.setType(0);
                else bean.setType(1);
            }else if (i<40){
                bean.setText("d"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("D");
                if(i==30)bean.setType(0);
                else bean.setType(1);
            }else if (i<50){
                bean.setText("e"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("E");
                if(i==40)bean.setType(0);
                else bean.setType(1);
            }else if (i<60){
                bean.setText("f"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("F");
                if(i==50)bean.setType(0);
                else bean.setType(1);
            }else if (i<70){
                bean.setText("g"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("G");
                if(i==60)bean.setType(0);
                else bean.setType(1);
            }else if (i<80){
                bean.setText("h"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("H");
                if(i==70)bean.setType(0);
                else bean.setType(1);
            } else if (i<90){
                bean.setText("i"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("I");
                if(i==80)bean.setType(0);
                else bean.setType(1);
            }else if (i<100){
                bean.setText("j"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("J");
                if(i==90)bean.setType(0);
                else bean.setType(1);
            }else if (i<110){
              bean.setText("z"+i);
               bean.setIcon(R.drawable.touxiang);
               bean.setfirstChar("Z");
                if(i==100)bean.setType(0);
                else bean.setType(1);

            }else if (i<120){
                bean.setText("1"+i);
                bean.setIcon(R.drawable.touxiang);
                bean.setfirstChar("#");
                if(i==110)bean.setType(0);
                else bean.setType(1);
            }
            al.add(bean);
        }

        lv = (ListView)getActivity().findViewById(R.id.view2_lv);
        sidebar = (SideBar) getActivity().findViewById(R.id.sidebar);
        dialog = (TextView) getActivity().findViewById(R.id.dialog);
        sidebar.setTextView(dialog);
        // 设置字母导航触摸监听
        sidebar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                // TODO Auto-generated method stub
                // 该字母首次出现的位置
                //int position = sortadapter.getPositionForSelection(s.charAt(0));
                int position = -1;
                for(int i=0; i<al.size(); i++){
                    if(s.charAt(0)=='↑'){
                        position=0;
                        break;
                    }
                    if(al.get(i).getText().toUpperCase().charAt(0)==s.charAt(0)){
                        position = i;
                        break;
                    }
                    if(al.get(i).getText().charAt(0)>=40 && al.get(i).getText().charAt(0)<=49 &&s.charAt(0)=='#'){
                        position = i;
                        break;
                    }
                }
                if (position != -1) {
                    lv.setSelection(position);
                }
            }
        });


        lv.setAdapter(new ViewTwoAdapter(al, getActivity(),al_weiXinShuJu));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.layout_view2,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
