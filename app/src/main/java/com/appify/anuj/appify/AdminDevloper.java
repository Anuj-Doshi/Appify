package com.appify.anuj.appify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class AdminDevloper extends Activity {
    Button back,viewDev;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_devloper);
        back=(Button)findViewById(R.id.admin_back_button);
        viewDev=(Button)findViewById(R.id.admin_view_devloper);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_button_intent =new Intent(getApplicationContext(),AdminMainActivity.class);
                startActivity(back_button_intent);
            }
        });
        viewDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_intent =new Intent(getApplicationContext(),admin_view_devloper.class);
                startActivity(view_intent);
            }
        });
    }
}
