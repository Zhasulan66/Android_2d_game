package com.example.androidstudio2dgamedev.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.androidstudio2dgamedev.R;
import com.example.androidstudio2dgamedev.main.MainActivity;

public enum ButtonImages implements BitmapMethods {

    MENU_START(R.drawable.mainmenu_button_start, 300, 140),
    LEVEL_START(R.drawable.level_btn, 400, 150),
    LEVEL_START2(R.drawable.level2_btn, 400, 150),
    LEVEL_START3(R.drawable.level3_btn, 400, 150),
    LEVEL_START4(R.drawable.level4_btn, 400, 150),
    LEVEL_START5(R.drawable.level5_btn, 400, 150),
    PLAYING_MENU(R.drawable.playing_button_menu, 140, 140);

    private int width, height;
    private Bitmap normal, pushed;

    ButtonImages(int resID, int width, int height) {
        options.inScaled = false;
        this.width = width;
        this.height = height;

        Bitmap buttonAtlas = BitmapFactory.decodeResource(MainActivity.getGameContext().getResources(), resID, options);
        normal = Bitmap.createBitmap(buttonAtlas, 0, 0, width, height);
        pushed = Bitmap.createBitmap(buttonAtlas, width, 0, width, height);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Bitmap getBtnImg(boolean isBtnPushed) {
        return isBtnPushed ? pushed : normal;
    }
}
