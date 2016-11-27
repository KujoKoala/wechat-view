package com.kaifa.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaifa.Bean.ViewTwoBean;
import com.kaifa.weixinjiemian.R;

import java.util.ArrayList;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/14 15:42
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class ViewTwoAdapter extends BaseAdapter {
    private ArrayList<ViewTwoBean> al;
    private ArrayList<ViewTwoBean> al_weiXinShuJu;
    private LayoutInflater mInflater;
    private String stringTemp;
    private String tempCompare = "";
    public ViewTwoAdapter(ArrayList<ViewTwoBean> al, Context context,ArrayList<ViewTwoBean> al_weiXinShuJu) {
        this.al = al;
        this.al_weiXinShuJu = al_weiXinShuJu;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return al.size()+al_weiXinShuJu.size()+1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(position<4){
            ViewTwoBean bean = al_weiXinShuJu.get(position);
            convertView = mInflater.inflate(R.layout.layout_view2_type1,null);
            ImageView imageView  = (ImageView) convertView.findViewById(R.id.view2_image_type1);
            TextView textView = (TextView) convertView.findViewById(R.id.view2_tv_type1);
            imageView.setImageResource(bean.getIcon());
            textView.setText(bean.getText());
        }else if(position<(al.size()+al_weiXinShuJu.size())){

            ViewTwoBean bean = al.get(position-4);
            stringTemp = bean.getfirstChar().toUpperCase();
            if(bean.getType()==0 ){
                convertView = mInflater.inflate(R.layout.layout_view2_type0,null);
                ImageView imageView  = (ImageView) convertView.findViewById(R.id.view2_image_type0);
                TextView textView1 = (TextView) convertView.findViewById(R.id.view2_tv_type0_1);
                TextView textView2 = (TextView) convertView.findViewById(R.id.view2_tv_type0_0);
                imageView.setImageResource(bean.getIcon());
                textView1.setText(bean.getText());
                textView2.setText(stringTemp);
                Log.d("position",position-4+"---"+bean.getType());
            }else if(bean.getType()==1){
                convertView = mInflater.inflate(R.layout.layout_view2_type1,null);
                ImageView imageView  = (ImageView) convertView.findViewById(R.id.view2_image_type1);
                TextView textView = (TextView) convertView.findViewById(R.id.view2_tv_type1);
                imageView.setImageResource(bean.getIcon());
                textView.setText(bean.getText());
                Log.d("position",position-4+"---"+bean.getType());
            }
            //tempCompare = stringTemp;
        }else {
            convertView = mInflater.inflate(R.layout.layout_view2_tongji_textview,null);
            TextView tv = (TextView) convertView.findViewById(R.id.tongji_tv);
            tv.setText(al.size()+al_weiXinShuJu.size()+"位联系人");
        }

        return convertView;
    }
}
