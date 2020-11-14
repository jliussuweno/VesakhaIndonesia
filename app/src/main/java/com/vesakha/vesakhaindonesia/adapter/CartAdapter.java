package com.vesakha.vesakhaindonesia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vesakha.vesakhaindonesia.R;
import com.vesakha.vesakhaindonesia.model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

    List<Cart> cartList = new ArrayList<>();
    private int ITEM_HEADER = 0;
    private int ITEM_MENU = 1;

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    @NonNull
//    @Override
//    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View tempView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
//        return new CartViewHolder(tempView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
//        if (cartList != null){
//            Cart currentCart = cartList.get(position);
//            holder.setData(currentCart);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return cartList.size();
//    }
}
