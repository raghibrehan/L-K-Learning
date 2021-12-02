package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class ContactUs extends AppCompatActivity {

    ImageView Drawer_contactus,back_contactus;
    DrawerLayout drawerLayout_contactus;
    NavigationView navigation_contactus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Drawer_contactus=findViewById(R.id.drawer_contactus_id);
        drawerLayout_contactus=findViewById(R.id.drawerLayout_contactus_id);
        navigation_contactus=findViewById(R.id.nav_contactus_menu);
        back_contactus=findViewById(R.id.back_contactus_id);

        back_contactus.setOnClickListener(v->{
            finish();
        });

        Drawer_contactus.setOnClickListener(v->{
            drawerLayout_contactus.openDrawer(GravityCompat.START);
        });

    }
}