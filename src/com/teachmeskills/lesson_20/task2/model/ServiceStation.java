package com.teachmeskills.lesson_20.task2.model;

import com.teachmeskills.lesson_20.task2.utils.Constants;

public class ServiceStation {
    private final int[] carsInService = new int[Constants.MAX_CARS_IN_SERVICE];
    private int count = 0;

    public synchronized void addCar() throws InterruptedException {
        while (count >= Constants.MAX_CARS_IN_SERVICE) {
            System.out.println("The service station is overcrowded, we are waiting...");
            wait();
        }
        carsInService[count] = 1;
        count++;
        System.out.println("The machine has been added to service. Current number of machines: " + count);
        notifyAll();
    }

    public synchronized void removeCar() throws InterruptedException {
        while (count == 0) {
            System.out.println("No cars available, waiting...");
            wait();
        }
        count--;
        carsInService[count] = 0;
        System.out.println("The car has been taken out of service. Current number of cars: " + count);
        notifyAll();
    }
}
