package com.vesakha.vesakhaindonesia.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vesakha.vesakhaindonesia.R;
import com.vesakha.vesakhaindonesia.callback.ProductCallback;
import com.vesakha.vesakhaindonesia.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private List<Product> productList = new ArrayList<>();
    private ProductCallback productCallback = null;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public void setProductCallback(ProductCallback productCallback) {
        this.productCallback = productCallback;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tempView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(tempView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct = productList.get(position);
        holder.setProduct(currentProduct);
        holder.getParent().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productCallback != null){
                    productCallback.productPressed(currentProduct);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView nameProdTextView;
        TextView priceProdTextView;
        ImageView productImageView;
        View parent;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView;
            productImageView = itemView.findViewById(R.id.imageView);
            priceProdTextView = itemView.findViewById(R.id.textViewHarga);
            nameProdTextView = itemView.findViewById(R.id.textViewNamaProduct);
        }

        public View getParent(){
            return parent;
        }

        public void setProduct(Product product){
            Picasso.get().load(product.getUrlImage()).into(productImageView);
            Log.d("JEJE", "setProduct: " + product.getUrlImage());
            priceProdTextView.setText(product.getPriceProduct());
            nameProdTextView.setText(product.getNameProduct());
        }
    }
}
