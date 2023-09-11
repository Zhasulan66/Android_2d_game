package com.example.androidstudio2dgamedev.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.graphics.SpriteSheet;

public abstract class Tile {

    protected final Rect mapLocationRect;
    private boolean walkable;

    public Tile(Rect mapLocationRect, boolean walkable) {
        this.mapLocationRect = mapLocationRect;
        this.walkable = walkable;
    }

    public enum TileType {
        WATER_TILE,
        GRASS_TILE,
        GROUND_TILE,
        GRASS_BIG_TILE,
        TREE_TILE,
        TREE_BIG_TILE, TREE_BIG2_TILE, TREE_BIG3_TILE, TREE_BIG4_TILE,
        SNOW_TILE,
        DESERT_TILE,
        TREE_SNOW1_TILE, TREE_SNOW2_TILE, TREE_SNOW3_TILE, TREE_SNOW4_TILE,
        SAND_TILE,
        STONE1_TILE, STONE2_TILE, STONE3_TILE, STONE4_TILE
    }

    public static Tile getTile(int idxTileType, SpriteSheet spriteSheet, Rect mapLocationRect, int lvl) {

        switch(TileType.values()[idxTileType-10]) {

            case WATER_TILE:
                return new WaterTile(spriteSheet, mapLocationRect, false); //10
            case GRASS_TILE:
                return new GrassTile(spriteSheet, mapLocationRect, true); //11
            case GROUND_TILE:
                return new GroundTile(spriteSheet, mapLocationRect, true); //12
            case GRASS_BIG_TILE:
                return new GrassBigTile(spriteSheet, mapLocationRect, true); //13
            case TREE_TILE:
                return new TreeTile(spriteSheet, mapLocationRect, false); //14
            case TREE_BIG_TILE:
                return new TreeBigTile(spriteSheet, mapLocationRect, false, lvl); //15
            case TREE_BIG2_TILE:
                return new TreeBig2Tile(spriteSheet, mapLocationRect, false, lvl); //16
            case TREE_BIG3_TILE:
                return new TreeBig3Tile(spriteSheet, mapLocationRect, false, lvl); //17
            case TREE_BIG4_TILE:
                return new TreeBig4Tile(spriteSheet, mapLocationRect, false, lvl); //18
            case SNOW_TILE:
                return new SnowTile(spriteSheet, mapLocationRect, true); //19
            case DESERT_TILE:
                return new DesertTile(spriteSheet, mapLocationRect, true); //20
            case TREE_SNOW1_TILE:
                return new TreeSnowTile(spriteSheet, mapLocationRect, false); //21
            case TREE_SNOW2_TILE:
                return new TreeSnow2Tile(spriteSheet, mapLocationRect, false); //22
            case TREE_SNOW3_TILE:
                return new TreeSnow3Tile(spriteSheet, mapLocationRect, false); //23
            case TREE_SNOW4_TILE:
                return new TreeSnow4Tile(spriteSheet, mapLocationRect, false); //24
            case SAND_TILE:
                return new SandTile(spriteSheet, mapLocationRect, true); //25
            case STONE1_TILE:
                return new Stone1Tile(spriteSheet, mapLocationRect, false); //26
            case STONE2_TILE:
                return new Stone2Tile(spriteSheet, mapLocationRect, false); //27
            case STONE3_TILE:
                return new Stone3Tile(spriteSheet, mapLocationRect, false); //28
            case STONE4_TILE:
                return new Stone4Tile(spriteSheet, mapLocationRect, false); //29
            default:
                return null;
        }

    }

    public abstract void draw(Canvas canvas);

    public boolean isWalkable() {
        return walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public Rect getBoundingBox() {
        return new Rect(mapLocationRect.left, mapLocationRect.top, mapLocationRect.right, mapLocationRect.bottom);
    }
}
