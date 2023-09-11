package com.example.androidstudio2dgamedev.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.R;

public class SpriteSheet {
    private static final int SPRITE_WIDTH_PIXELS = 64;
    private static final int SPRITE_HEIGHT_PIXELS = 64;
    private Bitmap bitmap;

    private Bitmap[][] sprites = new Bitmap[7][4];

    public SpriteSheet(Context context, int resId) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), resId, bitmapOptions);

        for (int j = 0; j < sprites.length; j++)
            for (int i = 0; i < sprites[j].length; i++)
                sprites[j][i] = getScaledBitmap(Bitmap.createBitmap(bitmap, 16 * i, 16 * j, 16, 16));
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Bitmap getSprite(int yPos, int xPos) {
        return sprites[yPos][xPos];
    }

    public Bitmap getScaledBitmap(Bitmap bitmap){
        return Bitmap.createScaledBitmap(bitmap,bitmap.getWidth() * 6,bitmap.getHeight()*6,false);
    }

    public Sprite[] getPlayerSpriteArray(){
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(0*16, 0, 1*16, 1*16));
        spriteArray[1] = new Sprite(this, new Rect(0*16, 1*16, 1*16, 2*16));
        spriteArray[2] = new Sprite(this, new Rect(0*16, 2*16, 1*16, 3*16));
        return spriteArray;
    }

    public Sprite getWaterSprite() {
        return getTileByIndex(0, 2);
    }

    public Sprite getGrassSprite() {
        return getTileByIndex(1, 0);
    } // 1 1

    public Sprite getGroundSprite() {
        return getTileByIndex(1, 1);} // 1 2

    public Sprite getGrassBigSprite() {
        return getTileByIndex(0, 1);
    }

    public Sprite getTreeSprite() {
        return getTileByIndex(1, 2);
    }

    public Sprite getBigTreeSprite() {
        return getTileByIndex(2, 0);
    }
    public Sprite getBigTree2Sprite() {
        return getTileByIndex(2, 1);
    }
    public Sprite getBigTree3Sprite() {
        return getTileByIndex(3, 0);
    }
    public Sprite getBigTree4Sprite() {
        return getTileByIndex(3, 1);
    }

    public Sprite getSnowSprite() {
        return getTileByIndex(1, 3);
    } // 1 3
    public Sprite getDesertSprite() {
        return getTileByIndex(0, 4);
    } // 0 4
    public Sprite getTreeSnowSprite() {
        return getTileByIndex(2, 2);
    }
    public Sprite getTreeSnow2Sprite() {
        return getTileByIndex(2, 3);
    }
    public Sprite getTreeSnow3Sprite() {
        return getTileByIndex(3, 2);
    }
    public Sprite getTreeSnow4Sprite() {
        return getTileByIndex(3, 3);
    }

    public Sprite getSandSprite() {
        return getTileByIndex(1, 4);
    }

    public Sprite getStone1Sprite() {
        return getTileByIndex(2, 4);
    }
    public Sprite getStone2Sprite() {
        return getTileByIndex(2, 5);
    }
    public Sprite getStone3Sprite() {
        return getTileByIndex(3, 4);
    }
    public Sprite getStone4Sprite() {
        return getTileByIndex(3, 5);
    }



    private Sprite getSpriteByIndex(int idxRow, int idxCol) {
        return new Sprite(this, new Rect(
                idxCol*SPRITE_WIDTH_PIXELS,
                idxRow*SPRITE_HEIGHT_PIXELS,
                (idxCol + 1)*SPRITE_WIDTH_PIXELS,
                (idxRow + 1)*SPRITE_HEIGHT_PIXELS
        ));
    }

    private Sprite getTileByIndex(int idxRow, int idxCol) {
        return new Sprite(this, new Rect(
                idxCol*16,
                idxRow*16,
                (idxCol + 1)*16,
                (idxRow + 1)*16
        ));
    }


}
