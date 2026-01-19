package com.notifications.lld.services;


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

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public INotificationDecorator createNotification(String content, String notificationContentType, String decoratorType) {
        // Logic to create and send notification
        System.out.println("Notification creation with content: " + content);

        //setting notification content type
        if(notificationContentType.equalsIgnoreCase("email")) {
            System.out.println("Creating SimpleHTML Notification");
            this.notificationContentType = new SimpleHTMLNotification(content);
        } else if(notificationContentType.equalsIgnoreCase("sms")) {
            System.out.println("Creating SimpleText Notification");
            this.notificationContentType = new SimpleTextNotification(content);
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

        return this.decorator;
    }

    public boolean processNotification(INotification notification) {
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
