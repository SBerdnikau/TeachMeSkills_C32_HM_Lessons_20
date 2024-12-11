package com.teachmeskills.lesson_20.task1;

import com.teachmeskills.lesson_20.task1.model.MorningTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 1. Cоздать программу, иммитирующую утро: чтение нововостей, завтра, кофе.
 * 	Каждому потоку задать имя и приоритет из конфиг файла.
 * 	Пусть будет 3 потока.
 * 	Создать и запустить 3 потока.
 * 	Сделать два варианта: используя интерфейс Runnable и/или используя класс Thread.
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("src/com/teachmeskills/lesson_20/task1/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            return;
        }

        Thread newsThread = new Thread(new MorningTask(properties.getProperty("thread1.name"),
                Integer.parseInt(properties.getProperty("thread1.priority")))
        );
        Thread breakfastThread = new Thread(new MorningTask(properties.getProperty("thread2.name"),
                Integer.parseInt(properties.getProperty("thread2.priority")))
        );
        Thread coffeeThread = new Thread(new MorningTask(properties.getProperty("thread3.name"),
                Integer.parseInt(properties.getProperty("thread3.priority")))
        );

        newsThread.setPriority(newsThread.getPriority());
        breakfastThread.setPriority(breakfastThread.getPriority());
        coffeeThread.setPriority(coffeeThread.getPriority());

        newsThread.start();
        breakfastThread.start();
        coffeeThread.start();

        try {
            newsThread.join();
            breakfastThread.join();
            coffeeThread.join();
        } catch (InterruptedException e) {
            System.out.println("The current flow has been interrupted." + e.getMessage());
        }
    }
}
