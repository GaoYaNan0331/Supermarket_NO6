package kf.gyn.com.supermarket_no6.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.OnClick;
import kf.gyn.com.supermarket_no6.R;
import kf.gyn.com.supermarket_no6.base.BaseFragment;

/**
 * @类的用途:
 * @author:王帅
 * @date:2017/6/28
 */

public class FragmentPinPai extends BaseFragment {
    @BindView(R.id.shop_sousuo_button)
    AutoLinearLayout shopSousuoButton;
    @BindView(R.id.shop_rceycler_view)
    RecyclerView shopRceyclerView;
    @BindView(R.id.shop_heZuo)
    TextView shopHeZuo;



    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_pinpai;
    }

    @Override
    protected void initInjectorDagger() {

    }

    @Override
    protected void initViews() {

    }



    @OnClick({R.id.shop_sousuo_button, R.id.shop_heZuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shop_sousuo_button:
                Toast.makeText(getActivity(), "搜索框跳转", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shop_heZuo:
                Toast.makeText(getActivity(), "合作BUTTON跳转", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
