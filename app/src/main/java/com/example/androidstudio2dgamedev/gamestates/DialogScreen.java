package com.example.androidstudio2dgamedev.gamestates;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;

import com.example.androidstudio2dgamedev.main.Game;

import java.util.ArrayList;
import java.util.List;

public class DialogScreen extends BaseState implements GameStateInterface{

    private Paint paint_blackFill;
    private Paint paint_stroke;
    private Paint paint_textB;
    private Paint paint_text;
    float cornerRadius = 20.0f;
    int alpha = Color.argb(128, 0, 0, 0);

    //Question and answer rectangles
    private RectF big_rect = new RectF(50, 100, 1050, 400);

    private RectF rectOp1 = new RectF(50, 1400, 450, 1600);
    private RectF rectOp2 = new RectF(650, 1400, 1050, 1600);
    private RectF rectOp3 = new RectF(50, 1650, 450, 1850);
    private RectF rectOp4 = new RectF(650, 1650, 1050, 1850);

    private int question_num;
    private List<String> questionList = null;
    private String[][] answer_List = new String[8][4];

    //Text holders for Q&A
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;

    public DialogScreen(Game game) {
        super(game);
        initializeQuestions();

        paint_blackFill = new Paint();
        paint_blackFill.setStyle(Paint.Style.FILL);
        paint_blackFill.setColor(alpha);

        paint_stroke = new Paint();
        paint_stroke.setStyle(Paint.Style.STROKE);
        paint_stroke.setStrokeWidth(5.0f);
        paint_stroke.setColor(Color.WHITE);

        paint_textB = new Paint();
        paint_textB.setTextSize(50);
        paint_textB.setColor(Color.WHITE);

        paint_text = new Paint();
        paint_text.setTextSize(40);
        paint_text.setColor(Color.WHITE);

        question = questionList.get(question_num);
        ans1 = answer_List[question_num][0];
        ans2 = answer_List[question_num][1];
        ans3 = answer_List[question_num][2];
        ans4 = answer_List[question_num][3];
    }

    @Override
    public void update() {

        question = questionList.get(question_num);
        ans1 = answer_List[question_num][0];
        ans2 = answer_List[question_num][1];
        ans3 = answer_List[question_num][2];
        ans4 = answer_List[question_num][3];
    }

    @Override
    public void render(Canvas c) {

        c.drawRoundRect(big_rect, cornerRadius, cornerRadius, paint_stroke);
        c.drawRoundRect(big_rect, cornerRadius, cornerRadius, paint_blackFill);

        drawOptions(c);

        int questionX = 100,questionY = 160;
        for(String line : question.split("\n")){
            c.drawText(line, questionX, questionY, paint_textB);
            questionY+=70;
        }

        int ans1X = 100,ans1Y = 1500;
        int ans2X = 700,ans2Y = 1500;
        int ans3X = 100,ans3Y = 1750;
        int ans4X = 700,ans4Y = 1750;

        for(String line : ans1.split("\n")){
            c.drawText(line, ans1X, ans1Y, paint_text);
            ans1Y+=50;
        }
        for(String line : ans2.split("\n")){
            c.drawText(line, ans2X, ans2Y, paint_text);
            ans2Y+=50;
        }
        for(String line : ans3.split("\n")){
            c.drawText(line, ans3X, ans3Y, paint_text);
            ans3Y+=50;
        }
        for(String line : ans4.split("\n")){
            c.drawText(line, ans4X, ans4Y, paint_text);
            ans4Y+=50;
        }
    }

    @Override
    public boolean touchEvents(MotionEvent event) {

        switch (game.getCurrentLevel()){
            case 1: {
                sendAnswer(event, Game.GameState.PLAYING);
                return true;
            }
            case 2: {
                sendAnswer(event, Game.GameState.PLAYING2);
                return true;
            }
            case 3: {
                sendAnswer(event, Game.GameState.PLAYING3);
                return true;
            }
            case 4: {
                sendAnswer(event, Game.GameState.PLAYING4);
                return true;
            }
        }


        return false;
    }

    public void drawOptions(Canvas c){
        c.drawRoundRect(rectOp1, cornerRadius, cornerRadius, paint_stroke);
        c.drawRoundRect(rectOp1, cornerRadius, cornerRadius, paint_blackFill);

        c.drawRoundRect(rectOp2, cornerRadius, cornerRadius, paint_stroke);
        c.drawRoundRect(rectOp2, cornerRadius, cornerRadius, paint_blackFill);

        c.drawRoundRect(rectOp3, cornerRadius, cornerRadius, paint_stroke);
        c.drawRoundRect(rectOp3, cornerRadius, cornerRadius, paint_blackFill);

        c.drawRoundRect(rectOp4, cornerRadius, cornerRadius, paint_stroke);
        c.drawRoundRect(rectOp4, cornerRadius, cornerRadius, paint_blackFill);
    }

    public void initializeQuestions(){

        questionList = new ArrayList<>();
        questionList.add("What is your favorite color?"); //0
        questionList.add("Which season do you like the most?");  //1
        questionList.add("What's your preferred type of movie genre?");  //2
        questionList.add("What's your favorite animal?");  //3
        questionList.add("What's your favorite dessert?");  //4
        questionList.add("Which is your favorite sport?");  //5
        questionList.add("What's your preferred mode\n of transportation?");  //6
        questionList.add("Which is your favorite hobby?");  //7


        answer_List[0][0] = "Red";
        answer_List[0][1] = "Blue";
        answer_List[0][2] = "Green";
        answer_List[0][3] = "Yellow";

        answer_List[1][0] = "Spring";
        answer_List[1][1] = "Summer";
        answer_List[1][2] = "Fall";
        answer_List[1][3] = "Winter";

        answer_List[2][0] = "Comedy";
        answer_List[2][1] = "Action";
        answer_List[2][2] = "Drama";
        answer_List[2][3] = "Horror";

        answer_List[3][0] = "Dog";
        answer_List[3][1] = "Cat";
        answer_List[3][2] = "Dolphin";
        answer_List[3][3] = "Elephant";

        answer_List[4][0] = "Cake";
        answer_List[4][1] = "Pie";
        answer_List[4][2] = "Cookies";
        answer_List[4][3] = "Fruit Salad";

        answer_List[5][0] = "Soccer";
        answer_List[5][1] = "Basketball";
        answer_List[5][2] = "Tennis";
        answer_List[5][3] = "Swimming";

        answer_List[6][0] = "Car";
        answer_List[6][1] = "Bicycle";
        answer_List[6][2] = "Walking";
        answer_List[6][3] = "Public Transit";

        answer_List[7][0] = "Reading";
        answer_List[7][1] = "Painting";
        answer_List[7][2] = "Playing a \nmusical instrument";
        answer_List[7][3] = "Gardening";
    }

    public void setQuestion_num(int question_num) {
        this.question_num = question_num;
    }

    public void sendAnswer(MotionEvent event, Game.GameState gameState){
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (rectOp1.contains(event.getX(), event.getY())) {
                System.out.println( question + " answer is: " + answer_List[question_num][0]);
                game.setCurrentGameState(gameState);
            }
            if (rectOp2.contains(event.getX(), event.getY())) {
                System.out.println(question + "answer is: " + answer_List[question_num][1]);
                game.setCurrentGameState(gameState);
            }
            if (rectOp3.contains(event.getX(), event.getY())) {
                System.out.println(question + "answer is: " + answer_List[question_num][2]);
                game.setCurrentGameState(gameState);
            }
            if (rectOp4.contains(event.getX(), event.getY())) {
                System.out.println(question + "answer is: " + answer_List[question_num][3]);
                game.setCurrentGameState(gameState);
            }
        }
    }
}
