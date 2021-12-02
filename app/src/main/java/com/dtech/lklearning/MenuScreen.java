package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuScreen extends AppCompatActivity {

    private Button login,aboutapp,availablematerial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        //declaring the buttons
        login=findViewById(R.id.login_button_id);
        aboutapp=findViewById(R.id.about_app_button_id);
        availablematerial=findViewById(R.id.avail_material_button_id);

        //on click on login
        login.setOnClickListener(v->{
            startActivity(new Intent(MenuScreen.this,Login.class));

        });

        //on click on about app button

        aboutapp.setOnClickListener(v->{
            startActivity(new Intent (MenuScreen.this,AboutApp.class));

        });
        //on click on available materials button
        availablematerial.setOnClickListener(v->{
            startActivity(new Intent(MenuScreen.this,AvailableMaterial.class));

        });

    }
}