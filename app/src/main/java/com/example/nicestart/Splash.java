package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();

        ImageView mSplash = findViewById(R.id.fondo);
        Glide.with(this)
                .load(R.drawable.fondo)
                .transition(DrawableTransitionOptions.withCrossFade(4000))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_700)))
                .into(mSplash);
        ImageView logo;
        logo= findViewById(R.id.logo);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.blink);
        logo.startAnimation(rotate);
        ImageView mRayo = findViewById(R.id.logo);
        Glide.with(this)
                .load(R.drawable.iconrayo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mRayo);
    }
    private void openApp(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },5000);
    }
}