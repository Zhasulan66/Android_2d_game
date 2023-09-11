package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

class Stone1Tile extends Tile {
    private final Sprite sand;
    private final Sprite stone1Sprite;

    public Stone1Tile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable) {
        super(mapLocationRect, walkable);
        sand = spriteSheet.getSandSprite();
        stone1Sprite = spriteSheet.getStone1Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sand.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        stone1Sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
