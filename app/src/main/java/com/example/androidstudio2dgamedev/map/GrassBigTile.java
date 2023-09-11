package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

public class GrassBigTile extends Tile {
        private final Sprite sprite;

        public GrassBigTile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable) {
            super(mapLocationRect, walkable);
            sprite = spriteSheet.getGrassBigSprite();
        }

        @Override
        public void draw(Canvas canvas) {
            sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        }
    }
