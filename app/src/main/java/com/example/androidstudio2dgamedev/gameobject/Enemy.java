package com.example.androidstudio2dgamedev.gameobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.core.content.ContextCompat;

import com.example.androidstudio2dgamedev.main.GameDisplay;
import com.example.androidstudio2dgamedev.main.GameLoop;
import com.example.androidstudio2dgamedev.R;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;
import com.example.androidstudio2dgamedev.helpers.GameConstants;

public class Enemy extends Circle {

    private static final double SPEED_PIXELS_PER_SECOND = Player.SPEED_PIXELS_PER_SECOND*0.6;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private static final double SPAWNS_PER_MINUTE = 20;
    private static final double SPAWNS_PER_SECOND = SPAWNS_PER_MINUTE/60.0;
    private static final double UPDATES_PER_SPAWN = GameLoop.MAX_UPS/SPAWNS_PER_SECOND;
    private static double updatesUntilNextSpawn = UPDATES_PER_SPAWN;

    private int enemyDir = GameConstants.Face_Dir.DOWN;
    private int enemyAniIndexY = 0;
    private int aniTick;
    private int aniSpeed = 5;

    private Player player;

    public Enemy(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.enemy), positionX, positionY, radius);
        this.player = player;
    }

    public Enemy(Context context, Player player) {
        super(
                context,
                ContextCompat.getColor(context, R.color.enemy),
                Math.random()*1000,
                Math.random()*1500,
                60
        );
        this.player = player;
    }

    public static boolean readyToSpawn() {
        if (updatesUntilNextSpawn <= 0) {
            updatesUntilNextSpawn += UPDATES_PER_SPAWN;
            return true;
        } else {
            updatesUntilNextSpawn --;
            return false;
        }
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay, SpriteSheet spriteSheet) {

        Bitmap enemy = spriteSheet.getSprite(enemyAniIndexY,enemyDir);

        int x = (int) gameDisplay.gameToDisplayCoordinatesX(positionX);
        int y = (int) gameDisplay.gameToDisplayCoordinatesY(positionY);

        Rect rect = new Rect(0, 0, enemy.getWidth(), enemy.getHeight());

        canvas.drawBitmap(
                enemy,
                rect,
                new Rect(x, y, x+rect.width(), y+rect.height()),
                null
        );

        updateEnemyDir();
    }

    public void update() {
        // =========================================================================================
        //   Update velocity of the enemy so that the velocity is in the direction of the player
        // =========================================================================================
        // Calculate vector from enemy to player (in x and y)
        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        // Calculate (absolute) distance between enemy (this) and player
        double distanceToPlayer = GameObject.getDistanceBetweenObjects(this, player);

        // Calculate direction from enemy to player
        double directionX = distanceToPlayerX/distanceToPlayer;
        double directionY = distanceToPlayerY/distanceToPlayer;

        // Set velocity in the direction to the player
        if(distanceToPlayer > 0) { // Avoid division by zero
            velocityX = directionX*MAX_SPEED;
            velocityY = directionY*MAX_SPEED;
        } else {
            velocityX = 0;
            velocityY = 0;
        }

        // =========================================================================================
        //   Update position of the enemy
        // =========================================================================================
        positionX += velocityX;
        positionY += velocityY;

    }

    public void updateEnemyDir () {
        if (getVelocityX() != 0 || getVelocityY() != 0) {

            if (getVelocityX() > getVelocityY()) {
                if (getVelocityX() > 0) enemyDir = GameConstants.Face_Dir.RIGHT;
                else enemyDir = GameConstants.Face_Dir.LEFT;
            } else {
                if (getVelocityY() > 0) enemyDir = GameConstants.Face_Dir.DOWN;
                else enemyDir = GameConstants.Face_Dir.UP;
            }
        }
    }

    public void updateAnimation() {
        if (getVelocityX() == 0 && getVelocityY() == 0)
            return;
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            enemyAniIndexY++;
            if (enemyAniIndexY >= 4)
                enemyAniIndexY = 0;
        }
    }
}
