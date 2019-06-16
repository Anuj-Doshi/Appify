package com.appify.anuj.appify;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrationfragment extends Fragment implements View.OnClickListener {

    EditText fname,lname,email,password;
    Button signup;
    DatabaseHalper myDb;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myDb=new DatabaseHalper(getContext());
        return inflater.inflate(R.layout.registration,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        signup=(Button)getView().findViewById(R.id.reg_signup);
        fname=(EditText)getView().findViewById(R.id.reg_firstname);
        lname=(EditText)getView().findViewById(R.id.reg_lastname);
        email=(EditText)getView().findViewById(R.id.reg_email);
        password=(EditText)getView().findViewById(R.id.reg_password);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        boolean isInsert=myDb.insertData(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),password.getText().toString());
        if(isInsert==true)
        {
            String toast="Registration Successfully Done!";
            Toast.makeText(getContext(),toast,Toast.LENGTH_LONG).show();
        }
        else
        {
            String toast="Registration Un-Successfull ! Try Again!!!";
            Toast.makeText(getContext(),toast,Toast.LENGTH_LONG).show();
        }
        StringBuffer buffer = new StringBuffer();
        Cursor res= myDb.getData();
        while(res.moveToNext())
        {
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            showMessage("Data",buffer.toString());

        }
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder bl=new AlertDialog.Builder(getContext());
        bl.setCancelable(true);
        bl.setTitle(title);
        bl.setMessage(Message);
        bl.show();
    }
}
