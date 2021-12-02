package com.dtech.lklearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class Home extends AppCompatActivity {

    ImageView drawer;
    NavigationView navigation;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawer=findViewById(R.id.drawer_home_id);


        //declaring navigation for drawer
        navigation=findViewById(R.id.nav_menu);
        drawerLayout=findViewById(R.id.drawer);

        drawer.setOnClickListener(v->{
            drawerLayout.openDrawer(GravityCompat.START);
        });

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.materials_id:
                        startActivity(new Intent(Home.this , Materials.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                }
                switch(item.getItemId()){
                    case R.id.contact_us_id:
                        startActivity(new Intent(Home.this,ContactUs.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });


    }
}