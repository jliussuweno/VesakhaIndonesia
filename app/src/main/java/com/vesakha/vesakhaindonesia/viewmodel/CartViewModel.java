package com.vesakha.vesakhaindonesia.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vesakha.vesakhaindonesia.model.Cart;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static android.content.ContentValues.TAG;

public class CartViewModel extends AndroidViewModel {

    public MutableLiveData<List<Cart>> listCart;
    Context context;


    public CartViewModel(@NonNull Application application) {
        super(application);
        listCart = new MutableLiveData<>();
        context = application.getApplicationContext();
    }

    public MutableLiveData<List<Cart>> getListCart() {
        return listCart;
    }

    public AtomicInteger cartLength() {
        AtomicInteger result = new AtomicInteger();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://vesakha.id/api/cartPro";

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, url,
                response -> {
                    Log.d("JJ", "initCart: " + response);

                    List<Cart> tempCart = new ArrayList<>();
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("pro");
                        result.set(jsonArray.length());
                        Log.d(TAG, "cartLength: " + result);

                    } catch (Exception e){
                        Log.d(TAG, "initProductData: "+ e);
                    }
                    listCart.postValue(tempCart);

                }, error -> Log.d(TAG, "That didn't work! ")){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ0b3B0YWwuY29tIiwiZXhwIjoxNDI2NDIwODAwLCJodHRwOi8vdG9wdGFsLmNvbS9qd3RfY2xhaW1zL2lzX2FkbWluIjp0cnVlLCJjb21wYW55IjoiVG9wdGFsIiwiYXdlc29tZSI6dHJ1ZX0.yRQYnWzskCZUxPwaQupWkiUzKELZ49eM7oWxAQK_ZXw");
                params.put("id_user", "2");

                return params;
            }
        };

        queue.add(stringRequest);
        return result;
    }

    public void initCart() {

        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://vesakha.id/api/cartPro";

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, url,
                response -> {
                    Log.d("JJ", "initCart: " + response);

                    List<Cart> tempCart = new ArrayList<>();
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("pro");
                        Log.d("JJ", "initCart: jsonArray " + jsonArray);

                        for (int j=0; j < jsonArray.length(); j++){
                            JSONArray jsonArray1 = jsonArray.getJSONArray(j);
                            Log.d("JJ", "initCart: jsonArray yang dalem lagi" + jsonArray1);
                            for (int i=0; i < jsonArray1.length(); i++){
                                JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                                String idProduct = jsonObject1.getString("id");
                                String idDivisi = jsonObject1.getString("id_divisi");
                                String idCategory = jsonObject1.getString("id_category");
                                String nameProduct = jsonObject1.getString("name");
                                String description = jsonObject1.getString("description");
                                String detail = jsonObject1.getString("detail");
                                String spec = jsonObject1.getString("spec");
                                String specVal = jsonObject1.getString("specval");
                                String urlImage = jsonObject1.getString("img");
                                String priceProduct = jsonObject1.getString("price");
                                String weight = jsonObject1.getString("weight");
                                String stockProduct = jsonObject1.getString("stock");
                                String disc = jsonObject1.getString("disc");
                                String dDisc = jsonObject1.getString("ddisc");
                                String addDate = jsonObject1.getString("add_date");
                                String qty = jsonObject1.getString("qty");
                                tempCart.add(new Cart(idProduct,
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
                                        qty));
                            }
                        }


                    } catch (Exception e){
                        Log.d(TAG, "initProductData: "+ e);
                    }
                    listCart.postValue(tempCart);

                }, error -> Log.d(TAG, "That didn't work! ")){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ0b3B0YWwuY29tIiwiZXhwIjoxNDI2NDIwODAwLCJodHRwOi8vdG9wdGFsLmNvbS9qd3RfY2xhaW1zL2lzX2FkbWluIjp0cnVlLCJjb21wYW55IjoiVG9wdGFsIiwiYXdlc29tZSI6dHJ1ZX0.yRQYnWzskCZUxPwaQupWkiUzKELZ49eM7oWxAQK_ZXw");
                params.put("id_user", "2");

                return params;
            }
        };

        queue.add(stringRequest);

    }

}
