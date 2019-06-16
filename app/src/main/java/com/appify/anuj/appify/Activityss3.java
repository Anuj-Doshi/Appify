package com.appify.anuj.appify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Activityss3 extends AppCompatActivity {
    ImageView imageView,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss3);
        imageView=(ImageView)findViewById(R.id.en_ss3);
        back=(ImageView)findViewById(R.id.ss3_back);
        String image=getIntent().getExtras().getString("SS3");
        Glide.with(this).load(image).into(imageView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent=new Intent(getApplicationContext(),AnimeActivity.class);

                startActivity(backintent);
            }
        });
    }
}
