package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

class TreeSnow2Tile extends Tile {
    private final Sprite snowSprite;
    private final Sprite treeBigSprite;

    public TreeSnow2Tile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable) {
        super(mapLocationRect, walkable);
        snowSprite = spriteSheet.getSnowSprite();
        treeBigSprite = spriteSheet.getTreeSnow2Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        snowSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        treeBigSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
