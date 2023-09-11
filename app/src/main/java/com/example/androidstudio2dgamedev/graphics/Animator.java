package com.example.androidstudio2dgamedev.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.androidstudio2dgamedev.main.GameDisplay;
import com.example.androidstudio2dgamedev.gameobject.Player;
import com.example.androidstudio2dgamedev.helpers.GameConstants;

public class Animator {
    private SpriteSheet spriteSheet;

    private int playerAniIndexY, playerFaceDir = GameConstants.Face_Dir.DOWN;
    private int aniTick;
    private int aniSpeed = 5;

    private int prevFaceDir = GameConstants.Face_Dir.DOWN;

    public Animator(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay, Player player) {

        updatePlayerDir(player);
        drawFrame(canvas, gameDisplay, player, spriteSheet.getSprite(playerAniIndexY, playerFaceDir));
    }

    public void drawFrame(Canvas canvas, GameDisplay gameDisplay, Player player, Bitmap sprite) {

        int x = (int) gameDisplay.gameToDisplayCoordinatesX(player.getPositionX()) - sprite.getWidth()/2;
        int y = (int) gameDisplay.gameToDisplayCoordinatesY(player.getPositionY()) - sprite.getHeight()/2;

        Rect rect = new Rect(0, 0, sprite.getWidth(), sprite.getHeight());

        canvas.drawBitmap(
                sprite,
                rect,
                new Rect(x, y, x+rect.width(), y+rect.height()),
                null
        );
    }

    public void updateAnimation(Player player) {
        if (player.getVelocityX() == 0 && player.getVelocityY() == 0)
            return;
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            playerAniIndexY++;
            if (playerAniIndexY >= 4)
                playerAniIndexY = 0;
        }
    }

    public void resetAnimation() {
        aniTick = 0;
        playerAniIndexY = 0;
    }

    public void updatePlayerDir(Player player) {
        if (player.getVelocityX() != 0 || player.getVelocityY() != 0) {

            if (player.getVelocityX() > player.getVelocityY()) {
                if (player.getDirectionX() > 0) playerFaceDir = GameConstants.Face_Dir.RIGHT;
                else playerFaceDir = GameConstants.Face_Dir.LEFT;
            } else {
                if (player.getDirectionY() > 0) playerFaceDir = GameConstants.Face_Dir.DOWN;
                else playerFaceDir = GameConstants.Face_Dir.UP;
            }
        }
    }

}
