package com.appify.anuj.appify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class AdminApplication extends Activity {
    Button back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_applicartion);

        back=(Button)findViewById(R.id.admin_application_back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_admin_button=new Intent(getApplicationContext(),AdminMainActivity.class);
                startActivity(back_admin_button);
            }
        });
    }
}
