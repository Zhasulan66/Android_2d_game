package com.example.androidstudio2dgamedev.gamestates;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface GameStateInterface {

    void update();
    void render(Canvas c);
    boolean touchEvents(MotionEvent event);

}
