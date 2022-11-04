package com.akj.helpyou.activities;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.akj.helpyou.R;
import com.akj.helpyou.activities.Odsay.BusTimetable;
import com.akj.helpyou.activities.Odsay.FindDirection;

public class ResultRouteActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_road);

        FindDirection fdThread = new FindDirection();
        fdThread.start();

        BusTimetable btTread = new BusTimetable();
        btTread.start();
    }
}
