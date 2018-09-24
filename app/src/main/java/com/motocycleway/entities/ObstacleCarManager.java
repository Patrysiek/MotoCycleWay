package com.motocycleway.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.motocycleway.activities.SettingsActivity;
import com.motocycleway.main.GameView;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleCarManager {
    Bitmap bitmap;
    private ArrayList<ObstacleCar> cars;
    private float[] xPositions = new float[4];
    public ObstacleCarManager(Bitmap bitmap) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap, SettingsActivity.WIDTH / 5, SettingsActivity.HEIGHT / 4, false);
        initPositions();
        initObstacleCars();

    }

    private void initPositions() {
        xPositions [0] = 0;
        xPositions[1] = SettingsActivity.WIDTH/3-bitmap.getWidth()/2;
        xPositions[2] = SettingsActivity.WIDTH/2+bitmap.getWidth()/2;
        xPositions[3] = SettingsActivity.WIDTH-bitmap.getWidth();
    }




    private void initObstacleCars() {
        cars = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cars.add(new ObstacleCar(bitmap));
            cars.get(i).setX(xPositions[i]);
            cars.get(i).setY(0 - cars.get(0).getHeight() * new Random().nextInt(5));
        }
    }


    public void draw(Canvas canvas) {
        for (ObstacleCar car : cars) {

            car.setY(car.getY() + GameView.motobike.getyVelocity()+car.getyVelo());

            if (car.getY() > SettingsActivity.HEIGHT) {
                car.setY(0 - cars.get(0).getHeight() - (cars.get(0).getHeight()* new Random().nextInt(4)));
                car.setX(xPositions[new Random().nextInt(4)]);
                car.setyVelo(new Random().nextFloat()*4);
            }
            car.draw(canvas);
        }

        ifCollide();

    }

    private void ifCollide() {
        for(ObstacleCar car : cars){

            for(ObstacleCar car1 : cars) {
                if (car.getY() + car.getHeight() == car1.getY() && car.getX() == car1.getX()) {
                    car.setyVelo(0);
                }
            }
        }
    }
}

