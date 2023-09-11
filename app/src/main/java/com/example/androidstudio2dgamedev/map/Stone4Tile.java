package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

class Stone4Tile extends Tile {
    private final Sprite sand;
    private final Sprite stone4Sprite;

    public Stone4Tile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable) {
        super(mapLocationRect, walkable);
        sand = spriteSheet.getSandSprite();
        stone4Sprite = spriteSheet.getStone4Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sand.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        stone4Sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
