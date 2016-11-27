package com.kaifa.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaifa.Bean.ViewOneBean;
import com.kaifa.weixinjiemian.R;

import java.io.InputStream;
import java.util.ArrayList;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/25 23:05
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<ViewOneBean> mArrayList;
    private Context mContext;
    public RecyclerViewAdapter(ArrayList<ViewOneBean> arrayList,Context context){
        mArrayList = arrayList;
        mContext = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.layout_view1_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        holder.iv1.setImageResource(mArrayList.get(position).getIcon1());
        Bitmap bitmap = readBitMap(mContext,mArrayList.get(position).getIcon1());

        holder.iv1.setImageBitmap(bitmap);
        holder.tv1.setText(mArrayList.get(position).getText1());
        holder.tv2.setText(mArrayList.get(position).getText2());
        holder.tv3.setText(mArrayList.get(position).getText3());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv1;
        ImageView iv2;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        public MyViewHolder(View view)
        {
            super(view);
            iv1 = (ImageView) view.findViewById(R.id.iv1_view1);
            iv2 = (ImageView) view.findViewById(R.id.iv2_view1);
            tv1 = (TextView) view.findViewById(R.id.tv1_view1);
            tv2 = (TextView) view.findViewById(R.id.tv2_view1);
            tv3 = (TextView) view.findViewById(R.id.tv3_view1);
        }
    }
    private Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
//        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;         //If this is set to true, then the
                                        // resulting bitmap will allocate its pixels such that they can be purged if the system needs to reclaim memory.
        opt.inInputShareable = true;
        // 获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
}
