package com.vesakha.vesakhaindonesia.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.vesakha.vesakhaindonesia.model.User;

public class SignUpViewModel extends AndroidViewModel {

    Context context;

    public SignUpViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public void checkUser(User user){
    }

    public void insertUser(User user){

    }

}
