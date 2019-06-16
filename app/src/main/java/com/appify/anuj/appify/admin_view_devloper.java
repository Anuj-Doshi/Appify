package com.appify.anuj.appify;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class admin_view_devloper extends Activity {
    DatabaseHalper db;
    ListView userList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    String[] id, name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_view_devloper);
        userList = (ListView) findViewById(R.id.list_view);
        listItem = new ArrayList<>();
        db = new DatabaseHalper(this);
        viewData();
    }

    private void viewData() {
        Cursor cursor = db.viewData();
        name = new String[cursor.getCount()];
        id = new String[cursor.getCount()];
        StringBuffer buffer = new StringBuffer();

        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                id[cursor.getPosition()] = cursor.getString(0);
                name[cursor.getPosition()] = cursor.getString(3);
                buffer.append("Id :" + cursor.getString(0) + "\n");
                buffer.append("First Name :" + cursor.getString(1) + "\n");
                buffer.append("Last Name :" + cursor.getString(2) + "\n");
                buffer.append("Email :" + cursor.getString(3) + "\n\n");
            }
            adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, name);
            userList.setAdapter(adapter);
            userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                    //Toast.makeText(getApplicationContext(),id[position].toString(), Toast.LENGTH_SHORT).show();

                    Intent name_intent = new Intent(getApplicationContext(),admin_view_devloper_details.class);
                    name_intent.putExtra("Email",id[position].toString());
                    startActivity(name_intent);
                }
            });
        }
    }
}
