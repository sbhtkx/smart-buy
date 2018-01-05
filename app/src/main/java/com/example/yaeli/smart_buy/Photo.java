package com.example.yaeli.smart_buy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;
import java.io.File;

public class Photo extends AppCompatActivity implements View.OnClickListener{
    private static final int RESULT_LOAD_IMAGE=1;
    private static final int CAMERA_REQUEST=0;
    ImageView image;
    Button uploadBtn;
    Button submit;
    Button camera;
    private File imageFile;
    public static Uri pic_location=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        image= (ImageView) findViewById(R.id.image);
        uploadBtn= (Button) findViewById(R.id.upload);
        submit= (Button) findViewById(R.id.submit);
        camera=(Button) findViewById(R.id.camera);
        uploadBtn.setOnClickListener(this);
        camera.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            pic_location = data.getData();
            String str=getContentResolver().getType(pic_location);
            if (str.equals("image/jpg") || str.equals("image/jpeg") || str.equals("image/png")) {
                image.setImageURI(pic_location);
                Toast.makeText(this, "The file was saved at " + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
            }
            else {
                pic_location=null;
                Toast.makeText(this, "File type should be jpeg, jpg or png ", Toast.LENGTH_LONG).show();
            }
        }
        else if (requestCode == CAMERA_REQUEST)  {
            switch(resultCode){
                case(RESULT_OK):
                    if (imageFile.exists()) {
                        image.setImageURI(pic_location);
                        Toast.makeText(this, "The file was saved at " + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(this, "There was a problem saving the file ", Toast.LENGTH_LONG).show();
                    }
                    break;

                case(RESULT_CANCELED):
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.upload):
                Intent galleryIntent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                imageFile=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"photo.jpg");
                pic_location=Uri.fromFile(imageFile);
                galleryIntent.putExtra(MediaStore.EXTRA_OUTPUT,pic_location);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;

            case(R.id.camera):
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imageFile=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"photo.jpg");
                pic_location= FileProvider.getUriForFile(this,getApplicationContext().getPackageName()+".fileprovider" ,imageFile);
                //pic_location=Uri.fromFile(imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,pic_location);
                startActivityForResult(cameraIntent,CAMERA_REQUEST);
                break;

            case(R.id.submit):
                Intent intent=new Intent("com.example.yaeli.smart_buy.loginActivity");
                startActivity(intent);
                break;

        }

    }




}
