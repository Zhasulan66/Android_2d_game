package com.example.androidstudio2dgamedev.gameobject;

import static com.example.androidstudio2dgamedev.map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.androidstudio2dgamedev.map.MapLayout.TILE_WIDTH_PIXELS;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.main.GameDisplay;

public class SuperObject {

    public Bitmap bitmap;
    public String name;
    public boolean collision = false;
    public double worldX, worldY;
    public Rect rect = new Rect(0, 0, TILE_WIDTH_PIXELS, TILE_HEIGHT_PIXELS);
    public Rect rect2 = new Rect(0, 0, TILE_WIDTH_PIXELS, TILE_HEIGHT_PIXELS);

    public void draw(Canvas canvas, GameDisplay gameDisplay) {

        int x = (int) gameDisplay.gameToDisplayCoordinatesX(worldX);
        int y = (int) gameDisplay.gameToDisplayCoordinatesY(worldY);


        canvas.drawBitmap(
                bitmap,
                rect,
                new Rect(x, y, x+rect.width(), y+rect.height()),
                null
        );
    }

}
