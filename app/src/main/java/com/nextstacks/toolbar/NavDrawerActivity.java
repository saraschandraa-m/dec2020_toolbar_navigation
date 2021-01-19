package com.nextstacks.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavDrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        Toolbar mToolbar = findViewById(R.id.tl_nav_drawer);
        setSupportActionBar(mToolbar);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar,R.string.open, R.string.close);
        drawerToggle.syncState();

        NavigationView navView = findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                TestFragment testFragment = new TestFragment();
                if(item.getItemId() == R.id.action_search){
//                    Toast.makeText(NavDrawerActivity.this, "Search clicked", Toast.LENGTH_LONG).show();

//                    startActivity(new Intent(NavDrawerActivity.this, MainActivity.class));

//                    Intent sampleIntent = new Intent(NavDrawerActivity.this, MainActivity.class);
//                    startActivity(sampleIntent);

                    Bundle arguments = new Bundle();
                    arguments.putString("TITLE", "Search Fragment");

                    testFragment.setArguments(arguments);

                    fm.replace(R.id.fragment_container, testFragment);
                    fm.addToBackStack(null);
                    fm.commit();
                }else if(item.getItemId() == R.id.action_move){
                    Bundle arguments = new Bundle();
                    arguments.putString("TITLE", "Move Fragment");
                    testFragment.setArguments(arguments);

                    fm.replace(R.id.fragment_container, testFragment);
                    fm.addToBackStack(null);
                    fm.commit();

                }
                return true;
            }
        });
    }
}