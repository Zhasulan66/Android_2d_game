package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

class TreeBig2Tile extends Tile {
    private final Sprite grassSprite;
    private final Sprite treeBig2Sprite;
    private int lvl;

    public TreeBig2Tile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable, int lvl) {
        super(mapLocationRect, walkable);
        this.lvl = lvl;
        if(lvl == 4){
            grassSprite = spriteSheet.getSandSprite();
        }else grassSprite = spriteSheet.getGrassSprite();
        treeBig2Sprite = spriteSheet.getBigTree2Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        grassSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        treeBig2Sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
