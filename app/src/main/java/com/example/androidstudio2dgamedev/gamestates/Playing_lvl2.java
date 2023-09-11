package com.example.androidstudio2dgamedev.gamestates;

import static com.example.androidstudio2dgamedev.map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.androidstudio2dgamedev.map.MapLayout.TILE_WIDTH_PIXELS;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.example.androidstudio2dgamedev.R;
import com.example.androidstudio2dgamedev.gameobject.AssetSetter;
import com.example.androidstudio2dgamedev.gameobject.Circle;
import com.example.androidstudio2dgamedev.gameobject.Enemy;
import com.example.androidstudio2dgamedev.gameobject.NPC_Girl;
import com.example.androidstudio2dgamedev.gameobject.Player;
import com.example.androidstudio2dgamedev.gameobject.Spell;
import com.example.androidstudio2dgamedev.gameobject.SuperObject;
import com.example.androidstudio2dgamedev.gamepanel.GameOver;
import com.example.androidstudio2dgamedev.gamepanel.Joystick;
import com.example.androidstudio2dgamedev.gamepanel.Performance;
import com.example.androidstudio2dgamedev.graphics.Animator;
import com.example.androidstudio2dgamedev.graphics.SpriteSheet;
import com.example.androidstudio2dgamedev.main.Game;
import com.example.androidstudio2dgamedev.main.GameDisplay;
import com.example.androidstudio2dgamedev.map.Tilemap;
import com.example.androidstudio2dgamedev.ui.ButtonImages;
import com.example.androidstudio2dgamedev.ui.CustomButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Playing_lvl2 extends BaseState implements GameStateInterface {

    private final Tilemap tilemap;
    private final Player player;
    private final Joystick joystick;

    //public AssetSetter aSetter = new AssetSetter(this);
    private List<Enemy> enemyList = new ArrayList<>();
    private List<Spell> spellList = new ArrayList<>();

    private final NPC_Girl npc_girl;

    public SuperObject obj[] = new SuperObject[10];
    private int joystickPointerId = 0;
    private GameOver gameOver;
    private Performance performance;
    private GameDisplay gameDisplay;

    private int playerDrawId = R.drawable.player_spritesheet;
    private int enemyDrawId = R.drawable.skeleton_spritesheet;
    private int npcGirlDrawId = R.drawable.princess_spritesheet;
    private int mapDrawId = R.drawable.tileset; //tileset_floor , sprite_sheet
    private SpriteSheet enemySpriteSheet = new SpriteSheet(game.getContext(), enemyDrawId);
    private SpriteSheet npc_girlSpriteSheet = new SpriteSheet(game.getContext(), npcGirlDrawId);
    private SpriteSheet mapSpriteSheet = new SpriteSheet(game.getContext(), mapDrawId);

    int enemyAmount = 10;
    int key_count = 0;
    int def_enemy = 10;
    int dialog_num = 0;
    private CustomButton btnMenu;


    public Playing_lvl2(Game game) {
        super(game);

        //aSetter.setObject_lvl2();

        // Initialize Tilemap
        tilemap = new Tilemap(mapSpriteSheet, 2);

        // Initialize game panels
        performance = new Performance(game.getContext(), game.getGameLoop());
        joystick = new Joystick(200, 1800, 105, 80);
        gameOver = new GameOver(game.getContext());

        // Initialize game objects
        SpriteSheet spriteSheet = new SpriteSheet(game.getContext(), playerDrawId);
        Animator animator = new Animator(spriteSheet);
        player = new Player(game.getContext(), joystick, 1544, 1000, 32, animator, tilemap); // 1080 x 2340  //540, 1170


        // Initialize display and center it around the player
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) game.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        gameDisplay = new GameDisplay(displayMetrics.widthPixels, displayMetrics.heightPixels, player);

        //setFocusable(true);
        npc_girl = new NPC_Girl(game.getContext(), player);
        btnMenu = new CustomButton(900, 5, ButtonImages.PLAYING_MENU.getWidth(), ButtonImages.PLAYING_MENU.getHeight());
    }

    @Override
    public void update() {

        if (player.getHealthPoints() <= 0) {
            return;
        }

        if(def_enemy == 0) {
            game.setDialogNum(0);
            game.setCurrentGameState(Game.GameState.LEVEL_SCREEN);
            //return;
        }

        if(enemyAmount == 7 && dialog_num == 0) {
            game.setCurrentGameState(Game.GameState.DIALOG);
            dialog_num = 1;
            //return;
        }

        if(enemyAmount == 4 && dialog_num == 1) {
            game.setDialogNum(1);
            game.setCurrentGameState(Game.GameState.DIALOG);
            dialog_num = 2;
            //return;
        }

        joystick.update();
        player.update();

        if(player.getPositionX() < 0 || player.getPositionY() < 0){
            player.setPosition(player.getPreviousPositionX(), player.getPreviousPositionY());
        }

        for (int i = 0; i < obj.length; i++) {

            if (obj[i] != null && !obj[i].collision) {
                int x = (int) obj[i].worldX;
                int y = (int) obj[i].worldY;
                if (Circle.isColliding(player, new Rect(x, y, x+obj[i].rect.width(), y+obj[i].rect.height()))) {
                    obj[i] = null;
                    key_count++;
                }
            }
        }

        npc_girl.update();
        npc_girl.updateAnimation();

        if(Enemy.readyToSpawn() && enemyAmount > 0){
            enemyList.add(new Enemy(game.getContext(), player));
            enemyAmount--;
        }

        for(Enemy enemy : enemyList){
            enemy.update();
            enemy.updateAnimation();
        }

        for (Spell spell : spellList) {
            spell.update();
        }

        // Iterate through enemyList and Check for collision between each enemy and the player and
        // spells in spellList.
        Iterator<Enemy> iteratorEnemy = enemyList.iterator();
        while (iteratorEnemy.hasNext()) {
            Circle enemy = iteratorEnemy.next();
            if (Circle.isColliding(enemy, player)) {
                // Remove enemy if it collides with the player
                iteratorEnemy.remove();
                player.setHealthPoints(player.getHealthPoints() - 1);
                def_enemy--;
                continue;
            }


            Iterator<Spell> iteratorSpell = spellList.iterator();
            while (iteratorSpell.hasNext()) {
                Circle spell = iteratorSpell.next();
                // Remove enemy if it collides with a spell
                if (Circle.isColliding(spell, enemy)) {
                    iteratorSpell.remove();
                    iteratorEnemy.remove();
                    def_enemy--;
                    break;
                }
            }
        }

        gameDisplay.update();

    }

    @Override
    public void render(Canvas c) {

        tilemap.draw(c, gameDisplay);

        performance.draw(c);
        if(game.getCurrentGameState() != Game.GameState.DIALOG) {
            joystick.draw(c);
        }
        //DRAW objects
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(c, gameDisplay);
            }
        }

        player.draw(c, gameDisplay);

        // Draw Game over if the player is dead
        if (player.getHealthPoints() <= 0) {
            gameOver.draw(c);
        }

        // Draw Game Win if the player wins
        if (obj[3] != null) {
            int x = 37 * TILE_WIDTH_PIXELS;
            int y = 33 * TILE_HEIGHT_PIXELS;
            if (Circle.isColliding(player, new Rect(x, y, x+obj[3].rect.width(), y+obj[3].rect.height()))) {
                if(key_count == 3) {
                    gameOver.draw(c);
                }
            }
        }

        /*if(enemyAmount == 0 && dialog_num == 1) {
            gameOver.draw(c);
            game.setCurrentGameState(Game.GameState.LEVEL_SCREEN);
            dialog_num = 2;
            return;
        }*/

        npc_girl.draw(c, gameDisplay, npc_girlSpriteSheet);

        c.drawBitmap(
                ButtonImages.PLAYING_MENU.getBtnImg(btnMenu.isPushed()),
                btnMenu.getHitbox().left,
                btnMenu.getHitbox().top,
                null);

        for (Enemy enemy : enemyList){
            enemy.draw(c, gameDisplay, enemySpriteSheet);
        }

        for (Spell spell : spellList) {
            spell.draw(c, gameDisplay);
        }

    }

    @Override
    public boolean touchEvents(MotionEvent event) {

        // Handle user input touch event actions
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                if (joystick.getIsPressed()) {
                    // Joystick was pressed before this event -> cast spell
                    spellList.add(new Spell(game.getContext(), player));
                } else if (joystick.isPressed((double) event.getX(), (double) event.getY())) {
                    // Joystick is pressed in this event -> setIsPressed(true) and store pointer id
                    joystickPointerId = event.getPointerId(event.getActionIndex());
                    joystick.setIsPressed(true);
                } else {
                    // Joystick was not previously, and is not pressed in this event -> cast spell
                    spellList.add(new Spell(game.getContext(), player));
                    if (isIn(event, btnMenu)) {
                        btnMenu.setPushed(true);
                    }
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if (joystick.getIsPressed()) {
                    // Joystick was pressed previously and is now moved
                    joystick.setActuator((double) event.getX(), (double) event.getY());
                }
                return true;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                if (joystickPointerId == event.getPointerId(event.getActionIndex())) {
                    // joystick pointer was let go off -> setIsPressed(false) and resetActuator()
                    joystick.setIsPressed(false);
                    joystick.resetActuator();
                }
                if (isIn(event, btnMenu))
                    if (btnMenu.isPushed())
                        game.setCurrentGameState(Game.GameState.LEVEL_SCREEN);

                btnMenu.setPushed(false);
                return true;
        }
        return false;

    }

    public void setupGame(){
        //aSetter.setObject();
    }

    private boolean isIn(MotionEvent e, CustomButton b) {
        return b.getHitbox().contains(e.getX(), e.getY());
    }


}
