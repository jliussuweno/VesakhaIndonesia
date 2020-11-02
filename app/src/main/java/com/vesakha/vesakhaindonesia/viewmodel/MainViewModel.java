package com.vesakha.vesakhaindonesia.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.vesakha.vesakhaindonesia.model.Product;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainViewModel extends AndroidViewModel {

    MutableLiveData<List<Product>> productList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        productList = new MutableLiveData();
    }

    public MutableLiveData<List<Product>> getProductList() {
        return productList;
    }

    public void initProductData(){
        List<Product> tempProduct = new ArrayList<>();
        tempProduct.add(new Product("1",
                "Printer 3D",
                "https://i.picsum.photos/id/369/200/300.jpg?hmac=ZM5SPtUsEjxc4HjsZXj3DAHeKWSaZV6r8sJMGiLYIJ8",
                "Rp. 25.000.000,00",
                "10",
                "13",
                "15000"));
        tempProduct.add(new Product("2",
                "Printer 3D",
                "https://i.picsum.photos/id/369/200/300.jpg?hmac=ZM5SPtUsEjxc4HjsZXj3DAHeKWSaZV6r8sJMGiLYIJ8",
                "Rp. 25.000.000,00",
                "10",
                "13",
                "15000"));
        productList.postValue(tempProduct);
    }
}
