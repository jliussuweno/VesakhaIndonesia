package com.vesakha.vesakhaindonesia.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import com.vesakha.vesakhaindonesia.R;
import com.vesakha.vesakhaindonesia.model.PasswordStrength;
import com.vesakha.vesakhaindonesia.model.User;
import com.vesakha.vesakhaindonesia.viewmodel.SignUpViewModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.widget.Toast.LENGTH_SHORT;

public class SignUpActivity extends AppCompatActivity {

    EditText fullNameEditText;
    EditText emailSignUpEditText;
    EditText passwordSignUpEditText;
    EditText confirmPasswordEditText;
    Button signUpButton;
    TextView logInTextView;
    TextView strengthPassword;
    Toast toast;
    SignUpViewModel signUpViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullNameEditText = findViewById(R.id.editTextTextFullName);
        emailSignUpEditText = findViewById(R.id.editTextTextEmailAddressSignUp);
        passwordSignUpEditText = findViewById(R.id.editTextTextPasswordSignUp);
        confirmPasswordEditText = findViewById(R.id.editTextTextConfirmPassword);
        signUpButton = findViewById(R.id.buttonSignUp);
        logInTextView = findViewById(R.id.textViewLogIn);
        strengthPassword = findViewById(R.id.password_strength);

        signUpButton.setEnabled(false);

        logInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
        fullNameEditText.addTextChangedListener(signUpTextWatcher);
        emailSignUpEditText.addTextChangedListener(signUpTextWatcher);
        passwordSignUpEditText.addTextChangedListener(signUpTextWatcher);
        confirmPasswordEditText.addTextChangedListener(signUpTextWatcher);

        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = fullNameEditText.getText().toString().trim();
                String email = emailSignUpEditText.getText().toString().trim();
                String password = passwordSignUpEditText.getText().toString().trim();

                User user = new User(fullName, email, password);
//                if (signUpViewModel.checkUser(user)){
//                    signUpViewModel.insertUser(user);
//                    if (toast != null){
//                        toast = null;
//                    }
//                    toast = Toast.makeText(SignUpActivity.this, "Email Berhasil Didaftarkan, silahkan Log In!", Toast.LENGTH_LONG);
//                    toast.show();
//                    Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
//                    startActivity(intent);
//                } else {
//                    if (toast != null){
//                        toast = null;
//                    }
//                    toast = Toast.makeText(SignUpActivity.this, "Email Sudah Terdaftar, silahkan gunakan email yang lain!", LENGTH_SHORT);
//                    toast.show();
//                }

            }
        });

    }

    private TextWatcher signUpTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String fullName = fullNameEditText.getText().toString().trim();
            String email = emailSignUpEditText.getText().toString().trim();
            String password = passwordSignUpEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            if (fullName.length() < 4){
                fullNameEditText.setError("Nama Harus lebih dari 4 Character");
            } else if (fullName.length() > 25){
                fullNameEditText.setError("Nama Tidak Maksimal 25 Character");
            } else {
                fullNameEditText.setError(null);
            }

            if (!isEmailValid(email)) {
                emailSignUpEditText.setError("Format Email salah, silahkan periksa kembali");
            } else {
                emailSignUpEditText.setError(null);
            }

            if (password.length() < 8){
                passwordSignUpEditText.setError("Password Harus lebih dari 8 Character");
            } else if (password.length() > 25){
                passwordSignUpEditText.setError("Password Tidak Maksimal 25 Character");
            } else {
                calculatePasswordStrength(password);
                passwordSignUpEditText.setError(null);
            }

            if (!confirmPassword.equals(password)){
                confirmPasswordEditText.setError("Confirm Password Tidak Sama dengan Password");
            } else {
                confirmPasswordEditText.setError(null);
            }

            signUpButton.setEnabled(!fullName.isEmpty() &&
                    !email.isEmpty() &&
                    !password.isEmpty() &&
                    !confirmPassword.isEmpty());
        }
    };

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void calculatePasswordStrength(String str) {
        PasswordStrength passwordStrength = PasswordStrength.calculate(str);
        strengthPassword.setVisibility(View.VISIBLE);
        strengthPassword.setText(passwordStrength.msg);
        strengthPassword.setTextColor(passwordStrength.color);
    }

    public void ShowHidePass(View view) {

        if(view.getId()==R.id.show_pass_btn){
            if(passwordSignUpEditText.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_24);
                passwordSignUpEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.ic_outline_visibility_off_24);
                passwordSignUpEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        } else if (view.getId()==R.id.show_confirmpass_btn){
            if(confirmPasswordEditText.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_24);
                confirmPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.ic_outline_visibility_off_24);
                confirmPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}