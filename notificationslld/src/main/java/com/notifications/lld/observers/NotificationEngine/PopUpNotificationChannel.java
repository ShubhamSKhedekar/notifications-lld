package com.notifications.lld.observers.NotificationEngine;

import com.notifications.lld.observable.IObservable;

public class PopUpNotificationChannel extends NotificationChannel {

    public PopUpNotificationChannel(IObservable observable) {
        super(observable);
    }

    @Override
    public boolean sendNotification(String message) {
        // Simulate sending Pop-Up notification
        System.out.println();
        System.out.println("Pop-Up Notification displayed with message: \n" + message);
        System.out.println();
        return true;
    }

}
