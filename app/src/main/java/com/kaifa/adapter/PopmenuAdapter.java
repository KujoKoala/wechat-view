package com.kaifa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaifa.Bean.MenuPopwindowBean;
import com.kaifa.weixinjiemian.R;

import java.util.List;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/13 14:53
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class PopmenuAdapter extends BaseAdapter{

        private List<MenuPopwindowBean> list;
        private LayoutInflater          inflater;
        private Context mContext;
        public PopmenuAdapter(Context context, List<MenuPopwindowBean> list) {
            mContext = context;
            inflater = LayoutInflater.from(context);
            this.list = list;
        }
        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.layout_popmenuadapteritem, null);
                holder = new Holder();
                holder.ivItem = (ImageView) convertView.findViewById(R.id.iv_menu_item);
                holder.tvItem = (TextView) convertView.findViewById(R.id.tv_menu_item);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            holder.ivItem.setImageResource(list.get(position).getIcon());
//            holder.ivItem.setAlpha(0);
            holder.tvItem.setText(list.get(position).getText());
            return convertView;
        }
        class Holder {
            ImageView ivItem;
            TextView tvItem;
        }
}
