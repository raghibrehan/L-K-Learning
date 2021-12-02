package com.dtech.lklearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class Materials extends AppCompatActivity {

    ImageView drawer_material,prev;
    NavigationView navigation_material;
    DrawerLayout drawerLayout_material;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);
        drawer_material=findViewById(R.id.drawer_material_id);
        navigation_material=findViewById(R.id.nav_material_menu);
        drawerLayout_material=findViewById(R.id.drawer_materials);
        prev=findViewById(R.id.back_material_id);

        prev.setOnClickListener(v->{
            finish();
        });

        drawer_material.setOnClickListener(v->{
            drawerLayout_material.openDrawer(GravityCompat.START);
        });

        navigation_material.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.materials_id:
                        drawerLayout_material.closeDrawer(GravityCompat.START);
                }

                return true;
            }
        });





    }
}