package com.notifications.lld.observable;

import java.util.*;

import com.notifications.lld.notification.INotification;
import com.notifications.lld.observers.IObserver;

public class NotificationObservable implements IObservable {

    private List<IObserver> observers = new ArrayList<>();
    private INotification notification;

    @Override
    public boolean notifyObservers() {
        System.out.println();
        try {
            for (IObserver observer : observers) {  
                System.out.println("Notifying observer: " + observer.getClass().getSimpleName());
                observer.update();
                System.out.println();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error notifying observers: " + e.getMessage());
            e.printStackTrace();
        }
        return false; 
    }

    @Override
    public void addObserver(IObserver observer) {
        try {
            observers.add(observer);
        } catch (Exception e) {
            System.out.println("Error adding observer: " + e.getMessage());
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void removeObserver(IObserver observer) {
        try {
            observers.remove(observer);
        } catch (Exception e) {
            System.out.println("Error removing observer: " + e.getMessage());
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void setNotification(INotification notification) {
        try {
            this.notification = notification;
            boolean notified = notifyObservers();
            if(!notified){
                System.out.println("Failed to notify observers after setting notification.");
            }
            else System.out.println("Observers notified successfully after setting notification.");

        } catch (Exception e) {
            System.out.println("Error setting notification: " + e.getMessage());
            e.printStackTrace();
        }
        return;
    }

    @Override
    public String getNotificationContent() {
       return this.notification.getContent();
    }

    // @Override
    // public INotification getNotification() {
    //     return this.notification;
    // }
    
}
