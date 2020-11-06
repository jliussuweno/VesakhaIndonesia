package com.vesakha.vesakhaindonesia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vesakha.vesakhaindonesia.R;
import com.vesakha.vesakhaindonesia.viewmodel.CartViewModel;

public class CartActivity extends AppCompatActivity {

    CartViewModel cartViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }
}