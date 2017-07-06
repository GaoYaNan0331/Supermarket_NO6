package kf.gyn.com.supermarket_no6.activity;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import kf.gyn.com.supermarket_no6.R;
import kf.gyn.com.supermarket_no6.base.BaseActivity;
import kf.gyn.com.supermarket_no6.fragment.FragmentCart;
import kf.gyn.com.supermarket_no6.fragment.FragmentHome;
import kf.gyn.com.supermarket_no6.fragment.FragmentMy;
import kf.gyn.com.supermarket_no6.fragment.FragmentShop;
import kf.gyn.com.supermarket_no6.widget.ImageTextView;


public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation_button_home)
    ImageTextView bottomNavigationButtonHome;
    @BindView(R.id.bottom_navigation_button_shop)
    ImageTextView bottomNavigationButtonShop;
    @BindView(R.id.bottom_navigation_button_cart)
    ImageTextView bottomNavigationButtonCart;
    @BindView(R.id.bottom_navigation_button_my)
    ImageTextView bottomNavigationButtonMy;


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


        bottomNavigationButtonHome.setSelected(true);

    }

    @Override
    protected void initEvents() {
        mSparseTags.put(R.id.bottom_navigation_button_home, "home");
        mSparseTags.put(R.id.bottom_navigation_button_shop, "shop");
        mSparseTags.put(R.id.bottom_navigation_button_cart, "cart");
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

    @OnClick({R.id.bottom_navigation_button_home, R.id.bottom_navigation_button_shop, R.id.bottom_navigation_button_cart, R.id.bottom_navigation_button_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bottom_navigation_button_home:
                bottomNavigationButtonHome.setSelected(true);
                bottomNavigationButtonShop.setSelected(false);
                bottomNavigationButtonCart.setSelected(false);
                bottomNavigationButtonMy.setSelected(false);
                replaceFragment(R.id.auto_frameLayout, new FragmentHome(), mSparseTags.get(R.id.bottom_navigation_button_home));

                break;
            case R.id.bottom_navigation_button_shop:
                bottomNavigationButtonHome.setSelected(false);
                bottomNavigationButtonShop.setSelected(true);
                bottomNavigationButtonCart.setSelected(false);
                bottomNavigationButtonMy.setSelected(false);
                replaceFragment(R.id.auto_frameLayout, new FragmentShop(), mSparseTags.get(R.id.bottom_navigation_button_shop));

                break;
            case R.id.bottom_navigation_button_cart:
                bottomNavigationButtonHome.setSelected(false);
                bottomNavigationButtonShop.setSelected(false);
                bottomNavigationButtonCart.setSelected(true);
                bottomNavigationButtonMy.setSelected(false);
                replaceFragment(R.id.auto_frameLayout, new FragmentCart(), mSparseTags.get(R.id.bottom_navigation_button_cart));

                break;
            case R.id.bottom_navigation_button_my:
                bottomNavigationButtonHome.setSelected(false);
                bottomNavigationButtonShop.setSelected(false);
                bottomNavigationButtonCart.setSelected(false);
                bottomNavigationButtonMy.setSelected(true);
                replaceFragment(R.id.auto_frameLayout, new FragmentMy(), mSparseTags.get(R.id.bottom_navigation_button_my));

                break;
        }
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


}
