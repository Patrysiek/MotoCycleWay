package com.motocycleway.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.motocycleway.activities.SettingsActivity;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleCarManager {
    Bitmap bitmap;
    private ArrayList<ObstacleCar> cars;

    public ObstacleCarManager(Bitmap bitmap) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap, SettingsActivity.WIDTH / 5, SettingsActivity.HEIGHT / 4, false);
        initObstacleCars();
    }

    private void initObstacleCars() {
        cars = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cars.add(new ObstacleCar(bitmap));
            cars.get(i).getxPositions(i);
        }
    }


    public void draw(Canvas canvas) {
        for (ObstacleCar car : cars) {
            car.y = 0 - cars.get(0).getHeight() * new Random().nextInt(5);
            car.y++;

            if (car.y > SettingsActivity.HEIGHT)
                car.y = 0 - cars.get(0).getHeight() * new Random().nextInt(5);

                car.draw(canvas);




        }

    }
}

