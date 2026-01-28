package com.notifications.lld.services;


import java.util.List;
import com.notifications.lld.observers.*;
import com.notifications.lld.observers.NotificationEngine.*;
import com.notifications.lld.decorator.INotificationDecorator;
import com.notifications.lld.decorator.SignatureDecorator;
import com.notifications.lld.decorator.TimestampDecorator;
import com.notifications.lld.notification.INotification;
import com.notifications.lld.notification.SimpleHTMLNotification;
import com.notifications.lld.notification.SimpleTextNotification;
import com.notifications.lld.observable.IObservable;
import com.notifications.lld.observable.NotificationObservable;

public class NotificationService {

    //SINGLETON PATTERN
    private static NotificationService instance = null;
    private INotificationDecorator decorator;
    private INotification notificationContentType;
    public IObservable observable;

    private NotificationService() {
        // private constructor to prevent instantiation
        this.observable = new NotificationObservable();
    }

    private void initializeObservers(){
        // Logic to initialize observers can be added here
        System.out.println("Initializing observers for Notification Service");
        List<IObserver> observers = List.of(
            new Logger(this.observable),
            new EmailNotificationChannel(this.observable),
            new SMSNotificationChannel(this.observable),
            new PopUpNotificationChannel(this.observable)
        );

        //subscribe observers to observable
        for(IObserver observer : observers){
            this.observable.addObserver(observer);
        }
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
            instance.initializeObservers();
        }
        return instance;
    }

    public INotificationDecorator createNotification(String content, String notificationContentType, String decoratorType) {
        // Logic to create and send notification
        System.out.println();
        System.out.println("Notification creation with content: " + content);

        //setting notification content type
        if(notificationContentType.equalsIgnoreCase("email")) {
            System.out.println("Creating SimpleHTML Notification");
            this.notificationContentType = new SimpleHTMLNotification(content);
        } else if(notificationContentType.equalsIgnoreCase("sms")) {
            System.out.println("Creating SimpleText Notification");
            this.notificationContentType = new SimpleTextNotification(content);
        }
        else{
            System.out.println("Unknown notification content type: " + notificationContentType);
            return null;
        }

        //setting decorator type
        if(decoratorType.equalsIgnoreCase("signature")) {
            System.out.println("Applying signature decorator: " + decoratorType);
            this.decorator = new SignatureDecorator(this.notificationContentType);
        }
        else if(decoratorType.equalsIgnoreCase("timestamp")) {
            System.out.println("Applying timestamp decorator: " + decoratorType);
            this.decorator = new TimestampDecorator(this.notificationContentType);
        }
        else{
            System.out.println("Unknown decorator type: " + decoratorType);
            return null;
        }

        return this.decorator;
    }

    public boolean triggerNotification(INotification notification) {
        // Logic to send notification
        try {
            System.out.println("processing notification to observers");
            this.observable.setNotification(notification);
            return true;
        } catch (Exception e) {
            System.out.println("Error processing notification: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }




}
