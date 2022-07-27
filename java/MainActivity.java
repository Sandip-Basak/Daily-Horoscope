package com.example.dailyhoroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView aries, taurus, gemini, cancer, leo, virgo, libra, scorpius, sagittarius, capricornus, aquarius, pisces;
    ImageView bg_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bg_img = findViewById(R.id.bg_img);
        aries = findViewById(R.id.img_aries);
        taurus = findViewById(R.id.img_taurus);
        gemini = findViewById(R.id.img_gemini);
        cancer = findViewById(R.id.img_cancer);
        leo = findViewById(R.id.img_leo);
        virgo = findViewById(R.id.img_virgo);
        libra = findViewById(R.id.img_libra);
        scorpius = findViewById(R.id.img_scorpius);
        sagittarius = findViewById(R.id.img_sagittarius);
        capricornus = findViewById(R.id.img_capricornus);
        aquarius = findViewById(R.id.img_aquarius);
        pisces = findViewById(R.id.img_pisces);

        Picasso.get().load("https://images.unsplash.com/photo-1554050857-c84a8abdb5e2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80").into(bg_img);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374404_960_720.jpg").into(aries);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374405_960_720.jpg").into(taurus);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374407_960_720.jpg").into(gemini);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374406_960_720.jpg").into(cancer);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374408_960_720.jpg").into(leo);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374409_960_720.jpg").into(virgo);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/09/zodiac-sign-4374411_960_720.jpg").into(libra);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/09/zodiac-sign-4374412_960_720.jpg").into(scorpius);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/09/zodiac-sign-4374413_960_720.jpg").into(sagittarius);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/09/zodiac-sign-4374414_960_720.jpg").into(capricornus);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/10/zodiac-sign-4374415_960_720.jpg").into(aquarius);
        Picasso.get().load("https://cdn.pixabay.com/photo/2019/07/31/06/10/zodiac-sign-4374416_960_720.jpg").into(pisces);

        aries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Aries", "https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374404_960_720.jpg");
            }
        });
        taurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Taurus", "https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374405_960_720.jpg");
            }
        });
        gemini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Gemini", "https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374407_960_720.jpg");
            }
        });
        cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Cancer", "https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374406_960_720.jpg");
            }
        });
        leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Leo", "https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374408_960_720.jpg");
            }
        });
        virgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Virgo", "https://cdn.pixabay.com/photo/2019/07/31/06/03/zodiac-sign-4374409_960_720.jpg");
            }
        });
        libra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Libra", "https://cdn.pixabay.com/photo/2019/07/31/06/09/zodiac-sign-4374411_960_720.jpg");
            }
        });
        scorpius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Scorpius", "https://cdn.pixabay.com/photo/2019/07/31/06/09/zodiac-sign-4374412_960_720.jpg");
            }
        });
        sagittarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Sagittarius", "https://cdn.pixabay.com/photo/2019/07/31/06/09/zodiac-sign-4374413_960_720.jpg");
            }
        });
        capricornus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Capricorn", "https://cdn.pixabay.com/photo/2019/07/31/06/09/zodiac-sign-4374414_960_720.jpg");
            }
        });
        aquarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Aquarius", "https://cdn.pixabay.com/photo/2019/07/31/06/10/zodiac-sign-4374415_960_720.jpg");
            }
        });
        pisces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoroscopeDetails("Pisces", "https://cdn.pixabay.com/photo/2019/07/31/06/10/zodiac-sign-4374416_960_720.jpg");
            }
        });
    }
    private void HoroscopeDetails(String sign, String icon){
        Intent intent = new Intent(MainActivity.this, details.class);
        intent.putExtra("sign", sign);
        intent.putExtra("icon", icon);
        startActivity(intent);
    }
}