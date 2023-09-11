package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

class Stone2Tile extends Tile {
    private final Sprite sand;
    private final Sprite stone2Sprite;

    public Stone2Tile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable) {
        super(mapLocationRect, walkable);
        sand = spriteSheet.getSandSprite();
        stone2Sprite = spriteSheet.getStone2Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sand.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        stone2Sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
