package com.zlq.app_intent_flags;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zlq on 16/4/12.
 */
public class BaseActivity extends AppCompatActivity {

    @Bind(R.id.taskId_label)
    TextView taskIdLabel;
    @Bind(R.id.taskId_tv)
    TextView taskIdTv;
    @Bind(R.id.startA_btn)
    Button startABtn;
    @Bind(R.id.startB_btn)
    Button startBBtn;
    @Bind(R.id.startC_btn)
    Button startCBtn;
    @Bind(R.id.startD_btn)
    Button startDBtn;
    @Bind(R.id.flag_new_task)
    CheckBox flagNewTask;
    @Bind(R.id.flag_clear_top)
    CheckBox flagClearTop;
    @Bind(R.id.flag_single_top)
    CheckBox flagSingleTop;
    @Bind(R.id.flag_reorder_to_front)
    CheckBox flagReorderToFront;
    @Bind(R.id.flag_brought_to_front)
    CheckBox flagBroughtToFront;
    @Bind(R.id.flag_forward_result)
    CheckBox flagForwardResult;
    @Bind(R.id.flag_clear_task)
    CheckBox flagClearTask;
    @Bind(R.id.flag_multi_task)
    CheckBox flagMultiTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.v("zlq", this.getClass().getSimpleName() + "-onCreate");
        int taskId = getTaskId();
        taskIdTv.setText(taskId + "");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.v("zlq", this.getClass().getSimpleName() + "-onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.v("zlq", this.getClass().getSimpleName() + "-onRestart");
        super.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.v("zlq", this.getClass().getSimpleName() + "-onNewIntent");
        super.onNewIntent(intent);
    }


    @Override
    protected void onResume() {
        Log.v("zlq", this.getClass().getSimpleName() + "-onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("zlq", this.getClass().getSimpleName() + "-onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("zlq", this.getClass().getSimpleName() + "-onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("zlq", this.getClass().getSimpleName() + "-onDestroy");
        super.onDestroy();
    }

    @OnClick({R.id.startA_btn, R.id.startB_btn, R.id.startC_btn, R.id.startD_btn})
    public void onClick(View view) {
        Intent intent = new Intent();
        int flags = 0x00000000;
        if (flagNewTask.isChecked()) {
            flags |= Intent.FLAG_ACTIVITY_NEW_TASK;
        }
        if (flagMultiTask.isChecked()){
            flags|=Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        }
        if (flagClearTop.isChecked()) {
            flags |= Intent.FLAG_ACTIVITY_CLEAR_TOP;
        }
        if (flagClearTask.isChecked()) {
            flags |= Intent.FLAG_ACTIVITY_CLEAR_TASK;
        }
        if (flagSingleTop.isChecked()) {
            flags |= Intent.FLAG_ACTIVITY_SINGLE_TOP;
        }
        if (flagReorderToFront.isChecked()) {
            flags |= Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
        }
        if (flagBroughtToFront.isChecked()) {
            flags |= Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT;
        }
        if (flagForwardResult.isChecked()) {
            flags |= Intent.FLAG_ACTIVITY_FORWARD_RESULT;
        }
        intent.setFlags(flags);
        Class<?> cl = ActivityA.class;
        switch (view.getId()) {
            case R.id.startA_btn:
                cl = ActivityA.class;
                break;
            case R.id.startB_btn:
                cl = ActivityB.class;
                break;
            case R.id.startC_btn:
                cl = ActivityC.class;
                break;
            case R.id.startD_btn:
                cl = ActivityD.class;
                break;
        }
        intent.setClass(this, cl);
        startActivity(intent);
    }
}
