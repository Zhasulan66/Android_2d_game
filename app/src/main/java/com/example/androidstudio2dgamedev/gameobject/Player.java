package com.example.androidstudio2dgamedev.gameobject;

import static com.example.androidstudio2dgamedev.helpers.Utils.circleIntersectsRect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

import androidx.core.content.ContextCompat;

import com.example.androidstudio2dgamedev.gamestates.Playing;
import com.example.androidstudio2dgamedev.main.Game;
import com.example.androidstudio2dgamedev.main.GameDisplay;
import com.example.androidstudio2dgamedev.main.GameLoop;
import com.example.androidstudio2dgamedev.gamepanel.HealthBar;
import com.example.androidstudio2dgamedev.gamepanel.Joystick;
import com.example.androidstudio2dgamedev.R;
import com.example.androidstudio2dgamedev.helpers.Utils;
import com.example.androidstudio2dgamedev.graphics.Animator;
import com.example.androidstudio2dgamedev.map.Tilemap;

public class Player extends Circle {
    public static final int MAX_HEALTH_POINTS = 5;
    private int healthPoints = MAX_HEALTH_POINTS;
    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private Joystick joystick;
    private final HealthBar healthBar;

    private double previousPositionX;
    private double previousPositionY;


    private Animator animator;
    private final Tilemap tilemap;

    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Animator animator, Tilemap tilemap) {
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.healthBar = new HealthBar(context, this);
        this.joystick = joystick;
        this.animator = animator;
        this.tilemap = tilemap;


        this.previousPositionX = positionX;
        this.previousPositionY = positionY;
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        animator.draw(canvas, gameDisplay, this);

        healthBar.draw(canvas, gameDisplay);
    }

    @Override
    public void update() {
        // Update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX() * MAX_SPEED;
        velocityY = joystick.getActuatorY() * MAX_SPEED;

        // Update position
        double newPositionX = positionX + velocityX;
        double newPositionY = positionY + velocityY;

        // Check if the new position is within the bounds of the map
        if (newPositionX - radius >= tilemap.getLeft() &&
                newPositionX + radius <= tilemap.getRight() &&
                newPositionY - radius >= tilemap.getTop() &&
                newPositionY + radius <= tilemap.getBottom() &&
                canWalkTo(newPositionX, newPositionY)) {

            positionX = newPositionX;
            positionY = newPositionY;

            // Update previous position
            previousPositionX = positionX;
            previousPositionY = positionY;


            // Update direction
            if (velocityX != 0 || velocityY != 0) {
                // Normalize velocity to get direction (unit vector of velocity)
                double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
                directionX = velocityX / distance;
                directionY = velocityY / distance;
            }


            animator.updateAnimation(this);
        } else {
            // Player is trying to move outside of the map, so don't update position or direction
            /*velocityX = 0;
            velocityY = 0;*/
            positionX = previousPositionX;
            positionY = previousPositionY;
            animator.updateAnimation(this);

            System.out.println("unwalkableeeeee!");
        }

        if (this.velocityX == 0 && this.velocityY == 0)
            animator.resetAnimation();
    }

    public boolean canWalkTo(double nextPositionX, double nextPositionY) {
        // Calculate the indices of the tile that the player is trying to move onto
        int tileX = (int) (nextPositionX / 64);
        int tileY = (int) (nextPositionY / 64);

        // Get the rectangle of the tile
        RectF tileRect = tilemap.getTileRect(tileX, tileY);

        // Check if the player's circle intersects with the tile's rectangle
        if (circleIntersectsRect(nextPositionX, nextPositionY, radius, tileRect)) {
            return tilemap.isTileWalkable(tileY, tileX);
        }

        return false;
    }

    public int checkObject(Playing playing, GameDisplay gameDisplay, boolean player) {
        int index = 999;

        for (int i = 0; i < playing.obj.length; i++) {

            if (playing.obj[i] != null) {

                if (isColliding(this, playing.obj[i].rect)) {
                    playing.obj[i] = null;
                }

            }

        }

        return index;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints >= 0) {
            this.healthPoints = healthPoints;
        }
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public double getPreviousPositionX() {
        return previousPositionX;
    }

    public double getPreviousPositionY() {
        return previousPositionY;
    }


    public Joystick getJoystick() {
        return joystick;
    }

    public Animator getAnimator() {
        return animator;
    }
}
