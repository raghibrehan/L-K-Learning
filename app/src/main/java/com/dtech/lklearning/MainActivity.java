package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.startActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, MenuScreen.class));

                SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                String checkbox = preferences.getString("remember","");
                if(checkbox.equals("true")){
                    startActivity( new Intent(MainActivity.this, Home.class));
                    Toast.makeText(MainActivity.this, "Remembered You!", Toast.LENGTH_SHORT).show();
                    finish();

                }
                else{
                    Toast.makeText(MainActivity.this, "Wellcome", Toast.LENGTH_SHORT).show();
                }

                finish();

            }
        }, 2000);
            }
}