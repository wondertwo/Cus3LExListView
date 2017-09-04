package com.cheetah.example41;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.cheetah.adapter.Ex2LAdapter;
import com.cheetah.bean.FirstLevelBean;
import com.cheetah.bean.SecondLevelBean;
import com.cheetah.bean.ThirdLevelBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {

    private List<FirstLevelBean> mFirstLevelList = new ArrayList<>();
    private Map<FirstLevelBean, List<SecondLevelBean>> mSecondDataSet = new HashMap<>();
    private Map<SecondLevelBean, List<ThirdLevelBean>> mThirdDataSet = new HashMap<>();

    private ExpandableListView mListView;
    private Ex2LAdapter mListViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_accelerate_detail);

        initFirstLevelData(); // 初始化第一级数据
        initSecondLevelData(); // 初始化第二级数据
        initThirdLevelData(); // 初始化第三级数据

        mListView = (ExpandableListView) findViewById(R.id.clean_acc_detail_list_view);
        mListView.setGroupIndicator(null); // 隐藏 Indicator
        mListViewAdapter = new Ex2LAdapter(DetailActivity.this, mFirstLevelList, mSecondDataSet, mThirdDataSet);
        mListView.setAdapter(mListViewAdapter);
        // 监听GroupItem的展开、关闭状态
        /*mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup) {
                    mListView.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;
            }
        });*/
    }

    private void initFirstLevelData() {

        FirstLevelBean fb0 = new FirstLevelBean();
        fb0.classification = "花儿与少年";
        fb0.rubbishSize = "147M";
        mFirstLevelList.add(fb0);

        FirstLevelBean fb1 = new FirstLevelBean();
        fb1.classification = "月涌大江流";
        fb1.rubbishSize = "116M";
        mFirstLevelList.add(fb1);
    }

    private void initSecondLevelData() {

        List<SecondLevelBean> mSecondList0 = new ArrayList<>();
        SecondLevelBean fb0_sb0 = new SecondLevelBean();
        fb0_sb0.appIconResource = R.drawable.ac_second_app_icon;
        fb0_sb0.appTitle = "微信";
        fb0_sb0.suggestClean = "建议清理";
        fb0_sb0.rubbishSize = "51.4M";
        mSecondList0.add(fb0_sb0);
        SecondLevelBean fb0_sb1 = new SecondLevelBean();
        fb0_sb1.appIconResource = R.drawable.ac_second_app_icon;
        fb0_sb1.appTitle = "微信";
        fb0_sb1.suggestClean = "建议清理";
        fb0_sb1.rubbishSize = "51.4M";
        mSecondList0.add(fb0_sb1);
        mSecondDataSet.put(mFirstLevelList.get(0), mSecondList0);

        List<SecondLevelBean> mSecondList1 = new ArrayList<>();
        SecondLevelBean fb1_sb0 = new SecondLevelBean();
        fb1_sb0.appIconResource = R.drawable.ac_second_app_icon;
        fb1_sb0.appTitle = "微信";
        fb1_sb0.suggestClean = "建议清理";
        fb1_sb0.rubbishSize = "51.4M";
        mSecondList1.add(fb1_sb0);
        SecondLevelBean fb1_sb1 = new SecondLevelBean();
        fb1_sb1.appIconResource = R.drawable.ac_second_app_icon;
        fb1_sb1.appTitle = "微信";
        fb1_sb1.suggestClean = "建议清理";
        fb1_sb1.rubbishSize = "51.4M";
        mSecondList1.add(fb1_sb1);
        mSecondDataSet.put(mFirstLevelList.get(1), mSecondList1);
    }

    private void initThirdLevelData() {
        List<ThirdLevelBean> mThirdList00 = new ArrayList<>();
        ThirdLevelBean fb0_sb0_tb0 = new ThirdLevelBean();
        fb0_sb0_tb0.leftIconResource = R.drawable.ac_third_delete;
        fb0_sb0_tb0.rubbishType = "安装包缓存";
        fb0_sb0_tb0.rubbishSize = "11.42M";
        mThirdList00.add(fb0_sb0_tb0);
        ThirdLevelBean fb0_sb0_tb1 = new ThirdLevelBean();
        fb0_sb0_tb1.leftIconResource = R.drawable.ac_third_delete;
        fb0_sb0_tb1.rubbishType = "安装包缓存";
        fb0_sb0_tb1.rubbishSize = "11.42M";
        mThirdList00.add(fb0_sb0_tb1);
        mThirdDataSet.put(mSecondDataSet.get(mFirstLevelList.get(0)).get(0), mThirdList00);

        List<ThirdLevelBean> mThirdList01 = new ArrayList<>();
        ThirdLevelBean fb0_sb1_tb0 = new ThirdLevelBean();
        fb0_sb1_tb0.leftIconResource = R.drawable.ac_third_delete;
        fb0_sb1_tb0.rubbishType = "安装包缓存";
        fb0_sb1_tb0.rubbishSize = "11.42M";
        mThirdList01.add(fb0_sb1_tb0);
        ThirdLevelBean fb0_sb1_tb1 = new ThirdLevelBean();
        fb0_sb1_tb1.leftIconResource = R.drawable.ac_third_delete;
        fb0_sb1_tb1.rubbishType = "安装包缓存";
        fb0_sb1_tb1.rubbishSize = "11.42M";
        mThirdList01.add(fb0_sb1_tb1);
        mThirdDataSet.put(mSecondDataSet.get(mFirstLevelList.get(0)).get(1), mThirdList01);

        List<ThirdLevelBean> mThirdList10 = new ArrayList<>();
        ThirdLevelBean fb1_sb0_tb0 = new ThirdLevelBean();
        fb1_sb0_tb0.leftIconResource = R.drawable.ac_third_delete;
        fb1_sb0_tb0.rubbishType = "安装包缓存";
        fb1_sb0_tb0.rubbishSize = "11.42M";
        mThirdList10.add(fb1_sb0_tb0);
        ThirdLevelBean fb1_sb0_tb1 = new ThirdLevelBean();
        fb1_sb0_tb1.leftIconResource = R.drawable.ac_third_delete;
        fb1_sb0_tb1.rubbishType = "安装包缓存";
        fb1_sb0_tb1.rubbishSize = "11.42M";
        mThirdList10.add(fb1_sb0_tb1);
        mThirdDataSet.put(mSecondDataSet.get(mFirstLevelList.get(1)).get(0), mThirdList10);

        List<ThirdLevelBean> mThirdList11 = new ArrayList<>();
        ThirdLevelBean fb1_sb1_tb0 = new ThirdLevelBean();
        fb1_sb1_tb0.leftIconResource = R.drawable.ac_third_delete;
        fb1_sb1_tb0.rubbishType = "安装包缓存";
        fb1_sb1_tb0.rubbishSize = "11.42M";
        mThirdList11.add(fb1_sb1_tb0);
        ThirdLevelBean fb1_sb1_tb1 = new ThirdLevelBean();
        fb1_sb1_tb1.leftIconResource = R.drawable.ac_third_delete;
        fb1_sb1_tb1.rubbishType = "安装包缓存";
        fb1_sb1_tb1.rubbishSize = "11.42M";
        mThirdList11.add(fb1_sb1_tb1);
        mThirdDataSet.put(mSecondDataSet.get(mFirstLevelList.get(1)).get(1), mThirdList11);
    }

}
