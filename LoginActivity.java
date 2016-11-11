package com.example.pc.tatort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String LOGIN_URL = "http://vijayanitech.in/Logintoo.php";
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLoginnn;
    Button buttonfb,logingm;
    TextView tvv;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        tvv = (TextView) findViewById(R.id.link_signup);
        buttonfb=(Button)findViewById(R.id.loginfb);
        logingm=(Button)findViewById(R.id.logingmail);
        buttonLoginnn = (Button) findViewById(R.id.buttonloginnn);
        buttonLoginnn.setOnClickListener(this);

        tvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(LoginActivity.this,Signup.class);
                startActivity(ii);
            }
        });


    /*    logingm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this,Logingmail.class);
                startActivity(i);
            }
        });
        buttonfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, Fblogin.class);
                startActivity(i);
            }
        }); */


    }



    private void userLogin() {
        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            openProfile();
                        }else{
                            Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,username);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void openProfile(){
        Intent intent = new Intent(this, HomePage.class);
        intent.putExtra(KEY_USERNAME, username);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        if(v==buttonLoginnn) {
            userLogin();
        }  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fblogin, menu);
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
    }}