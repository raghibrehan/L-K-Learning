package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class signup_activity extends AppCompatActivity {
    TextView login_redirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login_redirect=findViewById(R.id.logintoaccount_id);

        //on click on login redirect button
        login_redirect.setOnClickListener(v->{
            startActivity(new Intent(signup_activity.this,Login.class));
            finish();
        });
    }
}