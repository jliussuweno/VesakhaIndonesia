package com.vesakha.vesakhaindonesia.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vesakha.vesakhaindonesia.R;
import com.vesakha.vesakhaindonesia.model.Product;
import com.vesakha.vesakhaindonesia.viewmodel.DescriptionViewModel;

import java.io.Serializable;

public class DescriptionActivity extends AppCompatActivity implements Serializable {

    TextView nameTextView;
    TextView descriptionTextView;
    TextView priceTextView;
    TextView detailTextView;
    ImageView productImageView;
    Button cartButton;
    DescriptionViewModel descriptionViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        nameTextView = findViewById(R.id.textViewNameProductDetail);
        descriptionTextView = findViewById(R.id.textViewDescription);
        priceTextView = findViewById(R.id.textViewPrice);
        detailTextView = findViewById(R.id.textViewDetail);
        productImageView = findViewById(R.id.imageViewProductDetail);
        cartButton = findViewById(R.id.button);

        Intent intent = getIntent();
        Product currentProduct = (Product) intent.getSerializableExtra("product");
        String name = currentProduct.getNameProduct();
        String description = currentProduct.getDescription();
        String price = currentProduct.getPriceProduct();
        String detail = currentProduct.getDetail();
        String imgUrl = currentProduct.getUrlImage();

        descriptionViewModel = new ViewModelProvider(this).get(DescriptionViewModel.class);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        priceTextView.setText(price);
        detailTextView.setText(detail);
        String url = "https://vesakha.id/img/product/" + imgUrl.substring(0, imgUrl.indexOf("|"));
        Picasso.get().load(url).into(productImageView);

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descriptionViewModel.insertCart(currentProduct);
            }
        });

    }
}