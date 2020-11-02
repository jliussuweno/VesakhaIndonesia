package com.vesakha.vesakhaindonesia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vesakha.vesakhaindonesia.R;

import java.io.Serializable;

public class DescriptionActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
    }
}