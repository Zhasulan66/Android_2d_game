package com.example.androidstudio2dgamedev.gameobject;

import static com.example.androidstudio2dgamedev.map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.androidstudio2dgamedev.map.MapLayout.TILE_WIDTH_PIXELS;

import com.example.androidstudio2dgamedev.gamestates.BaseState;
import com.example.androidstudio2dgamedev.gamestates.Playing;
import com.example.androidstudio2dgamedev.gamestates.Playing_lvl2;
import com.example.androidstudio2dgamedev.gamestates.Playing_lvl3;
import com.example.androidstudio2dgamedev.gamestates.Playing_lvl4;
import com.example.androidstudio2dgamedev.main.Game;

public class AssetSetter {
    Playing playing;

    Playing_lvl3 playing_lvl3;

    Playing_lvl4 playing_lvl4;

    public AssetSetter(Playing playing){
        this.playing = playing;
    }

    public AssetSetter(Playing_lvl3 playing_lvl3){
        this.playing_lvl3 = playing_lvl3;
    }
    public AssetSetter(Playing_lvl4 playing_lvl4){
        this.playing_lvl4 = playing_lvl4;
    }

    public void setObject(){

        playing.obj[0] = new OBJ_Key(playing.getGame().getContext());
        playing.obj[0].worldX = 3 * TILE_WIDTH_PIXELS;
        playing.obj[0].worldY = 3 * TILE_HEIGHT_PIXELS;

        playing.obj[1] = new OBJ_Key(playing.getGame().getContext());
        playing.obj[1].worldX = 12 * TILE_WIDTH_PIXELS;
        playing.obj[1].worldY = 30 * TILE_HEIGHT_PIXELS;

        playing.obj[2] = new OBJ_Key(playing.getGame().getContext());
        playing.obj[2].worldX = 41 * TILE_WIDTH_PIXELS;
        playing.obj[2].worldY = 8 * TILE_HEIGHT_PIXELS;

        playing.obj[3] = new OBJ_Door(playing.getGame().getContext());
        playing.obj[3].worldX = 43 * TILE_WIDTH_PIXELS;
        playing.obj[3].worldY = 30 * TILE_HEIGHT_PIXELS;

    }

    public void setObject_lvl3(){

        playing_lvl3.obj[0] = new OBJ_Key(playing_lvl3.getGame().getContext());
        playing_lvl3.obj[0].worldX = 7 * TILE_WIDTH_PIXELS;
        playing_lvl3.obj[0].worldY = 11 * TILE_HEIGHT_PIXELS;

        playing_lvl3.obj[1] = new OBJ_Key(playing_lvl3.getGame().getContext());
        playing_lvl3.obj[1].worldX = 41 * TILE_WIDTH_PIXELS;
        playing_lvl3.obj[1].worldY = 8 * TILE_HEIGHT_PIXELS;

        playing_lvl3.obj[2] = new OBJ_Key(playing_lvl3.getGame().getContext());
        playing_lvl3.obj[2].worldX = 37 * TILE_WIDTH_PIXELS;
        playing_lvl3.obj[2].worldY = 27 * TILE_HEIGHT_PIXELS;

        playing_lvl3.obj[3] = new OBJ_Door(playing_lvl3.getGame().getContext());
        playing_lvl3.obj[3].worldX = 7 * TILE_WIDTH_PIXELS;
        playing_lvl3.obj[3].worldY = 27 * TILE_HEIGHT_PIXELS;

    }

    public void setObject_lvl4(){

        playing_lvl4.obj[0] = new OBJ_Key(playing_lvl4.getGame().getContext());
        playing_lvl4.obj[0].worldX = 4 * TILE_WIDTH_PIXELS;
        playing_lvl4.obj[0].worldY = 2 * TILE_HEIGHT_PIXELS;

        playing_lvl4.obj[1] = new OBJ_Key(playing_lvl4.getGame().getContext());
        playing_lvl4.obj[1].worldX = 41 * TILE_WIDTH_PIXELS;
        playing_lvl4.obj[1].worldY = 31 * TILE_HEIGHT_PIXELS;

        playing_lvl4.obj[2] = new OBJ_Key(playing_lvl4.getGame().getContext());
        playing_lvl4.obj[2].worldX = 23 * TILE_WIDTH_PIXELS;
        playing_lvl4.obj[2].worldY = 28 * TILE_HEIGHT_PIXELS;

        playing_lvl4.obj[3] = new OBJ_Door(playing_lvl4.getGame().getContext());
        playing_lvl4.obj[3].worldX = 3 * TILE_WIDTH_PIXELS;
        playing_lvl4.obj[3].worldY = 30 * TILE_HEIGHT_PIXELS;

    }
}
