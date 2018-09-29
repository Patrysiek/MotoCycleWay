package com.motocycleway.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

import com.motocycleway.activities.SettingsActivity;
import com.motocycleway.main.CrashDetector;
import com.motocycleway.main.GameView;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleCarManager {
    private Bitmap bitmap,rotatedBitmap;
    private ArrayList<ArrayList<ObstacleCar>> mainLineList;
    private Random randomSpeed,randomPosition;
    private int carsId = 0;
    private float veloAgainst;
    private float[] xPositions = new float[4];

    private final int BITMAP_WIDTH = SettingsActivity.WIDTH / 5;
    private final int BITMAP_HEIGHT = SettingsActivity.HEIGHT / 4;


    public ObstacleCarManager(Bitmap bitmap) {

        randomSpeed = new Random();
        randomPosition = new Random();
        veloAgainst = GameView.motobike.getSpeed()+15;

        setBitmap(bitmap);
        setRotatedBitmap();


        initPositions();
        initMainLineList();
        fillWholeMainList();
    }

    private void setBitmap(Bitmap bitmap) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap, BITMAP_WIDTH,BITMAP_HEIGHT , false);
    }

    private void setRotatedBitmap() {
        Matrix matrix = new Matrix();
        matrix.postRotate(180);
        this.rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, BITMAP_WIDTH, BITMAP_HEIGHT, matrix, true);
    }


    private void initPositions() {
        xPositions[0] = 0;
        xPositions[1] = SettingsActivity.WIDTH/3-bitmap.getWidth()/2;
        xPositions[2] = SettingsActivity.WIDTH/2+bitmap.getWidth()/2;
        xPositions[3] = SettingsActivity.WIDTH-bitmap.getWidth();
    }

    private void initMainLineList() {
        mainLineList  = new ArrayList<>();
        for(int i = 0; i<4; i++)
            mainLineList.add(new ArrayList<>(2));
    }


    private void fillWholeMainList() {
        for(ArrayList<ObstacleCar> list : mainLineList){
            for(int i=0; i<2;i++){
                addCar(list,mainLineList.indexOf(list));
            }
        }
    }

    private void addCar(ArrayList<ObstacleCar> list,int x){
        Bitmap bitmap;
        float velo;
        if(x>1) {
            bitmap = Bitmap.createBitmap(rotatedBitmap);
            velo = randomSpeed.nextFloat()*7+3;
        }
        else {
            bitmap = Bitmap.createBitmap(this.bitmap);
            velo = randomSpeed.nextFloat()*7+veloAgainst;
        }

        list.add(new ObstacleCar(bitmap,velo,xPositions[x],carRandomStartingY(),carsId));
        carsId++;
    }




    private float carRandomStartingY() {
        return 0 - bitmap.getHeight() *( randomPosition.nextInt(6)+5);
    }


    public void update(){
        veloAgainst = GameView.motobike.getSpeed()+15;
    }


    public void draw(Canvas canvas) {

        for(ArrayList<ObstacleCar> list : mainLineList){
            drawEachLine(list,canvas);
        }
        CrashDetector.ifOverlaps(mainLineList);
        CrashDetector.ifSmashingAss(mainLineList);
    }

    private void drawEachLine(ArrayList<ObstacleCar> list, Canvas canvas) {
        for (ObstacleCar car : list) {
            car.setY(car.getY() + car.getVelocity());
            if (car.getY() > SettingsActivity.HEIGHT) {
                car.setY(carRandomStartingY());
                break;
            }
            car.draw(canvas);
        }
    }

    public ArrayList<ArrayList<ObstacleCar>> getMainLineList() {
        return mainLineList;
    }
}







