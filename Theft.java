package com.example.pc.tatort;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Theft extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener{
    private static final String REGISTER_URL = "http://vijayanitech.16mb.com/TheftReg.php";

    public static final String KEY_DESC = "desc";

    EditText e;
    Button button2;
    private Spinner spinner;
    private static final String[]paths = {"Select","Larceny", "Identity Theft", "Robbery","Fraud"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theft);

        e=(EditText)findViewById(R.id.desc);
       // String desc=e.getText().toString();

        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        //give its listener and send the description to where ever you want.


        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Theft.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    private void registerUser(){
        final String descc = e.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Theft.this, response, Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Theft.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_DESC,descc);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        AlertDialog alertDialog = new AlertDialog.Builder(Theft.this).create();
        switch (position) {
            case 1:
                alertDialog.setTitle("Larceny");
                alertDialog.setMessage("Simple theft (also known as larceny) is a type of crime that involves unlawfully taking or using property that belongs to another person or entity.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                break;
            case 2:
                alertDialog.setTitle("Identity Theft");
                alertDialog.setMessage("Identity theft charges are becoming increasingly common as personal information becomes easier to obtain. Using another person's name, bank account, credit card, or other personally identifying information without permission can result in identity theft charges being filed. ");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                break;
            case 3:
                alertDialog.setTitle("Robbery");
                alertDialog.setMessage("Using violence, intimidation, or threats to obtain property is typically considered robbery.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

                break;
            case 4:
                alertDialog.setTitle("Fraud");
                alertDialog.setMessage("Stealing that involves deceiving someone to give up their property willingly but under false pretenses rather than using violence or simply walking away with the property is often referred to as fraud.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                break;
            default:
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v == button2){
            registerUser();
        }
    }
}
