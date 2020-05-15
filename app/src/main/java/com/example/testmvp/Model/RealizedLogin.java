package com.example.testmvp.Model;

import com.example.testmvp.Model.Interface.IUser;
import com.example.testmvp.Model.Interface.LoginListener;
import com.example.testmvp.Model.bean.UserBean;

public class RealizedLogin implements IUser {
    @Override
    public void login(final String user, final String psw, final LoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("123".equals(user) && "123".equals(psw)) {
                    UserBean userBean = new UserBean();
                    userBean.setName(user);
                    userBean.setPassword(psw);
                    loginListener.onSuccess(userBean);
                } else {
                    loginListener.onFailed();
                }
            }
        }.start();

    }
}
