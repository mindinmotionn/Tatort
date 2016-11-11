package com.example.pc.tatort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class StopCrime extends AppCompatActivity implements View.OnClickListener {
    Button camera;
    EditText e;
    String description;
    Button buttondesc;
    private static final String REGISTER_URL = "http://vijayanitech.16mb.com/stopcrimereg.php";

    public static final String KEY_DESC = "desc";
    public static final String KEY_PIC = "pic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_crime);
        camera=(Button)findViewById(R.id.imageButton7);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
            }
        });

        e=(EditText)findViewById(R.id.editText);
         buttondesc=(Button)findViewById(R.id.buttondesc);
        buttondesc.setOnClickListener(this);


    }
    private void registerUser(){
        final String desc = e.getText().toString().trim();
        final String pic = "as";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(StopCrime.this, response, Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StopCrime.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_DESC,desc);
                params.put(KEY_PIC,pic);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onClick(View v) {
        if(v == buttondesc){
            registerUser();
        }
    }
}
