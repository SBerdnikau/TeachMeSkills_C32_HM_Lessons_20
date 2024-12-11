package com.teachmeskills.lesson_20.task2.model;

public class CarRemover implements Runnable{
    private final ServiceStation serviceStation;

    public CarRemover(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        try {
            while (true) {
                serviceStation.removeCar();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
