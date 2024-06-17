package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openLogin();

        ImageView logoSplash = findViewById(R.id.logoSplash);
        TextView appNameSplash = findViewById(R.id.appNameSplash);



        //activar la animacion
        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        logoSplash.startAnimation(shakeAnimation);
        appNameSplash.startAnimation(shakeAnimation);


        //es para coger una imagen de ineternet y ponerla de fondo
        ImageView background = findViewById(R.id.backgroundSplash);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1507525428034-b723cf961d3e?q=80&w=2073&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .into(background);
    }
    //abrir el login despues de terminado el SplashScreen
    public void openLogin(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 3000);
    }
}