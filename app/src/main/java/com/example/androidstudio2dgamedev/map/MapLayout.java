package com.example.androidstudio2dgamedev.map;

public class MapLayout {
    public static final int TILE_WIDTH_PIXELS = 64;  //64
    public static final int TILE_HEIGHT_PIXELS = 64; //64
    public static final int NUMBER_OF_ROW_TILES = 34;
    public static final int NUMBER_OF_COLUMN_TILES = 48;


    private int[][] layout;
    private int[][] layout2;
    private int[][] layout3;
    private int[][] layout4;

    public MapLayout(int lvl) {
        switch (lvl){
            case 1: {
                initializeLayout();
                break;
            }
            case 2: {
                initializeLayout2();
                break;
            }
            case 3: {
                initializeLayout3();
                break;
            }
            case 4: {
                initializeLayout4();
                break;
            }
        }

    }

    public int[][] getLayout() {
        return layout;
    }
    public int[][] getLayout2() {
        return layout2;
    }
    public int[][] getLayout3() {
        return layout3;
    }
    public int[][] getLayout4() {
        return layout4;
    }

    private void initializeLayout() {
        layout = new int[][] {
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,15,16,11,11,11,15,16,11,11,11,11,11,11,11,11,15,16,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,12,12,12,11,11,15,16,11,15,16,17,18,11,11,11,17,18,11,11,11,11,11,11,11,11,17,18,11,15,16,11,11,11,11,11,12,12,12,11,11,11,11,15,16,11,11},
                {11,11,12,12,12,11,11,17,18,11,17,18,11,11,11,11,11,11,12,12,12,12,12,12,12,12,11,11,11,11,17,18,11,11,11,12,12,12,12,12,12,12,11,11,17,18,11,11},
                {11,11,12,12,12,11,15,16,11,15,16,11,11,11,11,15,16,11,12,11,10,10,10,10,11,12,11,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,11,11,11,11,11},
                {11,11,11,12,11,11,17,18,11,17,18,11,11,15,16,17,18,11,12,10,10,10,10,10,10,12,11,15,16,11,11,11,11,12,12,12,12,12,12,12,12,12,12,12,11,11,11,11},
                {11,11,11,12,11,15,16,11,15,16,11,15,16,17,18,15,16,11,12,10,10,10,10,10,10,12,11,17,18,11,11,11,11,12,12,12,12,12,12,12,12,12,12,12,11,11,11,11},
                {11,11,11,12,11,17,18,11,17,18,11,17,18,11,11,17,18,11,12,10,10,10,10,10,10,12,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,12,12,12,12,11,11,11},
                {11,11,11,12,11,11,11,15,16,11,11,15,16,11,11,15,16,11,12,10,10,10,10,10,11,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,11,11,11},
                {11,11,11,12,11,15,16,17,18,11,11,17,18,11,15,16,18,11,12,10,10,10,10,10,10,11,11,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,12,11,11,11,11},
                {11,11,11,12,11,17,18,11,11,15,16,11,11,11,17,18,11,11,12,11,10,10,10,10,10,11,11,15,16,11,11,11,11,11,11,12,12,12,12,12,12,12,12,11,11,11,11,11},
                {11,11,11,12,11,11,15,16,11,17,18,11,15,16,11,15,16,11,12,11,10,10,10,10,11,11,11,17,18,15,16,15,16,11,11,11,11,12,12,12,12,12,11,11,11,11,11,11},
                {15,16,11,12,11,11,17,18,11,11,11,11,17,18,15,16,18,11,12,11,10,10,10,11,11,15,16,11,11,17,18,17,15,16,11,11,11,11,11,12,12,11,11,11,11,11,11,11},
                {17,18,11,12,11,15,16,15,16,15,16,15,16,11,17,18,11,11,12,11,10,10,10,11,11,17,18,11,15,16,11,11,17,18,11,15,16,11,11,12,12,11,15,16,11,11,11,11},
                {11,11,11,12,11,17,18,17,18,17,18,17,18,11,11,11,11,11,12,11,10,10,10,11,15,16,11,11,17,18,11,11,11,11,11,17,18,11,11,12,12,11,17,18,11,11,11,11},
                {11,11,11,12,11,11,11,11,11,11,11,11,11,11,11,11,11,11,12,11,10,10,10,11,17,18,11,11,11,11,11,11,15,16,11,15,16,11,11,12,12,11,11,11,11,11,11,11},
                {11,11,11,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,10,10,11,11,11,11,11,15,16,11,11,17,18,11,17,18,11,11,12,12,11,11,11,11,11,11,11},
                {11,11,11,12,11,11,11,11,11,11,11,11,11,11,12,12,12,12,12,12,10,10,10,11,11,15,16,11,17,18,11,11,11,11,11,11,11,11,11,12,12,11,11,11,11,11,11,11},
                {11,11,11,12,11,15,16,11,11,11,11,15,16,11,11,11,11,11,11,11,10,10,10,10,11,17,18,11,11,11,11,11,11,11,11,11,11,11,11,12,12,11,11,11,11,11,11,11},
                {11,11,11,12,11,17,18,11,11,11,11,17,18,11,11,11,11,11,11,11,10,10,10,10,10,10,10,10,10,11,11,11,11,11,11,15,16,11,11,12,12,11,11,11,11,15,16,11},
                {11,11,11,12,11,11,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,17,18,11,11,12,12,11,11,11,11,17,18,11},
                {11,11,11,12,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,12,12,11,11,11,11,11,11,11},
                {11,11,11,12,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,12,12,11,11,11,11,11,11,11},
                {11,11,11,12,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,15,16,10,10,10,10,10,10,10,10,11,11,11,11,12,12,12,11,11,11,11,11,11},
                {15,16,11,12,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,15,16,11,17,18,11,10,10,10,10,10,10,10,11,11,11,11,12,12,12,11,11,11,15,16,11},
                {17,18,11,12,11,11,10,10,10,10,10,10,10,10,11,10,10,10,10,10,10,10,17,18,13,11,13,13,10,10,10,10,10,10,11,11,11,11,11,11,12,12,11,11,11,17,18,11},
                {11,11,11,12,11,11,10,10,10,10,10,11,11,11,11,10,10,10,10,10,10,10,11,15,16,11,11,10,10,10,10,10,10,11,11,11,11,11,11,12,12,12,12,12,11,11,11,11},
                {11,11,11,12,11,11,11,11,11,11,11,11,11,11,11,11,10,10,10,10,10,10,10,17,18,13,10,10,10,10,10,10,10,11,11,11,11,11,12,12,12,12,12,12,12,11,11,11},
                {11,11,11,12,11,15,16,11,12,12,12,12,12,12,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11,11,12,12,12,12,12,12,12,12,12,11,11},
                {11,11,11,12,11,17,18,11,12,12,12,12,12,12,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,15,16,11,12,12,12,12,12,12,12,12,12,11,11},
                {11,11,11,12,11,11,11,11,12,12,12,12,12,12,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11,17,18,11,11,12,12,12,12,12,12,12,11,11,11},
                {11,11,11,12,12,12,12,12,12,12,12,12,12,12,11,15,16,11,10,10,10,10,10,10,10,10,10,10,10,15,16,11,11,11,11,11,11,11,11,12,12,12,12,12,11,11,11,11},
                {11,15,16,11,11,11,11,11,12,12,12,12,12,12,11,17,18,11,11,11,11,11,11,10,10,10,10,11,11,17,18,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,17,18,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11}

        };
    }

    private void initializeLayout2() {
        layout2 = new int[][] {
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,10,10,10,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,10,10,11,11,11,11,11,10,10,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,10,10,11,11,14,11,11,11,11,11,11,11,11,10,10,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,14,11,11,11,11,14,11,11,11,14,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,11,11,12,12,12,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,14,11,11,11,11,12,12,11,12,11,12,12,11,11,11,14,11,11,14,10,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,12,12,11,11,11,12,11,11,11,12,12,11,11,11,11,11,14,10,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,10,11,14,11,11,11,12,11,11,11,11,12,12,12,11,11,11,11,12,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,12,11,11,11,12,12,12,12,12,12,12,11,11,11,12,11,11,14,11,10,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,12,11,11,12,12,12,12,12,12,12,12,12,11,11,12,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,12,11,11,12,12,12,12,12,12,12,12,12,12,12,11,11,12,11,11,14,11,10,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,12,11,11,12,12,12,12,12,12,12,12,12,12,12,11,11,12,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,10,14,11,11,11,12,11,11,12,12,12,12,12,12,12,12,12,12,12,12,12,11,11,12,11,11,11,11,10,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,14,11,11,11,10,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,12,11,11,12,12,12,12,12,12,12,12,12,12,12,12,12,11,11,12,11,11,11,11,10,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,10,14,11,11,11,12,11,11,12,12,12,12,12,12,12,12,12,12,12,11,11,12,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,12,11,11,12,12,12,12,12,12,12,12,12,12,12,11,11,12,11,11,14,11,10,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,12,11,11,12,12,12,12,12,12,12,12,12,11,11,12,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,12,11,11,11,12,12,12,12,12,12,12,11,11,11,12,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,10,11,14,11,11,11,12,11,11,11,11,12,12,12,11,11,11,11,12,11,11,14,11,11,10,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,12,12,11,11,11,12,11,11,11,12,12,11,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,11,12,12,11,12,11,12,12,11,11,11,14,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,11,11,12,12,12,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,14,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,10,10,11,11,11,11,11,11,11,11,14,11,11,10,10,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,10,10,11,11,11,11,11,10,10,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,10,10,10,10,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11}
        };
    }

    private void initializeLayout3() {
        layout3 = new int[][] {
                {19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19},
                {19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19},
                {19,19,19,19,19,21,22,19,19,19,19,19,19,19,21,22,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,21,22,19},
                {19,19,19,19,19,23,24,19,19,19,21,22,19,19,23,24,21,22,19,19,19,19,19,19,19,21,22,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,23,24,19},
                {19,19,21,22,19,19,19,19,19,19,23,24,19,19,19,19,23,24,19,19,19,19,19,19,19,23,24,19,19,19,21,22,19,19,19,21,22,19,19,19,19,19,19,19,19,19,19,19},
                {19,19,23,24,19,19,19,21,22,19,19,19,19,19,19,19,19,19,19,19,19,21,22,19,19,19,19,19,19,19,23,24,19,19,19,23,24,19,19,19,19,19,19,19,19,21,22,19},
                {21,22,19,19,19,19,19,23,24,19,19,19,19,19,19,19,19,19,19,19,19,23,24,19,19,19,19,19,19,19,19,19,19,19,19,19,19,12,12,12,12,12,19,19,19,23,24,19},
                {23,24,19,19,19,19,19,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,19,19,19,19,19,19},
                {19,19,19,19,19,19,19,12,12,19,21,22,19,19,19,19,19,19,19,19,21,22,19,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,19,19,19,19,19,19},
                {19,19,19,19,19,19,19,12,12,19,23,24,19,19,19,10,10,10,19,19,23,24,19,12,21,22,19,19,19,19,19,21,22,19,19,19,19,12,12,12,12,12,19,19,19,19,19,19},
                {19,19,21,22,19,19,12,12,12,12,19,19,19,19,10,10,10,10,10,10,10,19,19,12,23,24,19,19,19,21,22,23,24,19,19,19,21,22,19,19,19,19,19,19,21,22,19,19},
                {19,19,23,24,19,19,12,12,12,12,19,19,19,10,10,10,10,10,10,10,10,19,19,12,19,19,21,22,19,23,24,19,19,19,19,19,23,24,19,19,19,19,19,19,23,24,19,19},
                {19,19,19,19,19,19,12,12,12,12,19,19,19,10,10,10,10,10,10,10,10,19,19,12,19,19,23,24,19,19,19,19,21,22,19,19,21,22,19,19,19,21,22,19,19,19,19,19},
                {19,19,19,19,19,19,19,19,19,19,19,19,10,10,10,10,10,10,10,10,10,19,19,12,21,22,19,19,19,19,19,19,23,24,19,19,23,24,19,19,19,23,24,19,19,19,19,19},
                {19,19,19,19,19,19,19,19,19,19,19,10,10,10,10,10,10,10,10,10,10,21,22,12,23,24,19,19,19,19,19,19,21,22,19,19,21,22,19,19,19,19,19,21,22,19,19,19},
                {19,19,19,19,19,19,19,19,19,19,10,10,10,10,10,10,10,10,10,10,10,23,24,12,19,19,19,19,19,21,22,19,23,24,19,19,23,24,19,19,19,19,19,23,24,19,19,19},
                {19,21,22,19,19,19,19,19,19,19,10,10,10,10,10,10,10,10,10,10,10,19,19,12,19,21,22,19,19,23,24,19,19,19,21,22,19,19,19,19,19,19,19,19,19,19,19,19},
                {19,23,24,19,19,19,19,19,19,10,10,10,10,10,10,10,10,10,10,10,10,19,12,12,12,23,24,19,19,19,19,19,19,19,23,24,19,19,21,22,19,19,19,19,19,19,19,19},
                {19,19,19,21,22,19,19,19,10,10,10,10,10,10,10,10,10,10,10,10,10,19,12,12,12,12,12,12,12,12,12,12,12,12,12,19,19,19,23,24,19,19,19,19,19,19,19,19},
                {19,19,19,23,24,19,19,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,12,12,12,12,12,12,12,12,12,12,12,12,12,19,19,19,19,19,19,19,21,22,19,19,19,19},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,12,12,12,19,19,21,22,21,22,19,19,12,12,19,19,19,19,19,19,19,23,24,19,19,19,19},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,19,12,19,21,22,23,24,23,24,21,22,12,12,19,19,19,19,19,19,19,19,19,19,19,19,19},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,19,19,12,19,23,24,19,19,19,19,23,24,12,12,19,19,19,19,19,19,19,19,19,19,19,19,19},
                {19,21,22,19,19,19,19,10,10,10,10,10,10,10,10,10,10,10,10,10,10,19,19,12,21,22,19,19,19,19,19,21,22,12,12,19,19,19,19,19,19,19,21,22,19,19,19,19},
                {19,23,24,19,21,22,19,19,19,10,10,10,10,10,10,10,10,10,10,10,10,19,19,12,23,24,19,19,19,19,19,23,24,12,12,19,19,19,19,19,19,19,23,24,19,19,19,19},
                {19,19,19,19,23,24,12,12,12,19,10,10,10,10,10,10,10,10,10,10,19,21,22,12,19,21,22,19,19,19,21,22,19,12,12,12,12,12,19,19,19,19,19,19,19,19,19,19},
                {19,21,22,19,19,12,12,12,12,12,19,19,19,19,19,10,10,10,19,19,19,23,24,12,19,23,24,21,22,19,23,24,19,12,12,12,12,12,12,19,21,22,19,19,19,19,19,19},
                {19,23,24,19,19,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,19,21,22,23,24,19,19,19,19,12,12,12,12,12,12,19,23,24,19,19,19,19,19,19},
                {19,19,19,19,19,12,12,12,12,12,19,21,22,19,19,19,19,19,19,19,19,19,19,19,19,23,24,19,19,21,22,19,19,19,12,12,12,12,19,19,19,19,19,19,19,19,19,19},
                {19,21,22,19,19,19,12,12,12,19,19,23,24,19,19,19,21,22,19,19,19,19,19,19,19,21,22,19,19,23,24,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,21,22},
                {19,23,24,19,19,19,21,22,19,19,19,19,19,19,19,19,23,24,19,19,19,19,19,19,19,23,24,19,19,19,19,19,19,19,19,19,21,22,19,19,19,19,19,19,19,19,23,24},
                {19,19,19,19,19,19,23,24,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,23,24,19,19,19,19,19,19,21,22,19,19},
                {19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,23,24,19,19},
                {19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19}

        };
    }

    private void initializeLayout4() {
        layout4 = new int[][] {
                {25,26,27,25,25,25,25,25,26,27,25,25,25,25,25,26,27,25,25,25,25,25,15,16,25,25,25,26,27,25,25,25,25,25,26,27,26,27,26,27,26,27,25,25,25,25,26,27},
                {25,28,29,20,20,20,26,27,28,29,25,25,26,27,25,28,29,25,26,27,25,25,17,18,26,27,25,28,29,25,26,27,25,25,28,29,28,29,28,29,28,29,26,27,25,25,28,29},
                {25,25,25,20,20,20,28,29,25,26,27,25,28,29,25,25,25,25,28,29,25,25,25,25,28,29,25,25,25,25,28,29,25,25,25,20,20,20,20,20,20,20,28,29,25,25,25,25},
                {25,25,26,27,20,25,25,25,25,28,29,25,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,26,27,25,25,25},
                {25,25,28,29,20,25,25,25,25,25,25,25,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,25,28,29,25,25,25},
                {25,25,26,27,20,25,25,25,25,25,25,25,20,20,20,20,26,27,25,26,27,25,26,27,25,26,27,25,26,27,25,26,27,25,26,27,25,26,27,26,27,26,27,25,25,25,25,25},
                {25,25,28,29,20,20,25,25,25,25,25,25,20,20,20,20,28,29,25,28,29,25,28,29,25,28,29,25,28,29,25,28,29,25,28,29,25,28,29,28,29,28,29,25,25,25,25,25},
                {25,25,25,25,20,20,20,20,25,25,25,25,20,20,20,20,25,25,25,25,25,25,25,26,27,15,16,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25},
                {25,25,26,27,25,25,25,20,25,25,25,25,20,20,20,26,27,25,25,25,25,25,25,28,29,17,18,25,25,25,26,27,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25},
                {25,25,28,29,25,25,25,20,25,25,25,25,20,20,20,28,29,25,25,26,27,25,26,27,25,25,25,25,25,25,28,29,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25},
                {25,25,25,25,25,25,25,20,20,20,20,20,20,20,20,25,25,25,25,28,29,25,28,29,20,20,20,20,20,20,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25},
                {25,15,16,25,25,25,25,26,27,25,26,27,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,25,26,27,25,25,25,25,25,25,25,25,25,25,25,25,15,16,25},
                {25,17,18,25,25,25,25,28,29,25,28,29,25,25,26,27,25,25,26,27,25,25,25,26,27,25,25,25,20,20,20,28,29,25,25,25,25,25,25,25,25,25,25,25,25,17,18,25},
                {25,25,25,25,25,25,25,25,25,25,25,25,25,25,28,29,25,25,28,29,25,25,25,28,29,25,25,26,27,20,20,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25},
                {25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,28,29,20,20,25,25,25,25,25,25,25,25,25,25,25,10,10,10,10,10,25},
                {25,25,25,15,16,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,20,20,25,25,25,25,25,25,25,25,25,25,10,10,10,10,10,10,25},
                {25,25,25,17,18,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,26,27,20,20,25,25,25,25,25,25,25,25,25,25,10,10,10,10,10,10,25},
                {25,25,25,25,25,25,20,20,20,20,20,20,20,20,20,20,20,20,25,25,25,25,25,25,25,25,25,28,29,20,20,25,25,25,25,25,25,25,25,25,25,10,10,10,10,10,10,25},
                {26,27,25,25,25,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,25,25,25,25,25,25,20,20,25,25,25,25,25,25,25,25,25,25,10,10,10,10,10,10,25},
                {28,29,25,25,25,20,20,25,25,25,25,25,26,27,25,26,27,20,20,20,20,20,20,20,20,20,20,20,20,20,20,25,25,25,25,25,25,25,25,25,25,10,10,10,10,10,10,25},
                {25,25,25,25,25,20,20,25,26,27,26,27,28,29,25,28,29,25,20,20,20,20,20,20,20,20,20,20,20,20,20,20,25,25,25,25,25,25,25,25,25,10,10,10,10,10,10,25},
                {25,26,27,25,25,20,20,25,28,29,28,29,25,25,25,25,25,10,10,10,10,10,25,15,16,25,25,25,25,20,20,20,25,25,25,25,25,25,25,25,25,10,10,10,10,10,10,25},
                {25,28,29,25,25,20,20,20,20,20,20,20,25,26,27,25,15,16,10,10,10,25,25,17,18,25,25,25,25,20,20,20,25,25,25,25,25,25,15,16,25,10,10,10,10,10,10,25},
                {25,25,25,25,25,20,25,25,25,25,25,20,20,28,29,25,17,18,25,10,26,27,25,26,27,25,25,25,20,20,20,20,20,25,25,25,25,25,17,18,25,10,10,10,10,10,10,25},
                {25,26,27,25,25,20,25,26,27,25,25,25,20,20,25,25,25,25,26,27,28,29,25,28,29,26,27,25,20,20,20,20,20,25,25,25,25,25,25,25,25,15,16,10,10,10,10,25},
                {25,28,29,20,20,20,25,28,29,25,25,26,27,20,20,25,26,27,28,29,25,20,20,20,20,28,29,25,25,20,20,20,20,25,25,25,25,25,25,25,25,17,18,10,10,10,25,25},
                {26,27,20,20,20,25,26,27,25,25,25,28,29,25,20,20,28,29,25,25,20,20,20,20,20,20,25,25,26,27,20,20,20,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25},
                {28,29,20,20,25,25,28,29,25,25,25,25,25,25,25,20,20,25,25,20,20,20,20,20,20,20,20,25,28,29,25,20,20,25,25,25,25,25,25,25,25,25,25,25,26,27,25,25},
                {25,20,20,20,20,26,27,25,25,25,25,25,25,25,25,25,20,20,20,20,20,20,20,20,20,20,20,25,25,25,25,25,20,25,25,25,25,25,25,25,25,25,25,25,28,29,26,27},
                {25,20,20,20,20,28,29,25,25,25,25,25,25,25,25,25,25,15,16,25,20,20,20,20,20,20,26,27,25,25,25,25,20,25,25,25,25,20,20,20,20,20,25,25,25,25,28,29},
                {25,20,20,20,20,26,27,25,25,25,25,25,25,25,25,25,25,17,18,25,25,20,20,20,20,20,28,29,25,25,25,25,20,20,25,25,25,20,20,20,20,20,20,25,25,25,25,25},
                {25,20,20,20,20,28,29,25,25,25,25,15,16,25,25,25,25,25,25,25,25,25,20,20,20,25,26,27,25,25,25,25,25,20,20,20,20,20,20,20,20,20,20,25,25,25,25,25},
                {26,27,25,25,26,27,25,25,25,25,25,17,18,25,25,25,25,25,25,25,25,25,25,25,25,25,28,29,25,25,26,27,25,25,25,25,25,20,20,20,20,20,15,16,25,25,25,25},
                {28,29,25,25,28,29,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,28,29,25,25,25,25,25,25,25,25,25,25,17,18,25,25,25,25}

        };
    }
}
