package com.example.lifecycledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_counter;
    Button btn_clicker;

    int clicks = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickervalue", clicks);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        clicks = savedInstanceState.getInt("clickervalue");
        tv_counter = findViewById(R.id.tv_counter);
        tv_counter.setText(Integer.toString(clicks));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecyclefilter", "the app is started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecyclefilter", "the app is stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecyclefilter", "the app is destroyed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecyclefilter", "the app is paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecyclefilter", "the app is resumed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecyclefilter", "the app is restarted");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecyclefilter", "the app is created");

        btn_clicker = findViewById(R.id.btn_clicker);
        tv_counter = findViewById(R.id.tv_counter);

        btn_clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                tv_counter.setText(Integer.toString(clicks));
            }
        });
    }
}
