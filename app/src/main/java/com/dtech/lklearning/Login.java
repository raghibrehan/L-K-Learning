package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText mob_no;
    String Mob;
    Button login;

    TextView signup_redirect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup_redirect=findViewById(R.id.signup_redirect_id);
        login=findViewById(R.id.login_button_id);

        //on click on signup redirect btton
        signup_redirect.setOnClickListener(v->{
            startActivity(new Intent(Login.this,signup_activity.class));


        });

        mob_no=findViewById(R.id.mobile_number);

        login.setOnClickListener(v->{
            Mob=mob_no.getText().toString();
            if(!Mob.isEmpty()){
                Intent intent = new Intent(Login.this,OtpVerification.class);
                intent.putExtra("mob_no",Mob);
                startActivity(intent);


            }
            else{
                mob_no.setError("Empty fields are not allowed");
            }
        });


    }
}