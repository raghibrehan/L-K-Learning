package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView signup_redirect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup_redirect=findViewById(R.id.signup_redirect_id);

        //on click on signup redirect btton
        signup_redirect.setOnClickListener(v->{
            startActivity(new Intent(Login.this,signup_activity.class));
        });
    }
}