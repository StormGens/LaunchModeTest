package com.zlq.lmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zlq on 16/4/8.
 */
public class BaseActivity extends AppCompatActivity {

    private static final int REQUEST_STANDARD = 100;
    private static final int REQUEST_SINGLE_TOP = 101;
    private static final int REQUEST_SINGLE_TASK = 102;
    private static final int REQUEST_SINGLE_TASK_A = 103;
    private static final int REQUEST_SINGLE_INSTANCE = 104;
    @Bind(R.id.taskId_tv)
    TextView taskIdTv;
    @Bind(R.id.taskId_ll)
    LinearLayout taskIdBg;

    @Bind(R.id.standard_btn)
    Button standardBtn;
    @Bind(R.id.singleTop_btn)
    Button singleTopBtn;
    @Bind(R.id.singleTask_btn)
    Button singleTaskBtn;
    @Bind(R.id.singleInstance_btn)
    Button singleInstanceBtn;
    @Bind(R.id.for_result)
    CheckBox forResult;
    @Bind(R.id.singleTask_taskA_btn)
    Button singleTaskTaskABtn;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                setResult(RESULT_OK);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        int taskId = getTaskId();
        taskIdTv.setText(taskId + "");
        Integer color = MyApplication.getInstance().getTaskIdColors().get(taskId);
        if (color == null) {
            color = MyApplication.getInstance().getNextColor();
            MyApplication.getInstance().getTaskIdColors().put(taskId, color);
        }
        taskIdBg.setBackgroundColor(color);
    }

    @OnClick({R.id.standard_btn, R.id.singleTop_btn, R.id.singleTask_btn, R.id
            .singleInstance_btn, R.id.singleTask_taskA_btn})
    public void onClick(View view) {
        Intent intent = new Intent();
        int requestCode=REQUEST_STANDARD;
        switch (view.getId()) {
            case R.id.standard_btn:
                intent.setClass(getBaseContext(), StandardActivity.class);
                requestCode=REQUEST_STANDARD;
                break;
            case R.id.singleTop_btn:
                intent.setClass(getBaseContext(), SingleTopActivity.class);
                requestCode=REQUEST_SINGLE_TOP;
                break;
            case R.id.singleTask_btn:
                intent.setClass(getBaseContext(), SingleTaskActivity.class);
                requestCode=REQUEST_SINGLE_TASK;
                break;
            case R.id.singleInstance_btn:
                intent.setClass(getBaseContext(), SingleInstanceActivity.class);
                requestCode=REQUEST_SINGLE_INSTANCE;
                break;
            case R.id.singleTask_taskA_btn:
                intent.setClass(getBaseContext(), SingleTaskWithTaskAffinityActivity.class);
                requestCode=REQUEST_SINGLE_TASK_A;
                break;
        }
        if (forResult.isChecked()){
            startActivityForResult(intent,requestCode);
        }else {
            startActivity(intent);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(BaseActivity.this, "RequestCode:"+requestCode+". resultCode:"+resultCode,
                Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);
    }
}
