    package com.vesakha.vesakhaindonesia.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vesakha.vesakhaindonesia.model.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class DescriptionViewModel extends AndroidViewModel {

    Context context;
    private Map<String, String> mParams;

    public DescriptionViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void insertCart(Product product){

//        (POST) /api/addCart (id_product,qty)

        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://vesakha.id/api/addCart";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {

                    try {
                        Log.d(TAG, "insertCart: " + response);

                    } catch (Exception e){
                        Log.d(TAG, "insertCart: " + e);
                    }

                }, error -> Log.d(TAG, "That didn't work! ")){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("id_product",product.getIdProduct());
                params.put("qty", "1");
                return params;
            }
        };

        queue.add(stringRequest);
    }

}
