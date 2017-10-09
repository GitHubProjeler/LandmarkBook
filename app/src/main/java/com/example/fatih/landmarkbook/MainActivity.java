package com.example.fatih.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImages;//Diğer activity den ulaşmak için static kullanılması gerekiyor.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView=(ListView) findViewById(R.id.listView);

        final ArrayList<String> landmarkNames=new ArrayList<>();//Dizi listesi oluşturuluyor.
        //isimleri veriliyor
        landmarkNames.add("Pisa");
        landmarkNames.add("Colosseum");
        landmarkNames.add("Eiffel");
        landmarkNames.add("London Bridge");

        //Resimler Bitmap çevriliyor
        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap colosseum=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colosseum);
        Bitmap eiffel=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap londonBridge=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages=new ArrayList<>();
        //Bitmap çevirlen resimler ArrayListe ekleniyor
        landmarkImages.add(pisa);
        landmarkImages.add(colosseum);
        landmarkImages.add(eiffel);
        landmarkImages.add(londonBridge);

        //ArrayList ile ListView ArrayAdapter ile birleştiriliyor. Listenin ekranda görünebilmesi için
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames);//simple_list_item_1 listviewde nasıl listeleneceğini belirtmektedir. landmarkNames hangi arraylist olduğunu işaret etmektedir.
        listView.setAdapter(arrayAdapter);

        //listview e tıklandığında yapılacaklar
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//i değişkeni indextir.
              Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
              intent.putExtra("name",landmarkNames.get(i));//intent ile name aktarılıyor. i ile listview içerisinde bulunan index değerine göre getirektedir.

         //     selectedImages=landmarkImages.get(i);//kotlinde kullanılmamaktadır. kolay yöntemdir.

              //kotlinde kullanılmaktadır.
              Bitmap bitmap=landmarkImages.get(i);//tıklanana göre resimin indexi alınıyor bitmap değişkenine aktarılıyor
              Globals globals=Globals.getInstance();
              globals.setData(bitmap);

              startActivity(intent);
          }
      });

    }



}
