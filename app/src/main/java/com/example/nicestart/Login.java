package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView mGirl = findViewById(R.id.girl);
        Glide.with(this)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(4000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_700)))
                .into(mGirl);

        ImageView mRayo = findViewById(R.id.logo);
        Glide.with(this)
                .load(R.drawable.iconrayo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mRayo);

    }
    public void openMain(View v){
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void openSignup(View v) {
        Intent intent = new Intent (Login.this, Register.class);
        startActivity(intent);
    }

}