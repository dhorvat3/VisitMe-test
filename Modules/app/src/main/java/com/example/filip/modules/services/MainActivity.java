package com.example.filip.modules.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import com.example.filip.modules.R;
import com.example.filip.modules.core.DataLoader;
import com.example.filip.modules.core.JsonAdapter;
import com.example.filip.modules.db.Town;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}