package com.example.androidstudio2dgamedev.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.androidstudio2dgamedev.R;
import com.example.androidstudio2dgamedev.main.MainActivity;

public enum GameImages implements BitmapMethods {


    MAINMENU_MENUBG(R.drawable.level_choose);
    private final Bitmap image;

    GameImages(int resID) {
        options.inScaled = false;
        image = BitmapFactory.decodeResource(MainActivity.getGameContext().getResources(), resID, options);
    }

    public Bitmap getImage() {
        return image;
    }
}
