package com.example.androidstudio2dgamedev.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

    private final SpriteSheet spriteSheet;
    private final Rect rect;


    public Sprite(SpriteSheet spriteSheet, Rect rect) {
        this.spriteSheet = spriteSheet;
        this.rect = rect;

    }

    public void draw(Canvas canvas, int x, int y) {
        Rect destRect = new Rect(
                x,
                y,
                x + getWidth() * 4,
                y + getHeight() * 4
        );
        canvas.drawBitmap(
                spriteSheet.getBitmap(),
                rect,
                destRect,
                null
        );
        /*canvas.drawBitmap(
                spriteSheet.getBitmap(),
                rect,
                new Rect(x, y, x+getWidth(), y+getHeight()),
                null
        );*/
    }


    public Rect getRect() {
        return rect;
    }

    public int getWidth() {
        return rect.width();
    }

    public int getHeight() {
        return rect.height();
    }


}
