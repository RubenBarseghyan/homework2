package com.example.ruben.homework2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import javax.xml.transform.Result;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private EditText firstName;
    private  EditText lastName;
    private   boolean gender;
    private String email;
    private String password;
    private Button buttonSave;
    private Button addButton;
    private ImageView imageView;
    private String imageUri;


      private static  final int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = findViewById(R.id.firstNameId);
        lastName = findViewById(R.id.lastNameId);

        buttonSave = findViewById(R.id.saveId);
        buttonSave.setOnClickListener(this);

        addButton = findViewById(R.id.addPhotoId);
        addButton.setOnClickListener(this);

     imageView=findViewById(R.id.chooseImageId);



        imageView.buildDrawingCache();
        Bitmap bitmap = imageView.getDrawingCache();
        Intent intent = new Intent(Register.this, UserDemo.class);

        Bundle extras = new Bundle();
        extras.putParcelable("Bitmap", bitmap);
        intent.putExtras(extras);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saveId:
                imageUri= imageView.getTag().toString();
                Intent intent = new Intent(this, UserDemo.class);
                String info = firstName.getText().toString()+" "+lastName.getText().toString();
                intent.putExtra("INFO", info);
                intent.putExtra("uri", imageUri);
                startActivity(intent);
                break;
            case R.id.addPhotoId:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);


                break;
                    default:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && data!=null){
            Uri selectedImage = data.getData();
            imageView.setImageURI(selectedImage);
            imageView.setTag(selectedImage);

        }
    }

}
