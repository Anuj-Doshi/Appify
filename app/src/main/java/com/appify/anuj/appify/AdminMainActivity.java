package com.appify.anuj.appify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class AdminMainActivity extends Activity {
    Button devloper,application;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_main_activity);

        devloper=(Button)findViewById(R.id.admin_devloper);
        application=(Button)findViewById(R.id.admin_application);

        devloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devloper_intent=new Intent(getApplicationContext(),AdminDevloper.class);
                startActivity(devloper_intent);
            }
        });
        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent application_intent=new Intent(getApplicationContext(),AdminApplication.class);
                startActivity(application_intent);
            }
        });
    }
}
