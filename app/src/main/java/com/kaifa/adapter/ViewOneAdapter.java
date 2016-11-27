package com.kaifa.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaifa.Bean.ViewOneBean;
import com.kaifa.weixinjiemian.R;

import java.util.ArrayList;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/17 14:22
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class ViewOneAdapter extends BaseAdapter {
    private ArrayList<ViewOneBean> mArrayList;
    private LayoutInflater mInflater;
    private ViewHolder holder = null;
    Handler mHandler = new Handler();
    public  ViewOneAdapter(ArrayList<ViewOneBean> arrayList, Context context){
        mArrayList = arrayList;
        mInflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return mArrayList.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        holder = null;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.layout_view1_item,null);
            holder.iv1 = (ImageView) convertView.findViewById(R.id.iv1_view1);
            holder.iv2 = (ImageView) convertView.findViewById(R.id.iv2_view1);
            holder.tv1 = (TextView) convertView.findViewById(R.id.tv1_view1);
            holder.tv2 = (TextView) convertView.findViewById(R.id.tv2_view1);
            holder.tv3 = (TextView) convertView.findViewById(R.id.tv3_view1);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.iv1.setImageResource(mArrayList.get(position).getIcon1());
      //  holder.iv2.setImageResource(mArrayList.get(position).getIcon2());
        holder.tv1.setText(mArrayList.get(position).getText1());
        holder.tv2.setText(mArrayList.get(position).getText2());
        holder.tv3.setText(mArrayList.get(position).getText3());
        return convertView;
    }
    class ViewHolder{
       ImageView iv1;
       ImageView iv2;
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }
}
