package kf.gyn.com.supermarket_no6.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import kf.gyn.com.supermarket_no6.R;
import kf.gyn.com.supermarket_no6.activity.ShiMingRenActivity;
import kf.gyn.com.supermarket_no6.base.BaseFragment;

/**
 * @类的用途:
 * @author:王帅
 * @date:2017/6/28
 */

public class FragmentMy extends BaseFragment {
    @BindView(R.id.my_btn_image)
    ImageView mMyBtnImage;
    @BindView(R.id.fragment_my_btn)
    Button mFragmentMyBtn;
    @BindView(R.id.fragment_list_view)
    ListView mFragmentListView;
    Unbinder unbinder;
    private List<String> mList;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initInjectorDagger() {

    }

    @Override
    protected void initViews() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        initDatas();
        return rootView;
    }

    private void initDatas() {
//        mList = new ArrayList<String>();
//        mList.add("我的收藏");
//        mList.add("收获地址");
//        mList.add("设置");
//        mList.add("关于我们");
//        mList.add("分享给好友");
//        mList.add("打分评价");
//        // 设置adapter(所在的activity,使用的显示样式,数据源)
//        ListAdapter adapter = new ArrayAdapter<String>(getContext(),
//                android.R.layout.simple_list_item_1, mList);
//        mFragmentListView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.my_btn_image, R.id.fragment_my_btn, R.id.fragment_list_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_btn_image:
                break;
            case R.id.fragment_my_btn:
                Intent intent=new Intent(getContext(),ShiMingRenActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_list_view:

                break;
        }
    }
}
