package com.example.internshipjuly;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.splash_image);

//        Glide.with(SplashActivity.this).asGif()
//                .load("https://i.pinimg.com/originals/fe/a9/2f/fea92f50aa6db93e3a5e9ae9aa27b2a7.gif")
//                .placeholder(R.mipmap.ic_launcher)
//                .into(image);


        Glide.with(SplashActivity.this).asGif()
                .load(R.drawable.splash_screen)
                .placeholder(R.mipmap.ic_launcher)
                .into(image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },3000);

    }
}