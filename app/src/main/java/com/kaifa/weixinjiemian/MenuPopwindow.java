package com.kaifa.weixinjiemian;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.kaifa.Bean.MenuPopwindowBean;
import com.kaifa.adapter.PopmenuAdapter;

import java.util.List;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/13 14:51
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class MenuPopwindow extends PopupWindow {

    private View     conentView;
    private ListView lvContent;
    private Context mContext;
    private View snackBarView;
    public MenuPopwindow(final Activity context, List<MenuPopwindowBean> list,View view) {
        mContext = context;
        snackBarView = view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.layout_popwindow, null);
        lvContent = (ListView) conentView.findViewById(R.id.lv_toptitle_menu);
        lvContent.setAdapter(new PopmenuAdapter(context, list));
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(context,"你点击了第"+(position+1)+"个选项",Toast.LENGTH_SHORT).show();
                Snackbar.make(snackBarView,"你点击了第"+(position+1)+"个选项",Snackbar.LENGTH_SHORT).show();
            }
        });

        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽

        this.setWidth(w/3+w/4);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);

    }
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent,0,0);

        } else {
            this.dismiss();
        }

    }
}

