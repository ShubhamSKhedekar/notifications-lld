package com.notifications.lld.observers.NotificationEngine;

import com.notifications.lld.observable.IObservable;
import com.notifications.lld.observers.IObserver;

public abstract class NotificationChannel implements IObserver {
    private String logData;
    private IObservable observable;

    public NotificationChannel(IObservable observable) {
        this.observable = observable;
    }

    public String getLogData() {
        return logData;
    } 

     @Override
    public void update() {
        System.out.println("Notification Channels : Notification received and logged.");
        this.logData = observable.getNotificationContent();
        System.out.println("Notification Content: " + logData);
        sendNotification(logData);
        return;
    }

    public abstract boolean sendNotification(String message);
}
