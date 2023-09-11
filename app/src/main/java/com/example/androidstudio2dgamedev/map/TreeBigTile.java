package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.Sprite;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

class TreeBigTile extends Tile {
    private final Sprite grassSprite;
    private final Sprite treeBigSprite;
    private int lvl;

    public TreeBigTile(SpriteSheet spriteSheet, Rect mapLocationRect, boolean walkable, int lvl) {
        super(mapLocationRect, walkable);
        this.lvl = lvl;
        if(lvl == 4){
            grassSprite = spriteSheet.getSandSprite();
        }
        else grassSprite = spriteSheet.getGrassSprite();

        treeBigSprite = spriteSheet.getBigTreeSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        grassSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        treeBigSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
