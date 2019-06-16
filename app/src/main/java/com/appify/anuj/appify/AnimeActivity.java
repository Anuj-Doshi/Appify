package com.appify.anuj.appify;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AnimeActivity extends AppCompatActivity {
    TextView app_name,desc;
    ImageView icon1,ss1,ss2,ss3;
    DownloadManager downloadMan;
    Button download;
    String ss1s,ss2s,ss3s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        getSupportActionBar().hide();

        String name=getIntent().getExtras().getString("anime_name");
        String icon=getIntent().getExtras().getString("anime_icon");
        String descs=getIntent().getExtras().getString("anime_desc");
        ss1s=getIntent().getExtras().getString("anime_ss1");
        ss2s=getIntent().getExtras().getString("anime_ss2");
        ss3s=getIntent().getExtras().getString("anime_ss3");
        final String apks=getIntent().getExtras().getString("anime_apk");

        app_name=(TextView)findViewById(R.id.aa_anime_name);
        desc=(TextView)findViewById(R.id.description);
        icon1=(ImageView)findViewById(R.id.aa_thumbnail);
        ss1=(ImageView)findViewById(R.id.aa_ss1);
        ss2=(ImageView)findViewById(R.id.aa_ss2);
        ss3=(ImageView)findViewById(R.id.aa_ss3);
        download=(Button)findViewById(R.id.aa_download);
        app_name.setText(name);
        desc.setText(descs);

        Glide.with(this).load(icon).into(icon1);
        Glide.with(this).load(ss1s).into(ss1);
        Glide.with(this).load(ss2s).into(ss2);
        Glide.with(this).load(ss3s).into(ss3);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadMan= (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri= Uri.parse(apks);
                DownloadManager.Request request=new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref=downloadMan.enqueue(request);

            }
        });

        ss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ss1intent=new Intent(getApplicationContext(),Activityss1.class);
                ss1intent.putExtra("SS1",ss1s);
                startActivity(ss1intent);

            }
        });
        ss2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ss2intent=new Intent(getApplicationContext(),Activityss2.class);
                ss2intent.putExtra("SS2",ss1s);
                startActivity(ss2intent);

            }
        });
        ss3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ss3intent=new Intent(getApplicationContext(),Activityss3.class);
                ss3intent.putExtra("SS3",ss1s);
                startActivity(ss3intent);

            }
        });
    }
}
