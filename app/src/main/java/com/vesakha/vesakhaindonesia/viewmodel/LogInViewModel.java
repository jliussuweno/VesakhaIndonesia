package com.vesakha.vesakhaindonesia.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;



public class LogInViewModel extends AndroidViewModel {

    Context context;

    public LogInViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public int checkLogin(String email, String password){
        return 1;
    }
}
