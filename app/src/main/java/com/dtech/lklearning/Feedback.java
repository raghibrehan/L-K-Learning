package com.dtech.lklearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class Feedback extends AppCompatActivity {
    DrawerLayout drawerLayout_feedback;
    NavigationView navigationView_feedback;
    ImageView Drawer_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        drawerLayout_feedback=findViewById(R.id.drawerLayout_feedback_id);
        Drawer_feedback=findViewById(R.id.drawer_feedback_id);
        navigationView_feedback=findViewById(R.id.nav_feedback_menu);

        //drawer yet to finish

        Drawer_feedback.setOnClickListener(v->{
            drawerLayout_feedback.openDrawer(GravityCompat.START);


        });

    }
}