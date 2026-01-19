package com.notifications.lld.observers.NotificationEngine;

import com.notifications.lld.observable.IObservable;

public class SMSNotificationChannel extends NotificationChannel {

    public SMSNotificationChannel(IObservable observable) {
        super(observable);
    }

    @Override
    public boolean sendNotification(String message) {
        // Simulate sending SMS notification
        System.out.println("SMS Notification sent with message: " + message);
        return true;
    }

}
