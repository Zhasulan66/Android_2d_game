package com.example.androidstudio2dgamedev.gameobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.androidstudio2dgamedev.R;

public class OBJ_Key extends SuperObject{

    public OBJ_Key(Context context){
        name = "Key";
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.key, bitmapOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap,bitmap.getWidth() * 4,bitmap.getHeight()*4,false);
    }

}
