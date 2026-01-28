package com.notifications.lld.observers.NotificationEngine;

import com.notifications.lld.observable.IObservable;

public class EmailNotificationChannel extends NotificationChannel {

    public EmailNotificationChannel(IObservable observable) {
        super(observable);
    }

    @Override
    public boolean sendNotification(String message) {
        // Simulate sending Email notification
        System.out.println();
        System.out.println("Email Notification sent with message: \n" + message);
        System.out.println();
        return true;
    }

}
