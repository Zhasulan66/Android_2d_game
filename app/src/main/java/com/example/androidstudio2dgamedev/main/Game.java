package com.example.androidstudio2dgamedev.main;


import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.example.androidstudio2dgamedev.gamestates.DialogScreen;
import com.example.androidstudio2dgamedev.gamestates.LevelScreen;
import com.example.androidstudio2dgamedev.gamestates.Playing;
import com.example.androidstudio2dgamedev.gamestates.Playing_lvl2;
import com.example.androidstudio2dgamedev.gamestates.Playing_lvl3;
import com.example.androidstudio2dgamedev.gamestates.Playing_lvl4;


public class Game {

    private SurfaceHolder holder;
    private LevelScreen levelScreen;
    private DialogScreen dialogScreen;
    private GameLoop gameLoop;

    private Context context;

    private int question_num;

    private Playing playing;
    private Playing_lvl2 playing_lvl2;
    private Playing_lvl3 playing_lvl3;
    private Playing_lvl4 playing_lvl4;


    private GameState currentGameState = GameState.LEVEL_SCREEN;

    private int currentLevel = 0;
    private int dialogNum = 0;

    public Game(SurfaceHolder holder, Context context) {
        this.holder = holder;
        this.context = context;
        gameLoop = new GameLoop(this, holder);
        initGameStates();
    }

    public void update() {

        switch (currentGameState) {
            case PLAYING: {playing.update();
            break;}
            case PLAYING2: {playing_lvl2.update();
                break;}
            case PLAYING3: {playing_lvl3.update();
                break;}
            case PLAYING4: {playing_lvl4.update();
                break;}
            case LEVEL_SCREEN: {levelScreen.update();
            break;}
            case DIALOG: {
                initQuestionNum();
                dialogScreen.update();
                break;}
        }


    }

    public void render() {
        Canvas c = holder.lockCanvas();
        c.drawColor(Color.BLACK);

        //Draw the game
        switch (currentGameState) {
            case PLAYING: {
                playing.render(c);
                break;
            }
            case PLAYING2: {
                playing_lvl2.render(c);
                break;
            }
            case PLAYING3: {
                playing_lvl3.render(c);
                break;
            }
            case PLAYING4: {
                playing_lvl4.render(c);
                break;
            }
            case LEVEL_SCREEN: {
                levelScreen.render(c);
            break;
            }
            case DIALOG: {
                switch (currentLevel){
                    case 1: {
                        playing.render(c);
                        break;
                    }
                    case 2: {
                        playing_lvl2.render(c);
                        break;
                    }
                    case 3: {
                        playing_lvl3.render(c);
                        break;
                    }
                    case 4: {
                        playing_lvl4.render(c);
                        break;
                    }
                }
                dialogScreen.render(c);
                break;
            }
        }

        holder.unlockCanvasAndPost(c);
    }

    private void initGameStates() {
        levelScreen = new LevelScreen(this);
        dialogScreen = new DialogScreen(this);
        playing = new Playing(this);
        playing_lvl2 = new Playing_lvl2(this);
        playing_lvl3 = new Playing_lvl3(this);
        playing_lvl4 = new Playing_lvl4(this);
    }

    public boolean touchEvent(MotionEvent event) {
        switch (currentGameState) {
            case PLAYING: {
                playing.touchEvents(event);
                break;}
            case PLAYING2: {
                playing_lvl2.touchEvents(event);
                break;}
            case PLAYING3: {
                playing_lvl3.touchEvents(event);
                break;}
            case PLAYING4: {
                playing_lvl4.touchEvents(event);
                break;}
            case LEVEL_SCREEN: {
                levelScreen.touchEvents(event);
                break;}
            case DIALOG: {
                dialogScreen.touchEvents(event);
                break;
            }
        }

        return true;
    }

    public void startGameLoop() {
        gameLoop.startGameLoop();
    }

    public enum GameState {
        LEVEL_SCREEN, DIALOG, PLAYING, PLAYING2, PLAYING3, PLAYING4;
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public int getDialogNum() {
        return dialogNum;
    }

    public void setDialogNum(int dialogNum) {
        this.dialogNum = dialogNum;
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public Context getContext() {
        return context;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getQuestion_num() {
        return question_num;
    }

    public void setQuestion_num(int question_num) {
        this.question_num = question_num;
    }

    public void initQuestionNum() {
        switch (currentLevel) {
            case 1: {
                if(dialogNum == 0) {
                    dialogScreen.setQuestion_num(0);
                }
                if(dialogNum == 1) {
                    dialogScreen.setQuestion_num(1);
                }
                break;
                }
            case 2: {
                if(dialogNum == 0) {
                    dialogScreen.setQuestion_num(2);
                }
                if(dialogNum == 1) {
                    dialogScreen.setQuestion_num(3);
                }
                break;
                }
            case 3: {
                if(dialogNum == 0) {
                    dialogScreen.setQuestion_num(4);
                }
                if(dialogNum == 1) {
                    dialogScreen.setQuestion_num(5);
                }
                break;
            }
            case 4: {
                if(dialogNum == 0) {
                    dialogScreen.setQuestion_num(6);
                }
                if(dialogNum == 1) {
                    dialogScreen.setQuestion_num(7);
                }
                break;
            }
            default: {
                dialogScreen.setQuestion_num(0);
                break;
            }
        }
    }
}

