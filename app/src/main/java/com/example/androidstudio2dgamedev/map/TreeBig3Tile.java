package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

class TreeBig3Tile extends Tile {
    private final Sprite grassSprite;
    private final Sprite treeBig3Sprite;
    private int lvl;

    public TreeBig3Tile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable, int lvl) {
        super(mapLocationRect, walkable);
        this.lvl = lvl;
        if(lvl == 4){
            grassSprite = spriteSheet.getSandSprite();
        }else grassSprite = spriteSheet.getGrassSprite();
        treeBig3Sprite = spriteSheet.getBigTree3Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        grassSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        treeBig3Sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
