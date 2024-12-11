package com.teachmeskills.lesson_20.task2;

import com.teachmeskills.lesson_20.task2.model.CarAdder;
import com.teachmeskills.lesson_20.task2.model.CarRemover;
import com.teachmeskills.lesson_20.task2.model.ServiceStation;

/**
 * 2. Есть СТО. На сто может быть в обслуживании максимум определенное количество машин.
 * 	Создать класс, который будет запускаться в отдельном потоке и будет добавлять машины на обсуживание в СТО.
 * 	Создать класс, который будет запускаться в отдельном потоке и будет забирать исправленные машины из СТО.
 * 	Пусть максимальное количество доступных для обсуживания машин задается в интерфейсе для хранения констант.
 * 	Использовать synchronized, wait, notify.
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        ServiceStation serviceStation = new ServiceStation();

        Thread adderThread = new Thread(new CarAdder(serviceStation));
        Thread removerThread = new Thread(new CarRemover(serviceStation));

        adderThread.start();
        removerThread.start();
    }
}
