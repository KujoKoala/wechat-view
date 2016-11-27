package com.kaifa.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kaifa.Bean.ViewOneBean;
import com.kaifa.adapter.RecyclerViewAdapter;
import com.kaifa.adapter.ViewOneAdapter;
import com.kaifa.weixinjiemian.R;

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
public class OneFragment extends Fragment {
    private ArrayList<ViewOneBean> al;
    private ListView mListView;
    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.layout_view1,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        al = new ArrayList<>();

        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mListView = (ListView) getActivity().findViewById(R.id.view1_lv);
        ViewOneBean bean;
        int t = 0x7f020000;
        for(int i=0; i<333; i++){
            bean = new ViewOneBean();
            bean.setIcon1(t);
            t++;
            bean.setText1("tfb_1"+i);
            bean.setText2("H:你想说你要划船？");
            bean.setText3("15:26");
            al.add(bean);
        }


        ViewOneAdapter viewOneAdapter = new ViewOneAdapter(al,getActivity());
//        mListView.setAdapter(viewOneAdapter);
        mRecyclerView.setAdapter(new RecyclerViewAdapter(al,getActivity()));



    }
}
