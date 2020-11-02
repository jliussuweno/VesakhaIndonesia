package com.vesakha.vesakhaindonesia.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vesakha.vesakhaindonesia.model.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainViewModel extends AndroidViewModel {

    MutableLiveData<List<Product>> productList;
    Context context;

    public MainViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        productList = new MutableLiveData();
    }

    public MutableLiveData<List<Product>> getProductList() {
        return productList;
    }

    public void initProductData(){


        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://vesakha.id/api/indexPro";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    List<Product> tempProduct = new ArrayList<>();
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i=0; i < jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String idProduct = jsonObject.getString("id");
                            String idDivisi = jsonObject.getString("id_divisi");
                            String idCategory = jsonObject.getString("id_category");
                            String nameProduct = jsonObject.getString("name");
                            String description = jsonObject.getString("description");
                            String detail = jsonObject.getString("detail");
                            String spec = jsonObject.getString("spec");
                            String specVal = jsonObject.getString("specval");
                            String urlImage = jsonObject.getString("img");
                            String priceProduct = jsonObject.getString("price");
                            String weight = jsonObject.getString("weight");
                            String stockProduct = jsonObject.getString("stock");
                            String disc = jsonObject.getString("disc");
                            String dDisc = jsonObject.getString("ddisc");
                            String addDate = jsonObject.getString("add_date");
                            String link = jsonObject.getString("link");
                            tempProduct.add(new Product(idProduct,
                                    idDivisi,
                                    idCategory,
                                    nameProduct,
                                    description,
                                    detail,
                                    spec,
                                    specVal,
                                    urlImage,
                                    priceProduct,
                                    weight,
                                    stockProduct,
                                    disc,
                                    dDisc,
                                    addDate,
                                    link));
                        }

                    } catch (Exception e){
                        Log.d(TAG, "initProductData: "+ e);
                    }
                    productList.postValue(tempProduct);

                }, error -> Log.d(TAG, "That didn't work! "));

        queue.add(stringRequest);

//        tempProduct.add(new Product("1",
//                "Printer 3D",
//                "https://i.picsum.photos/id/369/200/300.jpg?hmac=ZM5SPtUsEjxc4HjsZXj3DAHeKWSaZV6r8sJMGiLYIJ8",
//                "Rp. 25.000.000,00",
//                "10",
//                "13",
//                "15000"));
//        tempProduct.add(new Product("2",
//                "Printer 3D",
//                "https://i.picsum.photos/id/369/200/300.jpg?hmac=ZM5SPtUsEjxc4HjsZXj3DAHeKWSaZV6r8sJMGiLYIJ8",
//                "Rp. 25.000.000,00",
//                "10",
//                "13",
//                "15000"));
//        tempProduct.add(new Product("2",
//                "Printer 4D",
//                "https://i.picsum.photos/id/369/200/300.jpg?hmac=ZM5SPtUsEjxc4HjsZXj3DAHeKWSaZV6r8sJMGiLYIJ8",
//                "Rp. 125.000.000,00",
//                "10",
//                "13",
//                "15000"));

    }
}
