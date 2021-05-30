package com.example.ecommerce;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private CardView top1,map2,whatsnew3,category4,add5,contact6;
    private DrawerLayout drawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private TextView navProfileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAuth = FirebaseAuth.getInstance();

        top1=(CardView)findViewById(R.id.toplist);
        map2=(CardView)findViewById(R.id.ex_map);
        whatsnew3=(CardView)findViewById(R.id.whats_new);
        category4=(CardView)findViewById(R.id.category);
        add5=(CardView)findViewById(R.id.advertisement);
        contact6=(CardView)findViewById(R.id.contact_us);

        top1.setOnClickListener(this);
        map2.setOnClickListener(this);
        whatsnew3.setOnClickListener(this);
        category4.setOnClickListener(this);
        add5.setOnClickListener(this);
        contact6.setOnClickListener(this);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");

        drawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(Dashboard.this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View navView = navigationView.inflateHeaderView(R.layout.header);
        navProfileName = (TextView) navView.findViewById(R.id.header_name);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                UserMenuSelector(item);
                return false;
            }
        });




    }

    private void UserMenuSelector(MenuItem item)
    {
        switch ( item.getItemId())
        {
            case R.id.profile:
                SendUserToProfileActivity();
                break;
            case R.id.orders:
                SendUserToOrdersActivity();
                break;
            case R.id.logout:
                mAuth.signOut();
                SendUserToLoginActivity();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void SendUserToOrdersActivity() {
        Intent homeIntent = new Intent(this,Orders.class);
        startActivity(homeIntent);
    }

    private void SendUserToProfileActivity() {
        Intent profileIntent = new Intent(this,Profile.class);
        startActivity(profileIntent);
    }

    private void SendUserToLoginActivity()
    {
        Intent loginIntent = new Intent(this,MainActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){

            case R.id.toplist:
                i=new Intent(this,Toplist.class);
                startActivity(i);
                break;
            case R.id.ex_map:
                i=new Intent(this,MapsActivity.class);
                startActivity(i);
                break;
            case R.id.whats_new:
                i=new Intent(this,Whatsnew.class);
                startActivity(i);
                break;
            case R.id.category:
                i=new Intent(this,Categories.class);
                startActivity(i);
                break;
            case R.id.advertisement:
                i=new Intent(this,Advertisement.class);
                startActivity(i);
                break;
            case R.id.contact_us:
                i=new Intent(this,Contact.class);
                startActivity(i);
                break;
                default:break;
        }



    }
}
