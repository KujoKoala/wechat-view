package com.kaifa.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kaifa.weixinjiemian.MainActivity;
import com.kaifa.weixinjiemian.PlayActivity;
import com.kaifa.weixinjiemian.R;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/12 21:11
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class ThreeFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_view3,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayout l1 = (LinearLayout)getActivity().findViewById(R.id.item_view3_1);
        l1.setOnClickListener(this);
        LinearLayout l2 = (LinearLayout)getActivity().findViewById(R.id.item_view3_2);
        l2.setOnClickListener(this);
        LinearLayout l3 = (LinearLayout)getActivity().findViewById(R.id.item_view3_3);
        l3.setOnClickListener(this);
        LinearLayout l4 = (LinearLayout)getActivity().findViewById(R.id.item_view3_4);
        l4.setOnClickListener(this);
        LinearLayout l5 = (LinearLayout)getActivity().findViewById(R.id.item_view3_5);
        l5.setOnClickListener(this);
        LinearLayout l6 = (LinearLayout)getActivity().findViewById(R.id.item_view3_6);
        l6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_view3_1: Snackbar.make(getView(),"(3,1)",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item_view3_2: Snackbar.make(getView(),"(3,2)",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item_view3_3: Snackbar.make(getView(),"(3,3)",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item_view3_4: Snackbar.make(getView(),"(3,4)",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item_view3_5: Snackbar.make(getView(),"(3,5)",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item_view3_6:
                Intent intent = new Intent(MainActivity.mContext, PlayActivity.class);
                startActivity(intent);
                break;
        }
    }
}
