package kf.gyn.com.supermarket_no6.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


public abstract class BaseFragment extends Fragment {
    private View mRootView;


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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(attachLayoutRes(), null);


            ButterKnife.bind(this, mRootView);
            //dagger方法
            initInjectorDagger();
            //初始化控件方法
            initViews();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        d("---------onCreateView ");
        return mRootView;


    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        d("---------onAttach ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d("---------onCreate ");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        d("---------onActivityCreated ");

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        d("---------onResume ");
        super.onResume();
    }

    @Override
    public void onPause() {
        d("---------onPause ");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        d("---------onDestroyView ");
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        d("---------onDestroy ");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        d("---------onDetach ");
        super.onDetach();

    }


    private void d(String sign) {
        Log.d("BaseFragment---------", sign);
    }
}

