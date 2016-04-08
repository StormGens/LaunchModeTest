package com.zlq.bbb;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityB extends AppCompatActivity {

    @Bind(R.id.startStandard)
    Button startStandard;
    @Bind(R.id.startSingleTop)
    Button startSingleTop;
    @Bind(R.id.startSingleTask)
    Button startSingleTask;
    @Bind(R.id.startSingleInstance)
    Button startSingleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_b);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.startStandard, R.id.startSingleTop, R.id.startSingleTask, R.id.startSingleInstance})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startStandard:
                Intent i = new Intent();
                ComponentName cn = new ComponentName("com.zlq.lmt",  "com.zlq.lmt.StandardActivity");
                i.setComponent(cn);
                i.setAction("android.intent.action.MAIN");
                startActivity(i);
                break;
            case R.id.startSingleTop:
                break;
            case R.id.startSingleTask:
                Intent i2 = new Intent();
                ComponentName cn2 = new ComponentName("com.zlq.lmt",  "com.zlq.lmt.SingleTaskActivity");
                i2.setComponent(cn2);
                i2.setAction("android.intent.action.MAIN");
                startActivity(i2);
                break;
            case R.id.startSingleInstance:
                break;
        }
    }
}
