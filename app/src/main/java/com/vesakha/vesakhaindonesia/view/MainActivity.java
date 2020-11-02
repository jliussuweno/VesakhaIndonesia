package com.vesakha.vesakhaindonesia.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.vesakha.vesakhaindonesia.R;
import com.vesakha.vesakhaindonesia.adapter.ProductAdapter;
import com.vesakha.vesakhaindonesia.callback.ProductCallback;
import com.vesakha.vesakhaindonesia.model.Product;
import com.vesakha.vesakhaindonesia.viewmodel.MainViewModel;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductCallback, Serializable {

    private ProductAdapter productAdapter;
    private RecyclerView productRecyclerView;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productAdapter = new ProductAdapter();
        productAdapter.setProductCallback(this);
        productRecyclerView = findViewById(R.id.productRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        productRecyclerView.setHasFixedSize(true);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(productAdapter);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.initProductData();
        mainViewModel.getProductList().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productAdapter.setProductList(products);
            }
        });

    }

    @Override
    public void productPressed(Product product) {
        Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
        intent.putExtra("product", (Serializable) product);
        startActivity(intent);
    }
}