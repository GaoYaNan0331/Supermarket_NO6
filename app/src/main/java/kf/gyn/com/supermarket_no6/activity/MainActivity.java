package kf.gyn.com.supermarket_no6.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import kf.gyn.com.supermarket_no6.R;
import kf.gyn.com.supermarket_no6.base.BaseActivity;
import kf.gyn.com.supermarket_no6.fragment.FragmentHome;
import kf.gyn.com.supermarket_no6.fragment.FragmentMy;
import kf.gyn.com.supermarket_no6.fragment.FragmentPinPai;
import kf.gyn.com.supermarket_no6.fragment.FragmentShop;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.bottom_navigation_button_home)
    RadioButton bottomNavigationButtonHome;
    @BindView(R.id.bottom_navigation_button_pinpai)
    RadioButton bottomNavigationButtonPinpai;
    @BindView(R.id.bottom_navigation_button_shop)
    RadioButton bottomNavigationButtonShop;
    @BindView(R.id.bottom_navigation_button_my)
    RadioButton bottomNavigationButtonMy;
    @BindView(R.id.bottom_navigation_radioGroup)
    RadioGroup bottomNavigationRadioGroup;
    private SparseArray<String> mSparseTags = new SparseArray<>();
    private long mExitTime = 0;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjectorDagger() {

    }

    @Override
    protected void initViews() {


        bottomNavigationButtonHome.setChecked(true);
        bottomNavigationRadioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        buttonAnimation();

    }

    private void buttonAnimation() {

        if (bottomNavigationButtonHome.isChecked()) {
            AnimationSet animationSet1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.yidong);

            bottomNavigationButtonHome.startAnimation(animationSet1);
        } else {
            AnimationSet animation1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.yidong2);

            bottomNavigationButtonHome.startAnimation(animation1);
        }

        if (bottomNavigationButtonPinpai.isChecked()) {
            AnimationSet animationSet1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.yidong);

            bottomNavigationButtonPinpai.startAnimation(animationSet1);
        } else {
            AnimationSet animation1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.yidong2);

            bottomNavigationButtonPinpai.startAnimation(animation1);
        }

        if (bottomNavigationButtonShop.isChecked()) {
            AnimationSet animationSet1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.yidong);

            bottomNavigationButtonShop.startAnimation(animationSet1);
        } else {
            AnimationSet animation1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.yidong2);

            bottomNavigationButtonShop.startAnimation(animation1);
        }

        if (bottomNavigationButtonMy.isChecked()) {
            AnimationSet animationSet1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.yidong);

            bottomNavigationButtonMy.startAnimation(animationSet1);
        } else {
            AnimationSet animation1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.yidong2);

            bottomNavigationButtonMy.startAnimation(animation1);
        }


    }

    @Override
    protected void initEvents() {

        mSparseTags.put(R.id.bottom_navigation_button_home, "home");
        mSparseTags.put(R.id.bottom_navigation_button_pinpai, "pinpai");
        mSparseTags.put(R.id.bottom_navigation_button_shop, "shop");
        mSparseTags.put(R.id.bottom_navigation_button_my, "my");

        addFragment(R.id.auto_frameLayout, new FragmentHome(), mSparseTags.get(R.id.bottom_navigation_button_home));
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }


    @Override
    public void onBackPressed() {

        _exit();

    }


    /**
     * 退出
     */
    private void _exit() {
        if (System.currentTimeMillis() - mExitTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {


        buttonAnimation();


        switch (checkedId) {
            case R.id.bottom_navigation_button_home:
                bottomNavigationButtonHome.setSelected(true);
                bottomNavigationButtonPinpai.setSelected(false);
                bottomNavigationButtonShop.setSelected(false);
                bottomNavigationButtonMy.setSelected(false);
                replaceFragment(R.id.auto_frameLayout, new FragmentHome(), mSparseTags.get(R.id.bottom_navigation_button_home));
                bottomNavigationButtonHome.setEnabled(false);
                bottomNavigationButtonPinpai.setEnabled(true);
                bottomNavigationButtonShop.setEnabled(true);
                bottomNavigationButtonMy.setEnabled(true);
                break;
            case R.id.bottom_navigation_button_pinpai:
                bottomNavigationButtonHome.setSelected(false);
                bottomNavigationButtonPinpai.setSelected(true);
                bottomNavigationButtonShop.setSelected(false);
                bottomNavigationButtonMy.setSelected(false);
                replaceFragment(R.id.auto_frameLayout, new FragmentPinPai(), mSparseTags.get(R.id.bottom_navigation_button_pinpai));
                bottomNavigationButtonHome.setEnabled(true);
                bottomNavigationButtonPinpai.setEnabled(false);
                bottomNavigationButtonShop.setEnabled(true);
                bottomNavigationButtonMy.setEnabled(true);
                break;
            case R.id.bottom_navigation_button_shop:
                bottomNavigationButtonHome.setSelected(false);
                bottomNavigationButtonPinpai.setSelected(false);
                bottomNavigationButtonShop.setSelected(true);
                bottomNavigationButtonMy.setSelected(false);
                replaceFragment(R.id.auto_frameLayout, new FragmentShop(), mSparseTags.get(R.id.bottom_navigation_button_shop));
                bottomNavigationButtonHome.setEnabled(true);
                bottomNavigationButtonPinpai.setEnabled(true);
                bottomNavigationButtonShop.setEnabled(false);
                bottomNavigationButtonMy.setEnabled(true);
                break;
            case R.id.bottom_navigation_button_my:
                bottomNavigationButtonHome.setSelected(false);
                bottomNavigationButtonPinpai.setSelected(false);
                bottomNavigationButtonShop.setSelected(false);
                bottomNavigationButtonMy.setSelected(true);
                replaceFragment(R.id.auto_frameLayout, new FragmentMy(), mSparseTags.get(R.id.bottom_navigation_button_my));
                bottomNavigationButtonHome.setEnabled(true);
                bottomNavigationButtonPinpai.setEnabled(true);
                bottomNavigationButtonShop.setEnabled(true);
                bottomNavigationButtonMy.setEnabled(false);
                break;
        }
    }


}
