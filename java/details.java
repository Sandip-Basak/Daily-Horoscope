package com.example.dailyhoroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class details extends AppCompatActivity {
    ImageView img_icon,bg_img;
    TextView name, details;
    Button General, Love, Career, daily, weekly, monthly;
    Boolean bg=true, bl=false, bc=false, bd=true, bw=false, bm=false;
    String sign;
    ScrollView scrollView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        daily = findViewById(R.id.btn_daily);
        weekly = findViewById(R.id.btn_weekly);
        monthly = findViewById(R.id.btn_monthly);
        scrollView = findViewById(R.id.scroll_view_details);
        progressBar = findViewById(R.id.progress_bar);
        General = findViewById(R.id.btn_general);
        Love = findViewById(R.id.btn_love);
        Career = findViewById(R.id.btn_career);
        img_icon = findViewById(R.id.img_icon);
        name = findViewById(R.id.name_icon);
        details = findViewById(R.id.details_text);
        bg_img = findViewById(R.id.bg);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("sign"));
        Picasso.get().load("https://images.unsplash.com/photo-1554050857-c84a8abdb5e2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80").into(bg_img);
        Picasso.get().load(intent.getStringExtra("icon")).into(img_icon);
        General.setBackgroundColor(getResources().getColor(R.color.teal_200));
        Love.setBackgroundColor(getResources().getColor(R.color.white));
        Career.setBackgroundColor(getResources().getColor(R.color.white));
        daily.setBackgroundColor(getResources().getColor(R.color.teal_200));
        weekly.setBackgroundColor(getResources().getColor(R.color.white));
        monthly.setBackgroundColor(getResources().getColor(R.color.white));
        sign = intent.getStringExtra("sign").toLowerCase(Locale.ROOT);
        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope/"+sign+"/today";
        getDetails(url, sign);




        General.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bg){
                    progressBar.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);
                    General.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    Love.setBackgroundColor(getResources().getColor(R.color.white));
                    Career.setBackgroundColor(getResources().getColor(R.color.white));
                    bg=true;
                    bl=false;
                    bc=false;
                    if(bd){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope/"+sign+"/today";
                        getDetails(url, sign);
                    }
                    else if(bw){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-weekly/"+sign;
                        getDetails(url, sign);
                    }
                    else if(bm){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-monthly/"+sign;
                        getDetails(url, sign);
                    }
                }

            }
        });
        Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bl){
                    progressBar.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);
                    General.setBackgroundColor(getResources().getColor(R.color.white));
                    Love.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    Career.setBackgroundColor(getResources().getColor(R.color.white));
                    bg=false;
                    bl=true;
                    bc=false;
                    if(bd){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-love/"+sign+"/yesterday";
                        getDetails(url, sign);
                    }
                    else if(bw){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-love-weekly/"+sign+"/single";
                        getDetails(url, sign);
                    }
                    else if(bm){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-love-monthly/"+sign+"/couple";
                        getDetails(url, sign);
                    }
                }
            }
        });
        Career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bc){
                    progressBar.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);
                    General.setBackgroundColor(getResources().getColor(R.color.white));
                    Love.setBackgroundColor(getResources().getColor(R.color.white));
                    Career.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    bg=false;
                    bl=false;
                    bc=true;
                    if(bd){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-career/"+sign+"/tomorrow";
                        getDetails(url, sign);
                    }
                    else if(bw){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-career-weekly/"+sign;
                        getDetails(url, sign);
                    }
                    else if(bm){
                        String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-career-monthly/"+sign;
                        getDetails(url, sign);
                    }
                }
            }
        });
        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.GONE);
                daily.setBackgroundColor(getResources().getColor(R.color.teal_200));
                weekly.setBackgroundColor(getResources().getColor(R.color.white));
                monthly.setBackgroundColor(getResources().getColor(R.color.white));
                bd=true;
                bw=false;
                bm=false;
                if(bg){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope/"+sign+"/today";
                    getDetails(url, sign);
                }
                else if(bl){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-love/"+sign+"/yesterday";
                    getDetails(url, sign);
                }
                else if(bc){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-career/"+sign+"/tomorrow";
                    getDetails(url, sign);
                }

            }
        });
        weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.GONE);
                daily.setBackgroundColor(getResources().getColor(R.color.white));
                weekly.setBackgroundColor(getResources().getColor(R.color.teal_200));
                monthly.setBackgroundColor(getResources().getColor(R.color.white));
                bd=false;
                bw=true;
                bm=false;
                if(bg){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-weekly/"+sign;
                    getDetails(url, sign);
                }
                else if(bl){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-love-weekly/"+sign+"/single";
                    getDetails(url, sign);
                }
                else if(bc){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-career-weekly/"+sign;
                    getDetails(url, sign);
                }
            }
        });
        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.GONE);
                daily.setBackgroundColor(getResources().getColor(R.color.white));
                weekly.setBackgroundColor(getResources().getColor(R.color.white));
                monthly.setBackgroundColor(getResources().getColor(R.color.teal_200));
                bd=false;
                bw=false;
                bm=true;
                if(bg){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-monthly/"+sign;
                    getDetails(url, sign);
                }
                else if(bl){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-love-monthly/"+sign+"/couple";
                    getDetails(url, sign);
                }
                else if(bc){
                    String url = "https://astro-daily-live-horoscope.p.rapidapi.com/horoscope-career-monthly/"+sign;
                    getDetails(url, sign);
                }
            }
        });
    }
    private void getDetails(String url, String sign){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String test = response.getString(sign);
                    details.setText(test);
                    progressBar.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myTag", "Error");
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap header = new HashMap();
                header.put("X-RapidAPI-Key", "1224894767msh8401cb38d529700p1b8734jsn0dad1ce29b06");
                header.put("X-RapidAPI-Host", "astro-daily-live-horoscope.p.rapidapi.com");
                return header;
            }
        };

        queue.add(jsonObjectRequest);
    }
}