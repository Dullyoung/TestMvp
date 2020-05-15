package com.example.testmvp.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.testmvp.R;

public class ProgressDialog extends Dialog {

    public ProgressDialog(@NonNull Context context) {
        super(context);

    }

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setBackgroundResource(R.drawable.dialog_bg);
        setContentView(R.layout.dialog_layout);
        textView = findViewById(R.id.text111);
        setCanceledOnTouchOutside(false);
    }

    @Override
    public void show() {
        super.show();
        textView.setText(string);
    }

    String string;

    public void setString(String string) {
        this.string = string;
    }

}
