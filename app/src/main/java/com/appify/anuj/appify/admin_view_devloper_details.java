package com.appify.anuj.appify;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

public class admin_view_devloper_details extends Activity {
    DatabaseHalper myDb;
    Intent view_intent;
    TextView first_name,last_name,email,did,textView1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_view_devloper_detail);
        first_name=(TextView)findViewById(R.id.admin_view_devloper_details_fname_show);
        last_name=(TextView)findViewById(R.id.admin_view_devloper_details_lname_show);
        email=(TextView)findViewById(R.id.admin_view_devloper_details_email_show);
        did=(TextView)findViewById(R.id.admin_view_devloper_details_id_show);
        textView1=(TextView)findViewById(R.id.admin_view_devloper_details_text_view);
        view_intent=getIntent();
        myDb=new DatabaseHalper(this);
        String id=view_intent.getStringExtra("Email");
        show(id);
    }
    public void show(String id){

        Cursor res = myDb.productDetail(id);
        String name[] = new String[res.getCount()];

        StringBuffer buffer = new StringBuffer();

        while (res.moveToNext()) {
            name[res.getPosition()] = res.getString(0);
            textView1.setText("Details of"+res.getString(1)+" "+res.getString(2));
            did.setText( res.getString(0));
            first_name.setText( res.getString(1));
            last_name.setText( res.getString(2));
            email.setText( res.getString(3));
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            buffer.append("Surname :"+ res.getString(2)+"\n");
            buffer.append("Marks :"+ res.getString(3)+"\n\n");
        }

    }

}
