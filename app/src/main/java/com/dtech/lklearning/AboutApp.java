package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class AboutApp extends AppCompatActivity {

    Button backbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        backbut=findViewById(R.id.backbut_aboutapp_id);

        backbut.setOnClickListener(v->{
            finish();
        });

    }
}