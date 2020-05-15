package com.example.testmvp.Model.Interface;

import com.example.testmvp.Model.bean.UserBean;

public interface LoginListener {
    void onSuccess(UserBean userBean);
    void onFailed();
}
