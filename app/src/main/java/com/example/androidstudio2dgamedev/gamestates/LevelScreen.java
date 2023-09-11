package com.example.androidstudio2dgamedev.gamestates;

import static com.example.androidstudio2dgamedev.ui.BitmapMethods.options;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.example.androidstudio2dgamedev.R;
import com.example.androidstudio2dgamedev.main.Game;
import com.example.androidstudio2dgamedev.main.MainActivity;
import com.example.androidstudio2dgamedev.ui.ButtonImages;
import com.example.androidstudio2dgamedev.ui.CustomButton;
import com.example.androidstudio2dgamedev.ui.GameImages;

public class LevelScreen extends BaseState implements GameStateInterface {

    private Paint paint;

    private CustomButton btnStart;
    private CustomButton btnStart2;
    private CustomButton btnStart3;
    private CustomButton btnStart4;
    private CustomButton btnStart5;

    private Bitmap back_btn = BitmapFactory.decodeResource(MainActivity.getGameContext().getResources(), R.drawable.vlevoremovebg, options);

    public LevelScreen(Game game) {
        super(game);
        paint = new Paint();
        paint.setTextSize(60);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);

        btnStart = new CustomButton(300, 600, ButtonImages.LEVEL_START.getWidth(), ButtonImages.LEVEL_START.getHeight());
        btnStart2 = new CustomButton(300, 800, ButtonImages.LEVEL_START2.getWidth(), ButtonImages.MENU_START.getHeight());
        btnStart3 = new CustomButton(300, 1000, ButtonImages.LEVEL_START3.getWidth(), ButtonImages.MENU_START.getHeight());
        btnStart4 = new CustomButton(300, 1200, ButtonImages.LEVEL_START4.getWidth(), ButtonImages.MENU_START.getHeight());
        btnStart5 = new CustomButton(300, 1400, ButtonImages.LEVEL_START5.getWidth(), ButtonImages.MENU_START.getHeight());
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas c) {

        c.drawBitmap(
                Bitmap.createScaledBitmap(GameImages.MAINMENU_MENUBG.getImage(),
                        GameImages.MAINMENU_MENUBG.getImage().getWidth() * 3,
                        (int) (GameImages.MAINMENU_MENUBG.getImage().getHeight()*2.5),false),
                0, 0, null);

        c.drawText("Choose Level", 300, 500, paint);

        c.drawBitmap(
                ButtonImages.LEVEL_START.getBtnImg(btnStart.isPushed()),
                btnStart.getHitbox().left,
                btnStart.getHitbox().top,
                null);

        c.drawBitmap(
                ButtonImages.LEVEL_START2.getBtnImg(btnStart2.isPushed()),
                btnStart2.getHitbox().left,
                btnStart2.getHitbox().top,
                null);

        c.drawBitmap(
                ButtonImages.LEVEL_START3.getBtnImg(btnStart3.isPushed()),
                btnStart3.getHitbox().left,
                btnStart3.getHitbox().top,
                null);

        c.drawBitmap(
                ButtonImages.LEVEL_START4.getBtnImg(btnStart4.isPushed()),
                btnStart4.getHitbox().left,
                btnStart4.getHitbox().top,
                null);

        c.drawBitmap(
                ButtonImages.LEVEL_START5.getBtnImg(btnStart5.isPushed()),
                btnStart5.getHitbox().left,
                btnStart5.getHitbox().top,
                null);

        c.drawBitmap(
                Bitmap.createScaledBitmap(back_btn,
                        back_btn.getWidth()/3,
                        back_btn.getHeight()/3,false),
                200, 1500, null);
    }

    @Override
    public boolean touchEvents(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (isIn(event, btnStart))
                btnStart.setPushed(true);
            if (isIn(event, btnStart2))
                btnStart2.setPushed(true);
            if (isIn(event, btnStart3))
                btnStart3.setPushed(true);
            if (isIn(event, btnStart4))
                btnStart4.setPushed(true);
            if (isIn(event, btnStart5))
                btnStart5.setPushed(true);

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (isIn(event, btnStart)) {
                if (btnStart.isPushed()) {
                    game.setCurrentGameState(Game.GameState.PLAYING);
                    game.setCurrentLevel(1);
                    return true;
                }
            }

            if (isIn(event, btnStart2)) {
                if (btnStart2.isPushed()) {
                    game.setCurrentGameState(Game.GameState.PLAYING2);
                    game.setCurrentLevel(2);
                    return true;
                }
            }

            if (isIn(event, btnStart3)) {
                if (btnStart3.isPushed()) {
                    game.setCurrentGameState(Game.GameState.PLAYING3);
                    game.setCurrentLevel(3);
                    return true;
                }
            }

            if (isIn(event, btnStart4)) {
                if (btnStart4.isPushed()) {
                    game.setCurrentGameState(Game.GameState.PLAYING4);
                    game.setCurrentLevel(4);
                    return true;
                }
            }


            btnStart.setPushed(false);
            btnStart2.setPushed(false);
            btnStart3.setPushed(false);
            btnStart4.setPushed(false);
            btnStart5.setPushed(false);
        }

        /*if (event.getAction() == MotionEvent.ACTION_MOVE && event.getY() > 500 && event.getY() < 800){
            game.setCurrentGameState(Game.GameState.PLAYING4);
            game.setCurrentLevel(4);
            return true;
        }*/


        return false;


    }



    private boolean isIn(MotionEvent e, CustomButton b) {
        return b.getHitbox().contains(e.getX(), e.getY());
    }
}
