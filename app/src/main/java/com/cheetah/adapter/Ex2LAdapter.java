package com.cheetah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheetah.bean.FirstLevelBean;
import com.cheetah.bean.SecondLevelBean;
import com.cheetah.bean.ThirdLevelBean;
import com.cheetah.example41.R;

import java.util.List;
import java.util.Map;

/** Ex2LAdapter. Created by wangyao1 on 2017.08.29. */

public class Ex2LAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<FirstLevelBean> mFirstLevelList;
    private Map<FirstLevelBean, List<SecondLevelBean>> mSecondDataSet;
    private Map<SecondLevelBean, List<ThirdLevelBean>> mThirdDataSet;

    public Ex2LAdapter(Context context, List<FirstLevelBean> firstLevelList,
                       Map<FirstLevelBean, List<SecondLevelBean>> secondDataSet,
                       Map<SecondLevelBean, List<ThirdLevelBean>> thirdDataSet) {
        mContext = context;
        mFirstLevelList = firstLevelList;
        mSecondDataSet = secondDataSet;
        mThirdDataSet = thirdDataSet;
    }

    @Override
    public int getGroupCount() {
        return mFirstLevelList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //no idea why this code is working
        return 1;
        //return mSecondDataSet.get(mFirstLevelList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mFirstLevelList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mSecondDataSet.get(mFirstLevelList.get(groupPosition)).get(childPosition);
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
        View firstLevelView = convertView;
        FirstLevelViewHolder viewHolder;
        if (firstLevelView == null) {
            viewHolder = new FirstLevelViewHolder();
            firstLevelView = LayoutInflater.from(mContext).inflate(R.layout.clean_acc_detail_group_layout, null);

            viewHolder.leftIcon = (ImageView) firstLevelView.findViewById(R.id.clean_acc_detail_group_left_icon);
            viewHolder.classification = (TextView) firstLevelView.findViewById(R.id.clean_acc_detail_group_title);
            viewHolder.rubbishSize = (TextView) firstLevelView.findViewById(R.id.clean_acc_detail_group_rubbish_size);
            viewHolder.checkBox = (ImageView) firstLevelView.findViewById(R.id.clean_acc_detail_group_check_box);

            firstLevelView.setTag(viewHolder);
        } else {
            viewHolder = (FirstLevelViewHolder) firstLevelView.getTag();
        }

        // TODO: 2017.08.29 设置界面
        if (isExpanded) { // GroupItem打开
            viewHolder.leftIcon.setBackgroundResource(R.drawable.ac_close);
        } else {
            viewHolder.leftIcon.setBackgroundResource(R.drawable.ac_open);
        }
        viewHolder.classification.setText(mFirstLevelList.get(groupPosition).classification);
        // TODO: 2017.08.29 设置check box三种点击状态切换的监听

        return firstLevelView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final Cus3LListView cus3LListView = new Cus3LListView(mContext);
        Ex3LAdapter ex3LAdapter = new Ex3LAdapter(mContext,
                mSecondDataSet.get(mFirstLevelList.get(groupPosition)), mThirdDataSet);
        cus3LListView.setAdapter(ex3LAdapter);
        cus3LListView.setGroupIndicator(null);
        /*cus3LListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition != previousGroup) {
                    cus3LListView.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;
            }
        });*/

        return cus3LListView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    // Group View Holder
    class FirstLevelViewHolder {
        public ImageView leftIcon;
        public TextView classification;
        public TextView rubbishSize;
        public ImageView checkBox;
    }

}
