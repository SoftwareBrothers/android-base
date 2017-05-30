package com.rstit.base.ui.main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rstit.base.R;

public class MainActivity extends AppCompatActivity implements MainViewAccess {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override public void setFragment(@NonNull MainViewModel.Type type) {

    }
}
