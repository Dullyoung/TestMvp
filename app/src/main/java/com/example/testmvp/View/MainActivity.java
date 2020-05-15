package com.example.testmvp.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testmvp.Model.bean.UserBean;
import com.example.testmvp.Presenter.UserLogin;
import com.example.testmvp.Presenter.UserLoginPresenter;
import com.example.testmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements UserLogin {
    UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.psw)
    EditText psw;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.cancel)
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void onLoginClicked() {
        userLoginPresenter.login();
    }

    @OnClick(R.id.cancel)
    public void onCancelClicked() {
        userLoginPresenter.cancel();
    }

    @Override
    public String getUserName() {
        return name.getText().toString();
    }

    @Override
    public String getPassword() {
        return psw.getText().toString();
    }

    @Override
    public void clearUserName() {
        name.setText("");
    }

    @Override
    public void clearPassword() {
        psw.setText("");
    }

    ProgressDialog dialog;

    @Override
    public void showLoading() {
        dialog.setString("登陆");
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.dismiss();
    }

    @Override
    public void toMainActivity(UserBean user) {
        Toast.makeText(this, "登录成功，进入主页", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
