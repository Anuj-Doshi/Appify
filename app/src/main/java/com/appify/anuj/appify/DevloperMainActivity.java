package com.appify.anuj.appify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DevloperMainActivity extends Activity {
    TextView devloper_name;
    Button upload_apps,view_apps,rejected_apps,approved_apps,delete_apps,logout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.devloper_main_activity);

        upload_apps=(Button)findViewById(R.id.dev_upload_apps_button);
        view_apps=(Button)findViewById(R.id.dev_view_apps_button);
        rejected_apps=(Button)findViewById(R.id.dev_rejected_app_button);
        approved_apps=(Button)findViewById(R.id.dev_approved_app_button);
        delete_apps=(Button)findViewById(R.id.dev_delete_apps_button);

        devloper_name=(TextView)findViewById(R.id.devloper_welocome_msg2);

        Intent i=getIntent();
        String take=i.getStringExtra("DevloperName");

        devloper_name.setText("Welocme,"+take);

        upload_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_upload_apps=new Intent(getApplicationContext(),UploadApps.class);
                startActivity(intent_upload_apps);

            }
        });
    }
}
