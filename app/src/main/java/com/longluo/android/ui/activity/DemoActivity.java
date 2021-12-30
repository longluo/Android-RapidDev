package com.longluo.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.longluo.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.longluo.util.ToastUtils;


public class DemoActivity extends AppCompatActivity {

    @BindView(R.id.btn_test)
    Button mBtnTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_2);
        ButterKnife.bind(this);

        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(DemoActivity.this, "Test");
            }
        });
    }
}