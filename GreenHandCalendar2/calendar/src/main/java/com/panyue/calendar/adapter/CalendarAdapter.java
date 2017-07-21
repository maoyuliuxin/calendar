package com.panyue.calendar.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.panyue.calendar.DateUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class CalendarAdapter extends PagerAdapter {

    private List<GridView> mViews;
    private int mIndex;

    public CalendarAdapter(int index) {
        mViews = new LinkedList<>();
        mIndex = index;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        GridView gridView = (GridView) object;
        container.removeView(gridView);
        mViews.add(0, gridView);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        GridView gridView;
        if (mViews.size() == 0) {
            gridView = new GridView(container.getContext());
            gridView.setNumColumns(7);
            gridView.setVerticalSpacing(10);
            mViews.add(0, gridView);
        }
        gridView = mViews.remove(0);
        if (mIndex != 0) {
            position = position - mIndex;
        }
        gridView.setAdapter(new DateAdapter(DateUtils.getPTime(position)[0],
                DateUtils.getPTime(position)[1],
                DateUtils.getPTime(position - 1)[1]));
        container.addView(gridView);
        return gridView;
    }
}
