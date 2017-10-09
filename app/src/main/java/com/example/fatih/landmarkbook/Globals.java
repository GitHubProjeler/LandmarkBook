package com.example.fatih.landmarkbook;

import android.graphics.Bitmap;

/**
 * Created by fatih on 19.09.2017.
 */

public class Globals {

    public static Globals instance;

    private Bitmap chosenImage;//global bir değişken her yerden ulaşılabilir.

    private Globals(){

    }

    //setter metodu
    public void setData(Bitmap chosenImage){
        this.chosenImage=chosenImage;
    }
    //getter metodu
    public Bitmap getData(){
        return this.chosenImage;
    }

    public static Globals getInstance(){
        if(instance==null)
        {
            instance=new Globals();
        }
        return instance;
    }
}
