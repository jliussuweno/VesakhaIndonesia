package com.vesakha.vesakhaindonesia.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.vesakha.vesakhaindonesia.R;
import com.vesakha.vesakhaindonesia.adapter.CartAdapter;
import com.vesakha.vesakhaindonesia.model.Cart;
import com.vesakha.vesakhaindonesia.viewmodel.CartViewModel;

import java.io.IOException;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    CartViewModel cartViewModel;
    CartAdapter cartAdapter;
    RecyclerView recyclerViewCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerViewCart = findViewById(R.id.recyclerViewCart);
        cartAdapter = new CartAdapter();
        recyclerViewCart.setHasFixedSize(true);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCart.setAdapter(cartAdapter);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartViewModel.cartLength();
        cartViewModel.initCart();
        cartViewModel.getListCart().observe(this, new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                cartAdapter.setCartList(carts);
            }
        });




    }
}