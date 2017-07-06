package kf.gyn.com.supermarket_no6.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import kf.gyn.com.supermarket_no6.R;
import kf.gyn.com.supermarket_no6.base.BaseFragment;

/**
 * @类的用途:购物车
 * @author:shizhuangzhaung
 * @date:2017/6/28
 */

public class FragmentCart extends BaseFragment {
    @BindView(R.id.reclerview_fragmentcar_list)
    RecyclerView reclerviewFragmentcarList;
    @BindView(R.id.tv_fragmentcart_price)
    TextView tvFragmentcartPrice;
    Unbinder unbinder;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void initInjectorDagger() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Typeface fromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/msyh.ttc");
        tvFragmentcartPrice.setTypeface(fromAsset);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
