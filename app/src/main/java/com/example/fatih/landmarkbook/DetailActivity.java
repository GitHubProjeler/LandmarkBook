package com.example.fatih.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView=(TextView) findViewById(R.id.textView);
        ImageView imageView=(ImageView) findViewById(R.id.imageView);

        Intent intent=getIntent();//bilgiyi almaktadır.
        String name=intent.getStringExtra("name");//name bilgisini almaktadır.
        textView.setText(name);//textte yazılmaktadır.

        //imageView.setImageBitmap(MainActivity.selectedImages);

        //Global sınıfla oluşturulan işlemler
        Globals globals=Globals.getInstance();
        Bitmap bitmap=globals.getData();

        imageView.setImageBitmap(bitmap);
    }
}
