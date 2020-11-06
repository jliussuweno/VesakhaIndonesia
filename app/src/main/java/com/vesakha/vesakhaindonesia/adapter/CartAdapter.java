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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    List<Cart> cartList = new ArrayList<>();

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tempView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(tempView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        if (cartList != null){
            Cart currentCart = cartList.get(position);
            holder.setData(currentCart);
        }
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {

        TextView nameDivision;
        TextView nameProduct;
        TextView stockProduct;
        TextView priceProduct;
        EditText quantityProduct;
        ImageView imageProduct;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            nameDivision = itemView.findViewById(R.id.textViewNamaDivisi);
            nameProduct = itemView.findViewById(R.id.textViewNamaProductCart);
            stockProduct = itemView.findViewById(R.id.textViewStockCart);
            priceProduct = itemView.findViewById(R.id.textViewPriceCart);
            quantityProduct = itemView.findViewById(R.id.editTextQuantity);
            imageProduct = itemView.findViewById(R.id.imageViewProductCart);
        }

        public void setData(Cart cart){
            String url = "https://vesakha.id/img/product/" + cart.getImg().substring(0, cart.getImg().indexOf("|"));
            Picasso.get().load(url).into(imageProduct);
            nameDivision.setText(cart.getNameProduct());
            nameProduct.setText(cart.getNameProduct());
            stockProduct.setText(cart.getStock());
            priceProduct.setText(cart.getPrice());
            quantityProduct.setText(cart.getQty());
        }
    }
}
