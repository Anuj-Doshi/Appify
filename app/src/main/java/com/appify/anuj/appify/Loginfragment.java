package com.appify.anuj.appify;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginfragment extends Fragment implements View.OnClickListener{
    EditText email,password;
    Button login;
    DatabaseHalper myDb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myDb=new DatabaseHalper(getContext());
        return inflater.inflate(R.layout.login,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        login=(Button)getView().findViewById(R.id.login);
        email=(EditText)getView().findViewById(R.id.login_username);
        password=(EditText)getView().findViewById(R.id.login_password);
        login.setOnClickListener(this);
    }
    public void onClick(View v) {

        String user_name="admin";
        String password1="admin";
        if(email.getText().toString().equals(user_name) && password.getText().toString().equals(password1)){
            Intent admin_intent=new Intent(getContext(),AdminMainActivity.class);
            startActivity(admin_intent);
        }

        else if (myDb.checkUser(email.getText().toString().trim()
                , password.getText().toString().trim())) {


            Intent devloper_intent=new Intent(getContext(),DevloperMainActivity.class);
            devloper_intent.putExtra("DevloperName",email.getText().toString());
            startActivity(devloper_intent);

        }
        else {

            Toast.makeText(getContext(), "Not Login Successfully",Toast.LENGTH_LONG).show();

        }
    }
}

