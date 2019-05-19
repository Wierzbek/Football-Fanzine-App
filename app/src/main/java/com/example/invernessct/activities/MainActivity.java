package com.example.invernessct.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.invernessct.API.RetrofitClient;
import com.example.invernessct.R;
import com.example.invernessct.responses.DefaultResponse;
import com.example.invernessct.storage.SharedPreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail, editTextPassword, editTextFirstName, editTextLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextFirstName = findViewById(R.id.editTextFirstName);

        findViewById(R.id.buttonSignup).setOnClickListener(this);
        findViewById(R.id.textViewLogin).setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();

        if (SharedPreferenceManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, DrawerActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void userSignUp(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();

        if(email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
        }

        if(password.length() < 6){
            editTextPassword.setError("Password is required (at least 6 characters!)");
            editTextPassword.requestFocus();
            return;
        }

        if (firstName.isEmpty()){
            editTextFirstName.setError("Name is required");
            editTextEmail.requestFocus();
            return;
        }

        if (lastName.isEmpty()){
            editTextLastName.setError("Last name is required");
            editTextLastName.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(email,password,firstName,lastName);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                if (response.code() == 201){
                    DefaultResponse dr = response.body();

                    Toast.makeText(MainActivity.this, dr.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "User already exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSignup:
                userSignUp();
                break;
            case R.id.textViewLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
