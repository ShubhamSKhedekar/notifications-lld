package com.notifications.lld.observers;

import com.notifications.lld.observable.IObservable;

public class Logger implements IObserver {
    
    private IObservable observable;
    private String logData;

    public Logger(IObservable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Logger Observer: Notification received and logged.");
        this.logData = observable.getNotificationContent();
        System.out.println("Notification Content: " + logData);
        return;
    }
}
