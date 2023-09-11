package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

class Stone3Tile extends Tile {
    private final Sprite sand;
    private final Sprite stone3Sprite;

    public Stone3Tile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable) {
        super(mapLocationRect, walkable);
        sand = spriteSheet.getSandSprite();
        stone3Sprite = spriteSheet.getStone3Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sand.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        stone3Sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
