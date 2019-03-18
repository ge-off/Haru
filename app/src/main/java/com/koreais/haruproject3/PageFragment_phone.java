package com.koreais.haruproject3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class PageFragment_phone extends Fragment {

    CallLogActivity calllog; // 통화 기록 리스트를 생성해주는 객체
    ListView mycallLog;
    ArrayList<CallLogVO> list = null;
    ViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.activy_page_flagment_phone, container, false);

        Log.d("mylog", "PageFragment_phone, onCreateView() call");
        calllog = new CallLogActivity(getContext());

        adapter = null;
        list = calllog.callLog(); // 리스트 객체 가져오기

        mycallLog = layout.findViewById(R.id.mycallLog); // 리스트뷰 객체 가져오기

        if(adapter == null) {
            adapter = new ViewAdapter(getActivity(), R.layout.activity_call_log, list, mycallLog);

            mycallLog.setAdapter(adapter);
        }

        return layout;
    }

}
