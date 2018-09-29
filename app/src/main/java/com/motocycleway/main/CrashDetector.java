package com.motocycleway.main;

import com.motocycleway.activities.SettingsActivity;
import com.motocycleway.entities.ObstacleCar;

import java.util.ArrayList;

public class CrashDetector {

    private CrashDetector(){

    }
    public static void ifOverlaps(ArrayList<ArrayList<ObstacleCar>> mainLineList) {
        for(ArrayList<ObstacleCar> list : mainLineList){
            for(ObstacleCar car :list){
                for(ObstacleCar car1 : list) {
                    if(car.overlaps(car1)){
                        car.setY(SettingsActivity.HEIGHT);
                        break;
                    }

                }
            }
        }
    }

    public static void ifSmashingAss(ArrayList<ArrayList<ObstacleCar>> mainLineList) {
        for(ArrayList<ObstacleCar> list : mainLineList){
            for(ObstacleCar car :list){
                for(ObstacleCar car1 : list) {
                    if (car.getY() + car.getHeight() >= car1.getY()-10 && !car.equals(car1)) {
                        car.setVelocity(car1.getVelocity());
                    }
                }
            }
        }
    }

    public static boolean motoCrashWithCar(ArrayList<ArrayList<ObstacleCar>> mainLineList){
        for(ArrayList<ObstacleCar> list : mainLineList){
            for(ObstacleCar car : list) {
                if(GameView.motobike.overlaps(car)){
                    return true;
                }

            }
        }
        return false;
    }
}
