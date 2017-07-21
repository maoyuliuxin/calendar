package com.panyue.calendar.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.panyue.calendar.R;

/**
 * Created by Administrator on 2017/7/21.
 */

public class DateAdapter extends BaseAdapter {

    private int mWeek;
    private int mDays;
    private int mLastMonthDays;

    public DateAdapter(int week, int days, int lastMonthDays) {
        mWeek = week;
        mDays = days;
        mLastMonthDays = lastMonthDays;
    }

    @Override
    public int getCount() {
        return 42;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(viewGroup.getContext(), R.layout.text_view, null);
            viewHolder.mTextView = view.findViewById(R.id.tv_date);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        int date = i + 2 - mWeek;
        if (date < 1) {
            date = mLastMonthDays + date;
            Log.e("shen", "date= " + date);
            Log.e("shen", "mLastMonthDays= " + mLastMonthDays);
            viewHolder.mTextView.setText(date + "");
            return view;
        }
        if (date > mDays) {
            date = date - mDays;
            viewHolder.mTextView.setText(date + "");
            return view;
        }
        viewHolder.mTextView.setText(date + "");
        return view;
    }

    private static class ViewHolder {
        public TextView mTextView;
    }
}
