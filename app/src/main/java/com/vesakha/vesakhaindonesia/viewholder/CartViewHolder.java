package com.vesakha.vesakhaindonesia.viewholder;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vesakha.vesakhaindonesia.R;
import com.vesakha.vesakhaindonesia.model.Cart;

public class CartViewHolder extends RecyclerView.ViewHolder {

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
