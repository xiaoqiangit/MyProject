package com.hzq.example.ui.main.mine;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.hzq.baselibs.base.BaseFragment;
import com.hzq.baselibs.utils.ToastUtils;
import com.hzq.baselibs.view.MultipleStatusView;
import com.hzq.example.R;
import com.hzq.example.data.entity.LoginEntity;
import com.hzq.example.data.entity.MineEntity;
import com.hzq.example.ui.main.login.LoginActivity;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author 小强
 * @time 2018/6/12 22:57
 * @desc 我的
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View {


    @BindView(R.id.get_btn) Button mGetBtn;
    @BindView(R.id.login_btn) Button mLoginBtn;
    @BindView(R.id.et) EditText mEt;
    @BindView(R.id.multipleStatusView) MultipleStatusView mMultipleStatusView;
    private String mTitle;

    public static MineFragment getInstance(String title) {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }


    @Override
    public void showData(MineEntity testNews) {
        mLayoutStatusView.showContent();
        Logger.d("showData--->:" + testNews.toString());

    }

    @Override
    public void showLoginData(LoginEntity data) {
        if (data != null) {
            mLayoutStatusView.showContent();
            //            ToastUtils.showShort(data.toString());
            Logger.d("showLoginData--->:" + data);
        }
    }


    @OnClick(R.id.login_btn)
    public void onClick() {

        Map<String, String> map = new HashMap<>();
        map.put("username", "18822223335");
        map.put("password", "abc12345678");
        Logger.d("onClick--->:" + map.toString());
        showLoading("我爱你");
        startActivity(LoginActivity.class);
        finishActivity();
        mPresenter.requestLoginData(map);
    }

    @OnClick(R.id.get_btn)
    public void onClick1() {

        Map<String, String> map = new HashMap<>();
        map.put("username", "18822223335");
        map.put("password", "abc12345678");
        Logger.d("onClick--->:" + map.toString());
        showLoading("哈哈");
        mPresenter.requestLoginData(map);
    }

    /**
     * 请求网络
     */
    @Override
    public void onLazyLoad() {
        Map<String, String> map = new HashMap<>();
        map.put("username", "18822223335");
        map.put("password", "abc12345678");
        Logger.d("onClick--->:" + map.toString());
        mPresenter.requestLoginData(map);
    }

    /**
     * 显示错误
     *
     * @param msg  错误信息
     * @param code 错误code
     */
    @Override
    public void showError(String msg, int code) {
        ToastUtils.showShort(msg);
        mLayoutStatusView.showError();
    }

    /**
     * 显示网络错误
     *
     * @param msg  错误信息
     * @param code 错误code
     */
    @Override
    public void showNetworkError(String msg, int code) {
        ToastUtils.showShort(msg);
        mLayoutStatusView.showNoNetwork();

    }

    /**
     * 初始数据的代码写在这个方法中，用于从服务器获取数据
     */
    @Override
    protected void initData() {
        super.initData();
    }
}
