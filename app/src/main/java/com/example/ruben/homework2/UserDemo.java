package com.example.ruben.homework2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class UserDemo extends AppCompatActivity implements View.OnClickListener {
    private TextView userInfo;
    private Button newUser;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_demo);

        imageView =findViewById(R.id.imageId);

        newUser = findViewById(R.id.newUserId);
        userInfo= findViewById(R.id.userTextId);

        Bundle extras = getIntent().getExtras();
        Bitmap bitmap = (Bitmap) extras.getParcelable("Bitmap");
        imageView.setImageBitmap(bitmap);



        Intent intent2 = getIntent();
        String message = intent2.getStringExtra("INFO");
        userInfo.setText(message);

        newUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.newUserId:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.imageId:
                Toast.makeText(this, "kkkkk", Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }

    }
}
