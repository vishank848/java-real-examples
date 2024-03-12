package org.example.ranks;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PressScheduler {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        try {
            Robot robot = new Robot();
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(() -> {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                System.out.println(STR."running...\{i.getAndIncrement()} : \{LocalDateTime.now()}");
//                System.out.println("running..." + i.getAndIncrement() + " : " + LocalDateTime.now());
            }, 0, 1, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
