package com.cheetah.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheetah.bean.SecondLevelBean;
import com.cheetah.bean.ThirdLevelBean;
import com.cheetah.example41.R;

import java.util.List;
import java.util.Map;

/** Ex3LAdapter. Created by wangyao1 on 2017.08.30. */

public class Ex3LAdapter extends BaseExpandableListAdapter {

    private final float THIRD_LEVEL_ITEM_HEIGHT = 54F;
    private final float SECOND_LEVEL_ITEM_HEIGHT = 60F;

    private Context mContext;
    private List<SecondLevelBean> mSecondList;
    private Map<SecondLevelBean, List<ThirdLevelBean>> mThirdDataSet;

    public Ex3LAdapter(Context context, List<SecondLevelBean> secondList,
                       Map<SecondLevelBean, List<ThirdLevelBean>> thirdDataSet) {
        mContext = context;
        mSecondList = secondList;
        mThirdDataSet = thirdDataSet;
    }

    @Override
    public int getGroupCount() {
        return mSecondList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mThirdDataSet.get(mSecondList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mSecondList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mThirdDataSet.get(mSecondList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View secondLevelView = convertView;
        SecondLevelViewHolder viewHolder;
        if (secondLevelView == null) {
            viewHolder = new SecondLevelViewHolder();
            secondLevelView = LayoutInflater.from(mContext).inflate(R.layout.clean_acc_detail_second_layout, null);
            final int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, SECOND_LEVEL_ITEM_HEIGHT,
                    mContext.getResources().getDisplayMetrics());
            secondLevelView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, height));

            viewHolder.appIcon = (ImageView) secondLevelView.findViewById(R.id.clean_acc_detail_child_left_icon);
            viewHolder.appTitle = (TextView) secondLevelView.findViewById(R.id.clean_acc_detail_child_app_title);
            viewHolder.suggestClean = (TextView) secondLevelView.findViewById(R.id.clean_acc_detail_child_suggest_clean);
            viewHolder.rubbishSize = (TextView) secondLevelView.findViewById(R.id.clean_acc_detail_child_rubbish_size);
            viewHolder.checkBox = (ImageView) secondLevelView.findViewById(R.id.clean_acc_detail_child_check_box);

            secondLevelView.setTag(viewHolder);
        } else {
            viewHolder = (SecondLevelViewHolder) secondLevelView.getTag();
        }

        SecondLevelBean bean = mSecondList.get(groupPosition);
        viewHolder.appIcon.setBackgroundResource(bean.appIconResource);
        viewHolder.appTitle.setText(bean.appTitle);
        viewHolder.suggestClean.setText(bean.suggestClean);

        return secondLevelView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View thirdLevelView = convertView;
        ThirdLevelViewHolder viewHolder;
        if (thirdLevelView == null) {
            viewHolder = new ThirdLevelViewHolder();
            thirdLevelView = LayoutInflater.from(mContext).inflate(R.layout.clean_acc_detail_third_layout, null);
            final int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, THIRD_LEVEL_ITEM_HEIGHT,
                    mContext.getResources().getDisplayMetrics());
            thirdLevelView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, height));

            viewHolder.leftIcon = (ImageView) thirdLevelView.findViewById(R.id.clean_acc_detail_third_icon);
            viewHolder.rubbishType = (TextView) thirdLevelView.findViewById(R.id.clean_acc_detail_third_type);
            viewHolder.rubbishSize = (TextView) thirdLevelView.findViewById(R.id.clean_acc_detail_third_rubbish_size);
            viewHolder.checkBox = (CheckBox) thirdLevelView.findViewById(R.id.clean_acc_detail_third_check_box);

            thirdLevelView.setTag(viewHolder);
        } else {
            viewHolder = (ThirdLevelViewHolder) thirdLevelView.getTag();
        }

        ThirdLevelBean bean = mThirdDataSet.get(mSecondList.get(groupPosition)).get(childPosition);
        viewHolder.leftIcon.setBackgroundResource(bean.leftIconResource);
        viewHolder.rubbishType.setText(bean.rubbishType);
        viewHolder.rubbishSize.setText(bean.rubbishSize);

        return thirdLevelView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    // Second Level View Holder
    class SecondLevelViewHolder {
        public ImageView divider;
        public ImageView appIcon;
        public TextView appTitle;
        public TextView suggestClean;
        public TextView rubbishSize;
        public ImageView checkBox;
    }

    // Third Level View Holder
    class ThirdLevelViewHolder {
        public ImageView leftIcon;
        public TextView rubbishType;
        public TextView rubbishSize;
        public CheckBox checkBox;
    }

}
