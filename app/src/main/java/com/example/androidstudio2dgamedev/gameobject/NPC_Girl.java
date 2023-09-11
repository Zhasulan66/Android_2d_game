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

public class NPC_Girl extends Circle{

    private static final double SPEED_PIXELS_PER_SECOND = Player.SPEED_PIXELS_PER_SECOND*0.6;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    private int npcDir = GameConstants.Face_Dir.DOWN;
    private int npcAniIndexY = 0;
    private int aniTick;
    private int aniSpeed = 5;

    private Player player;

    public NPC_Girl(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.npc), positionX, positionY, radius);
        this.player = player;
    }

    public NPC_Girl(Context context, Player player) {
        super(
                context,
                ContextCompat.getColor(context, R.color.enemy),
                1000,
                500,
                60
        );
        this.player = player;
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay, SpriteSheet spriteSheet) {

        Bitmap npc_girl = spriteSheet.getSprite(npcAniIndexY,npcDir);

        int x = (int) gameDisplay.gameToDisplayCoordinatesX(positionX);
        int y = (int) gameDisplay.gameToDisplayCoordinatesY(positionY);

        Rect rect = new Rect(0, 0, npc_girl.getWidth(), npc_girl.getHeight());

        canvas.drawBitmap(
                npc_girl,
                rect,
                new Rect(x, y, x+rect.width(), y+rect.height()),
                null
        );

        updateNPCDir();
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
        if(distanceToPlayer > 50) { // Avoid division by zero
            velocityX = directionX*MAX_SPEED;
            velocityY = directionY*MAX_SPEED;
        } else {
            velocityX = 0;
            velocityY = 0;
            npcDir = GameConstants.Face_Dir.DOWN;
        }

        // =========================================================================================
        //   Update position of the enemy
        // =========================================================================================
        positionX += velocityX;
        positionY += velocityY;

    }

    public void updateNPCDir () {
        if (getVelocityX() != 0 || getVelocityY() != 0) {

            if (getVelocityX() > getVelocityY()) {
                if (getVelocityX() > 0) npcDir = GameConstants.Face_Dir.RIGHT;
                else npcDir = GameConstants.Face_Dir.LEFT;
            } else {
                if (getVelocityY() > 0) npcDir = GameConstants.Face_Dir.DOWN;
                else npcDir = GameConstants.Face_Dir.UP;
            }
        }
    }

    public void updateAnimation() {
        if (getVelocityX() == 0 && getVelocityY() == 0)
            return;
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            npcAniIndexY++;
            if (npcAniIndexY >= 4)
                npcAniIndexY = 0;
        }
    }
}
