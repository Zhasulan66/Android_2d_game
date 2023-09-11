package com.example.androidstudio2dgamedev.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.androidstudio2dgamedev.main.GameDisplay;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

import static com.example.androidstudio2dgamedev.map.MapLayout.NUMBER_OF_COLUMN_TILES;
import static com.example.androidstudio2dgamedev.map.MapLayout.NUMBER_OF_ROW_TILES;
import static com.example.androidstudio2dgamedev.map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.androidstudio2dgamedev.map.MapLayout.TILE_WIDTH_PIXELS;

public class Tilemap {

    private final MapLayout mapLayout;
    private Tile[][] tilemap;
    private SpriteSheet spriteSheet;
    private Bitmap mapBitmap;

    public int mapWidth = TILE_WIDTH_PIXELS * 48; //40
    public int mapHeight = TILE_HEIGHT_PIXELS * 34; //40
    int lvl;

    public Tilemap(SpriteSheet spriteSheet, int lvl) {
        this.lvl = lvl;
        mapLayout = new MapLayout(lvl);
        this.spriteSheet = spriteSheet;
        initializeTilemap();
    }


    public Tile[][] getTilemap() {
        return tilemap;
    }

    private void initializeTilemap() {
        int[][] layout = new int[NUMBER_OF_ROW_TILES][NUMBER_OF_COLUMN_TILES];
        switch (lvl){
            case 1: {
                layout = mapLayout.getLayout();
                break;
            }
            case 2: {
                layout = mapLayout.getLayout2();
                break;
            }
            case 3: {
                layout = mapLayout.getLayout3();
                break;
            }
            case 4: {
                layout = mapLayout.getLayout4();
                break;
            }
        }

        tilemap = new Tile[NUMBER_OF_ROW_TILES][NUMBER_OF_COLUMN_TILES];
        for (int iRow = 0; iRow < NUMBER_OF_ROW_TILES; iRow++) {
            for (int iCol = 0; iCol < NUMBER_OF_COLUMN_TILES; iCol++) {
                tilemap[iRow][iCol] = Tile.getTile(
                    layout[iRow][iCol],
                    spriteSheet,
                    getRectByIndex(iRow, iCol),
                    lvl
                );
            }
        }

        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        mapBitmap = Bitmap.createBitmap(
                NUMBER_OF_COLUMN_TILES*TILE_WIDTH_PIXELS,
                NUMBER_OF_ROW_TILES*TILE_HEIGHT_PIXELS,
                config
        );

        Canvas mapCanvas = new Canvas(mapBitmap);

        for (int iRow = 0; iRow < NUMBER_OF_ROW_TILES; iRow++) {
            for (int iCol = 0; iCol < NUMBER_OF_COLUMN_TILES; iCol++) {
                tilemap[iRow][iCol].draw(mapCanvas);
            }
        }

    }

    private Rect getRectByIndex(int idxRow, int idxCol) {
        return new Rect(
                idxCol*TILE_WIDTH_PIXELS,
                idxRow*TILE_HEIGHT_PIXELS,
                (idxCol + 1)*TILE_WIDTH_PIXELS,
                (idxRow + 1)*TILE_HEIGHT_PIXELS
        );
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        canvas.drawBitmap(
            mapBitmap,
                gameDisplay.getGameRect(),
                gameDisplay.DISPLAY_RECT,
                null
        );
    }

    // Returns the left coordinate of the map
    public int getLeft() {
        return 0;
    }

    // Returns the right coordinate of the map
    public int getRight() {
        return mapWidth;
    }

    // Returns the top coordinate of the map
    public int getTop() {
        return 0;
    }

    // Returns the bottom coordinate of the map
    public int getBottom() {
        return mapHeight;
    }

    public boolean isTileWalkable(int tileX, int tileY) {
        return tilemap[tileX][tileY].isWalkable();
    }

    public RectF getTileRect(int tileX, int tileY) {
        // Calculate the top-left corner coordinates of the tile
        float left = tileX * 64;
        float top = tileY * 64;

        // Calculate the bottom-right corner coordinates of the tile
        float right = left + 64;
        float bottom = top + 64;

        // Create and return a RectF object that represents the rectangle of the tile
        return new RectF(left, top, right, bottom);
    }
}
