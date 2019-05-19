package com.example.invernessct.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.invernessct.R;
import com.example.invernessct.fragments.FixturesFragment;
import com.example.invernessct.fragments.PostsFragment;
import com.example.invernessct.fragments.SquadFragment;
import com.example.invernessct.fragments.StandingsFragment;
import com.example.invernessct.storage.SharedPreferenceManager;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String userType = SharedPreferenceManager.getInstance(this).getUser().getUser_type();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Display fixtures when user type = premium
        if (userType.equals("Premium")) {
            displayFragment(new PostsFragment());
        } else {
            displayFragment(new FixturesFragment());
        }
    }

    // Display xml fragments in the relativeLayout inside activity_profile.xml
    private void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }

    @Override
    public void onStart() {
        super.onStart();

        if (!SharedPreferenceManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);

        // Display user name and email in the drawer menu
        TextView textViewUserEmail, textViewUserName;
        textViewUserEmail = findViewById(R.id.textViewUserEmail);
        textViewUserName = findViewById(R.id.textViewUserName);

        String fullName = (SharedPreferenceManager.getInstance(this).getUser().getFirst_name() + " "
        + SharedPreferenceManager.getInstance(this).getUser().getLast_name());
        textViewUserEmail.setText(SharedPreferenceManager.getInstance(this).getUser().getEmail());
        textViewUserName.setText(fullName);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        String premium = "Premium";

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_fixtures) {
            // Handle the camera action
            fragment = new FixturesFragment();
            displayFragment(fragment);
        } else if (id == R.id.menu_standings) {
            fragment = new StandingsFragment();
            displayFragment(fragment);
        } else if (id == R.id.menu_squad) {
            fragment = new SquadFragment();
            displayFragment(fragment);
        } else if (id == R.id.menu_newsFeed && userType.equals("Premium")) {
            fragment = new PostsFragment();
            displayFragment(fragment);

        } else if ((id == R.id.menu_newsFeed) && !userType.equals("Premium")) {
            Toast.makeText(DrawerActivity.this, "Get premium to view News Feed ", Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.nav_share) {
            Intent intent = new Intent(this, UserProfile.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else if (id == R.id.menu_Logout) {
            SharedPreferenceManager.getInstance(this).clear();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        else if (id == R.id.menu_buy_premium) {
            Intent intent = new Intent(DrawerActivity.this, BraintreeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
