package com.example.androidstudio2dgamedev.gameobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.androidstudio2dgamedev.R;

public class OBJ_Door extends SuperObject{

    public OBJ_Door(Context context){
        name = "Door";
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.door, bitmapOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap,bitmap.getWidth() * 4,bitmap.getHeight()*4,false);


        collision = true;
    }
}
