package kf.gyn.com.supermarket_no6.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kf.gyn.com.supermarket_no6.R;
import kf.gyn.com.supermarket_no6.base.BaseActivity;

/**
 * data:2017/7/5
 * author:高亚男(Administrator)
 * function:
 */

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.fragment_my_login_title)
    ImageView mFragmentMyLoginTitle;
    @BindView(R.id.fragment_my_login_phone)
    TextView mFragmentMyLoginPhone;
    @BindView(R.id.fragement_my_login_passworld)
    TextView mFragementMyLoginPassworld;
    @BindView(R.id.fragment_my_login_eyes)
    ImageView mFragmentMyLoginEyes;
    @BindView(R.id.fragment_my_login_findpsw)
    TextView mFragmentMyLoginFindpsw;
    @BindView(R.id.fragement_my_login_atonce)
    Button mFragementMyLoginAtonce;
    @BindView(R.id.fragment_my_login_newman)
    Button mFragmentMyLoginNewman;
    @BindView(R.id.fragment_my_dsf_login)
    TextView mFragmentMyDsfLogin;
    @BindView(R.id.fragment_my_login_qq)
    ImageView mFragmentMyLoginQq;
    @BindView(R.id.fragment_my_login_weixin)
    ImageView mFragmentMyLoginWeixin;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_my_login;
    }

    @Override
    protected void initInjectorDagger() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fragment_my_login_title, R.id.fragment_my_login_phone, R.id.fragement_my_login_passworld, R.id.fragment_my_login_eyes, R.id.fragment_my_login_findpsw, R.id.fragement_my_login_atonce, R.id.fragment_my_login_newman, R.id.fragment_my_dsf_login, R.id.fragment_my_login_qq, R.id.fragment_my_login_weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_my_login_title:
                break;
            case R.id.fragment_my_login_phone:
                break;
            case R.id.fragement_my_login_passworld:
                break;
            case R.id.fragment_my_login_eyes:
                break;
            case R.id.fragment_my_login_findpsw:
                break;
            case R.id.fragement_my_login_atonce:
                break;
            case R.id.fragment_my_login_newman:
                Intent intent = new Intent(RegisterActivity.this, NewManActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_my_dsf_login:
                break;
            case R.id.fragment_my_login_qq:
                break;
            case R.id.fragment_my_login_weixin:
                break;
        }
    }
}
