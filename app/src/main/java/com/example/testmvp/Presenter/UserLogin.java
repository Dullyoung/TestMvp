package com.example.testmvp.Presenter;

import com.example.testmvp.Model.bean.UserBean;

public interface UserLogin {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(UserBean user);

    void showFailedError();

}
