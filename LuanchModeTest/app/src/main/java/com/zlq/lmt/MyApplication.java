package com.zlq.lmt;

import android.app.Application;
import android.graphics.Color;
import android.util.SparseArray;

import java.util.ArrayList;

/**
 * Created by zlq on 16/4/8.
 */
public class MyApplication extends Application {
    SparseArray<Integer> taskIdColors;
    ArrayList<Integer> colors;
    static MyApplication instance;

    public static MyApplication getInstance(){
        return instance;
    }

    public ArrayList<Integer> getColors() {
        return colors;
    }

    public Integer getNextColor() {
        Integer result=colors.get(0);
        colors.remove(0);
        return result;
    }

    public void setColors(ArrayList<Integer> colors) {
        this.colors = colors;
    }

    public SparseArray<Integer> getTaskIdColors() {
        return taskIdColors;
    }

    public void setTaskIdColors(SparseArray<Integer> taskIdColors) {
        this.taskIdColors = taskIdColors;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        colors=new ArrayList<>();
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);
        colors.add(Color.LTGRAY);
        colors.add(Color.BLACK);
        colors.add(Color.DKGRAY);
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);
        colors.add(0xFFFFEBEE);
        colors.add(0xFF9FA8DA);
        colors.add(0xFF81D4FA);
        colors.add(0xFF01579B);
        colors.add(0xFF9E9D24);
        colors.add(0xFFB2DFDB);
        colors.add(0xFF004D40);
        colors.add(0xFFF4511E);
        colors.add(0xFF546E7A);
        colors.add(0xFFBA68C8);
        colors.add(0xFFE040FB);


        taskIdColors=new SparseArray<>();
    }
}
