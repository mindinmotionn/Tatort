package com.example.pc.tatort;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    AppCompatImageButton stopcrime, medical, dial100, womenhelp, theft, emergency;
//TextView pname;
   // String dpname,dppic;
   // ImageView dpofuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
       // pname = (TextView) findViewById(R.id.profilename);
       // dpofuser = (ImageView) findViewById(R.id.imagedp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();

                Intent flt = new Intent(android.content.Intent.ACTION_VIEW);
                flt.setType("vnd.android-dir/mms-sms");
                flt.putExtra("address","9536604556");
                flt.putExtra("sms_body","Need Immediate Help...Contact or Trace me!!");
                startActivity(flt);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       // Intent gname = getIntent();
        //dpname = gname.getExtras().getString("Profilename");
        //pname.setText(dpname);

        /*Intent gpic = getIntent();
        if(getIntent().hasExtra("byteArray")) {
            ImageView previewThumbnail = new ImageView(this);
            Bitmap b = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            previewThumbnail.setImageBitmap(b);
        }*/





        stopcrime = (AppCompatImageButton) findViewById(R.id.imageButton);
        theft = (AppCompatImageButton) findViewById(R.id.imageButton3);
        medical = (AppCompatImageButton) findViewById(R.id.imageButton2);
        womenhelp = (AppCompatImageButton) findViewById(R.id.imageButton4);
        emergency = (AppCompatImageButton) findViewById(R.id.imageButton6);
        dial100 = (AppCompatImageButton) findViewById(R.id.imageButton5);

        stopcrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crime=new Intent(HomePage.this,StopCrime.class);
                startActivity(crime);
            }
        });

        theft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,Theft.class);
                startActivity(i);
            }
        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,MapsActivity.class);
                startActivity(i);
            }
        });



        dial100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:100"));
                startActivity(dial);
            }
        });
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial1 = new Intent(Intent.ACTION_DIAL);
                dial1.setData(Uri.parse("tel:108"));
                startActivity(dial1);
            }
        });
        womenhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial1090 = new Intent(Intent.ACTION_DIAL);
                dial1090.setData(Uri.parse("tel:1090"));
                startActivity(dial1090);
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
            //build the body of the message to be shared
            String shareMessage = "Install TATORT-Made with love in India from vijayanitech.com/downloadapp/platform-android";

//add the message
            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                    shareMessage);


//set the type
            shareIntent.setType("text/plain");
            startActivity(shareIntent);

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
