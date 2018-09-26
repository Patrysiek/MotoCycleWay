package com.motocycleway.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

import com.motocycleway.activities.SettingsActivity;
import com.motocycleway.main.GameView;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleCarManager {
    private Bitmap bitmap,rotatedBitmap;
    private ArrayList<ObstacleCar> firstLineCars,secondLineCars,thirdLineCars,forthLineCars;
    private ArrayList<ArrayList<ObstacleCar>> lineList;
    private Random randomSpeed,randomPosition;
    private int id=0;
    private float veloAgainst = GameView.motobike.getyVelocity()+15;
    private float[] xPositions = new float[4];
    public ObstacleCarManager(Bitmap bitmap) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap, SettingsActivity.WIDTH / 5, SettingsActivity.HEIGHT / 4, false);
        setRotatedBitmap();
        randomSpeed = new Random();
        randomPosition = new Random();
        initPositions();
        initListsOFCars();
    }
    private void setRotatedBitmap() {
        Matrix matrix = new Matrix();
        matrix.postRotate(180);
        this.rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, SettingsActivity.WIDTH / 5, SettingsActivity.HEIGHT / 4, matrix, true);
    }
    private void initPositions() {
        xPositions [0] = 0;
        xPositions[1] = SettingsActivity.WIDTH/3-bitmap.getWidth()/2;
        xPositions[2] = SettingsActivity.WIDTH/2+bitmap.getWidth()/2;
        xPositions[3] = SettingsActivity.WIDTH-bitmap.getWidth();
    }

    private void initListsOFCars() {
        firstLineCars = new ArrayList<>();
        secondLineCars = new ArrayList<>();
        thirdLineCars = new ArrayList<>();
        forthLineCars = new ArrayList<>();

        initLineList();

        int i = 0;
        for(ArrayList<ObstacleCar> list : lineList){
            fillEachLine(list,i);
            i++;
        }
    }

    private void initLineList() {
        lineList = new ArrayList<>();
        lineList.add(firstLineCars);
        lineList.add(secondLineCars);
        lineList.add(thirdLineCars);
        lineList.add(forthLineCars);
    }

    public void update(){
        veloAgainst = GameView.motobike.getyVelocity()*2;
    }
    public void draw(Canvas canvas) {
        int i = 0;
        for(ArrayList<ObstacleCar> list : lineList){
            drawEachLine(list,i,canvas);
            i++;
        }
        ifOverlaps();
        ifSmashingAss();


    }



    private void fillEachLine(ArrayList<ObstacleCar> list, int x) {
        for (int i = 0; i < 2; i++) {
            addCar(list,x);
        }
    }

    private void drawEachLine(ArrayList<ObstacleCar> list, int x, Canvas canvas) {
        for (ObstacleCar car : list) {

            car.setY(car.getY() + car.getVelocity());
            if (car.getY() > SettingsActivity.HEIGHT) {
                list.remove(car);
                addCar(list,x);
                break;
            }
            car.draw(canvas);
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

        ObstacleCar c = new ObstacleCar(bitmap,id);
        c.setX(xPositions[x]);
        c.setY(0 - c.getHeight() * (randomPosition.nextInt(10)+2));
        c.setVelocity(velo);
        list.add(c);
        id++;
    }

    private void ifSmashingAss() {
        for(ArrayList<ObstacleCar> list :  lineList ){
            for(ObstacleCar car :list){
                for(ObstacleCar car1 : list) {
                    if (car.getY() + car.getHeight() >= car1.getY()-10 && !car.equals(car1)) {
                        car.setVelocity(car1.getVelocity());
                    }
                }
            }
        }
    }


    private void ifOverlaps() {
        for(ArrayList<ObstacleCar> list :  lineList ){
            for(ObstacleCar car :list){
                for(ObstacleCar car1 : list) {
                    if(car.overlaps(car1))
                        break;
                }
            }
        }
    }
}







