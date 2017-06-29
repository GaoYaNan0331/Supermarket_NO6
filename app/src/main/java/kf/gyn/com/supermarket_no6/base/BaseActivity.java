package kf.gyn.com.supermarket_no6.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected abstract int attachLayoutRes();

    /**
     * Dagger 注入
     */
    protected abstract void initInjectorDagger();

    /**
     * 初始化视图控件
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected abstract void initEvents();

    /**
     * 更新视图控件
     */
    protected abstract void updateViews(boolean isRefresh);

    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(attachLayoutRes());

        ButterKnife.bind(this);
        //dagger方法
        initInjectorDagger();
        //控件初始化方法
        initViews();
        //初始事件方法
        initEvents();
        //视图变化方法
        updateViews(false);


    }


    /**
     * 添加 Fragment
     *
     * @param containerViewId
     * @param fragment
     */
    protected void addFragment(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // 设置tag，不然下面 findFragmentByTag(tag)找不到
        fragmentTransaction.add(containerViewId, fragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

    /**
     * 替换 Fragment
     *
     * @param containerViewId
     * @param fragment
     */
    protected void replaceFragment(int containerViewId, Fragment fragment, String tag) {
        //Toast.makeText(this, tag+"", Toast.LENGTH_SHORT).show();
        Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragmentByTag == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            // 设置tag
            fragmentTransaction.replace(containerViewId, fragment, tag);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            // 这里要设置tag，上面也要设置tag
            fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
            // Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        } else {
            // 存在则弹出在它上面的所有fragment，并显示对应fragment
            getSupportFragmentManager().popBackStack(tag, 0);
            //Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
        }
//调用沉静式
        if (isSetStatusBar) {
            steepStatusBar();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        d("---------onStart ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        d("---------onResume ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("---------onStop ");
    }

    @Override
    protected void onPause() {
        super.onPause();

        d("---------onPause ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        d("---------onRestart ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        d("---------onDestroy ");
    }

    private void d(String sign) {
        Log.d("BaseActivity---------", sign);
    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * [是否设置沉浸状态栏]
     *
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }
}
