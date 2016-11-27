package com.kaifa.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kaifa.weixinjiemian.R;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/12 21:12
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
*/

public class FourFragment extends Fragment implements View.OnClickListener{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayout l1 = (LinearLayout)getActivity().findViewById(R.id.item_view4_1);
        l1.setOnClickListener(this);
        LinearLayout l2 = (LinearLayout)getActivity().findViewById(R.id.item_view4_2);
        l2.setOnClickListener(this);
        LinearLayout l3 = (LinearLayout)getActivity().findViewById(R.id.item_view4_3);
        l3.setOnClickListener(this);
        LinearLayout l4 = (LinearLayout)getActivity().findViewById(R.id.item_view4_4);
        l4.setOnClickListener(this);
        LinearLayout l5 = (LinearLayout)getActivity().findViewById(R.id.item_view4_5);
        l5.setOnClickListener(this);
        LinearLayout l6 = (LinearLayout)getActivity().findViewById(R.id.item_view4_6);
        l6.setOnClickListener(this);
        LinearLayout l7 = (LinearLayout)getActivity().findViewById(R.id.item_view4_7);
        l7.setOnClickListener(this);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*View view = inflater.inflate(R.layout.layout_view4,null);
        ImageView imageView1 = (ImageView) view.findViewById(R.id.image1);
        imageView1.setImageResource(R.drawable.touxiang);

        ImageView imageView2 = (ImageView) view.findViewById(R.id.image2);
        imageView2.setImageResource(R.drawable.filehelper_1479037701125_92);*/


        return inflater.inflate(R.layout.layout_view4,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_view4_1:
                Snackbar.make(getView(),"(4,1)",Snackbar.LENGTH_SHORT).show();
                Log.d("snackbar","(4,1)");
                break;
            case R.id.item_view4_2:
                Snackbar.make(getView(),"(4,2)",Snackbar.LENGTH_SHORT).show();
                Log.d("snackbar","(4,2)");
                break;
            case R.id.item_view4_3:
                Snackbar.make(getView(),"(4,3)",Snackbar.LENGTH_SHORT).show();
                Log.d("snackbar","(4,3)");
                break;
            case R.id.item_view4_4:
                Snackbar.make(getView(),"(4,4)",Snackbar.LENGTH_SHORT).show();
                Log.d("snackbar","(4,4)");
                break;
            case R.id.item_view4_5:
                Snackbar.make(getView(),"(4,5)",Snackbar.LENGTH_SHORT).show();
                Log.d("snackbar","(4,5)");
                break;
            case R.id.item_view4_6:
                Snackbar.make(getView(),"(4,6)",Snackbar.LENGTH_SHORT).show();
                Log.d("snackbar","(4,6)");
                break;
            case R.id.item_view4_7:
                Snackbar.make(getView(),"(4,7)",Snackbar.LENGTH_SHORT).show();
                Log.d("snackbar","(4,7)");
                break;

        }
    }
}
