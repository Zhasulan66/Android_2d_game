package com.example.androidstudio2dgamedev.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.androidstudio2dgamedev.helpers.GameConstants;


public interface BitmapMethods {

    BitmapFactory.Options options = new BitmapFactory.Options();

    default Bitmap getScaledBitmap(Bitmap bitmap){
        return Bitmap.createScaledBitmap(bitmap,bitmap.getWidth() * GameConstants.Sprite.SCALE_MULTIPLIER,bitmap.getHeight()*GameConstants.Sprite.SCALE_MULTIPLIER,false);
    }
}
