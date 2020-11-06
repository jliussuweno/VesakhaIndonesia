package com.vesakha.vesakhaindonesia.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.vesakha.vesakhaindonesia.model.Cart;
import com.vesakha.vesakhaindonesia.model.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class CartViewModel extends AndroidViewModel {

    MutableLiveData<List<Cart>> listCart;

    public CartViewModel(@NonNull Application application) {
        super(application);
        listCart = new MutableLiveData<>();
    }

    public void initCart() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ0b3B0YWwuY29tIiwiZXhwIjoxNDI2NDIwODAwLCJodHRwOi8vdG9wdGFsLmNvbS9qd3RfY2xhaW1zL2lzX2FkbWluIjp0cnVlLCJjb21wYW55IjoiVG9wdGFsIiwiYXdlc29tZSI6dHJ1ZX0.yRQYnWzskCZUxPwaQupWkiUzKELZ49eM7oWxAQK_ZXw")
                .addFormDataPart("id_user", "2")
                .build();
        Request request = new Request.Builder()
                .url("https://vesakha.id/api/cartPro")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();

        List<Cart> tempCart = new ArrayList<>();
        try {
            JSONObject jObject = new JSONObject(String.valueOf(response));
            JSONArray jsonArray = jObject.getJSONArray("pro");
            JSONArray jsonArray1 = (JSONArray) jsonArray.get(0);

            for (int i=0; i < jsonArray1.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.d(TAG, "initCart: " + jsonObject);
            }

        } catch (Exception e){
            Log.d(TAG, "initProductData: "+ e);
        }
    }

}
