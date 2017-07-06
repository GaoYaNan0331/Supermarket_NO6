package kf.gyn.com.supermarket_no6.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.transformer.TransitionEffect;
import kf.gyn.com.supermarket_no6.R;
import kf.gyn.com.supermarket_no6.base.BaseFragment;
import kf.gyn.com.supermarket_no6.widget.ImageTextGoup;

/**
 * @类的用途:
 * @author:王帅
 * @date:2017/6/28
 */

public class FragmentHome extends BaseFragment {
    //jjh
    @BindView(R.id.banner)
    BGABanner banner;
    Unbinder unbinder;
    @BindView(R.id.home_shangcheng_zuhe)
    ImageTextGoup homeShangchengZuhe;
    @BindView(R.id.home_nfc_zuhe)
    ImageTextGoup homeNfcZuhe;
    @BindView(R.id.home_erweima_zuhe)
    ImageTextGoup homeErweimaZuhe;
    @BindView(R.id.home_lishi_zuhe)
    ImageTextGoup homeLishiZuhe;
    @BindView(R.id.home_jingxuanhaohuo)
    TextView homeJingxuanhaohuo;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInjectorDagger() {

    }

    @Override
    protected void initViews() {

        banner.setTransitionEffect(TransitionEffect.Default);

        // banner.setPageTransformer(new RotatePageTransformer());
        // 设置page切换时长
        banner.setPageChangeDuration(2000);
        List<View> views = new ArrayList<>();
        views.add(getPageView(R.drawable.banner));
        views.add(getPageView(R.drawable.banner));
        views.add(getPageView(R.drawable.banner));
        views.add(getPageView(R.drawable.banner));
        Typeface typeFace =Typeface.createFromAsset(getContext().getAssets(),"fonts/msyh.ttc");
//使用字体

        homeJingxuanhaohuo.setTypeface(typeFace);


        banner.setData(views);


    }

    private View getPageView(@DrawableRes int resid) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(resid);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
