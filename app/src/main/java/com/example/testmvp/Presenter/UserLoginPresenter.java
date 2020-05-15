package com.example.testmvp.Presenter;

import android.os.Handler;

import com.example.testmvp.Model.Interface.LoginListener;
import com.example.testmvp.Model.RealizedLogin;
import com.example.testmvp.Model.bean.UserBean;

public class UserLoginPresenter {
    private RealizedLogin realizedLogin;
    private UserLogin userLogin;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(UserLogin userLogin) {
        this.userLogin = userLogin;
        this.realizedLogin = new RealizedLogin();
    }

    public void login() {
        userLogin.showLoading();
        realizedLogin.login(userLogin.getUserName(), userLogin.getPassword(), new LoginListener() {
            @Override
            public void onSuccess(final UserBean userBean) {
                mHandler.post(() -> {
                    userLogin.toMainActivity(userBean);
                    userLogin.hideLoading();
                });
            }

            @Override
            public void onFailed() {
                mHandler.post(() -> {
               userLogin.showFailedError();
               userLogin.hideLoading();
                });
            }
        });


    }


    public void cancel(){
        userLogin.clearUserName();
        userLogin.clearPassword();
    }

}
