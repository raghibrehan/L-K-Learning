package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class signup_activity extends AppCompatActivity {
    TextView login_redirect;
    private EditText mob_no;
    FirebaseAuth mAuth;
    Button send_otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login_redirect=findViewById(R.id.logintoaccount_id);
        send_otp=findViewById(R.id.button_otpsend_id);


        mAuth=FirebaseAuth.getInstance();
        mob_no=findViewById(R.id.mobile_number_signup_id);

        //on click on login redirect button
        login_redirect.setOnClickListener(v->{
            startActivity(new Intent(signup_activity.this,Login.class));
            finish();


        });

        send_otp.setOnClickListener(v->{
            String mob;
            mob=mob_no.getText().toString();

            if (!mob.isEmpty()){

                Intent intent=new Intent(signup_activity.this,OtpVerification.class);

                intent.putExtra("mob_no",mob);

                startActivity(intent);




            }
            else{
                mob_no.setError("Empty fields are not allowed!");
            }

        });

    }
}