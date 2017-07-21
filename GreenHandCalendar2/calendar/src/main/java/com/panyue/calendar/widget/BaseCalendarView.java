package com.panyue.calendar.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.panyue.calendar.R;
import com.panyue.calendar.adapter.CalendarAdapter;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BaseCalendarView extends LinearLayout {

    private CalendarAdapter mAdapter;

    public BaseCalendarView(Context context) {
        super(context);
        initView();
    }

    public BaseCalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BaseCalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.base_calendar, this);
        ViewPager viewPager = findViewById(R.id.view_pager);
        mAdapter = new CalendarAdapter(Integer.MAX_VALUE / 2);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2);
    }

}
