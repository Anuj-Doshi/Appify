package com.appify.anuj.appify;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Instrumentation;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadApps extends Activity {
    DatabaseHelperOfUploadApps myDb;
    TextView appname,type,devname;
    ImageView imageView;
    String picturePath;
    Button back,browse_button,upload_button;
    private static int result_load_image=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_apps);
        back=(Button)findViewById(R.id.devloper_upload_back_button);
        upload_button=(Button)findViewById(R.id.devloper_upload_upload_button);
        imageView=(ImageView)findViewById(R.id.devloper_upload_icon);
        appname=(TextView)findViewById(R.id.devloper_upload_app_name);
        type=(TextView)findViewById(R.id.devloper_upload_type);
        devname=(TextView)findViewById(R.id.devloper_upload_dev_name1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_buton=new Intent(getApplicationContext(),DevloperMainActivity.class);
                startActivity(back_buton);
            }
        });
        browse_button=(Button)findViewById(R.id.devloper_upload_image_view_button);
        browse_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browse_button_intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(browse_button_intent);
            }
        });
        upload_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInsert=myDb.insertData(picturePath,appname.getText().toString(),devname.getText().toString(),type.getText().toString());
                if(isInsert==true)
                {
                    String toast="Registration Successfully Done!";
                    Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_LONG).show();
                }
                else
                {
                    String toast="Registration Un-Successfull ! Try Again!!!";
                    Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_LONG).show();
                }
                StringBuffer buffer = new StringBuffer();
                Cursor res= myDb.getData();
                while(res.moveToNext())
                {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Icon :"+ res.getString(1)+"\n");
                    buffer.append("App Name :"+ res.getString(2)+"\n");
                    buffer.append("Type :"+ res.getString(4)+"\n");
                    showMessage("Data",buffer.toString());

                }
            }
        });
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder bl=new AlertDialog.Builder(getApplicationContext());
        bl.setCancelable(true);
        bl.setTitle(title);
        bl.setMessage(Message);
        bl.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==result_load_image && resultCode==RESULT_OK && null!=data)
        {
            Uri selectedImage=data.getData();
            String[] filePathCoulmn={MediaStore.Images.Media.DATA};

            Cursor cursor =getContentResolver().query(selectedImage,filePathCoulmn,null,null,null);
            cursor.moveToFirst();
            int columnIndex=cursor.getColumnIndex(filePathCoulmn[0]);
            picturePath=cursor.getString(columnIndex);
            cursor.close();

            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}
