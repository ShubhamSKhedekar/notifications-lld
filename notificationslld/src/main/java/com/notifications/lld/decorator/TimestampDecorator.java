package com.notifications.lld.decorator;

import com.notifications.lld.notification.INotification;

public class TimestampDecorator implements NotificationDecorator{

    public INotification notification;
    public TimestampDecorator(INotification notification){
        this.notification=notification;
    }

    @Override
    public String getContent() {
        try {
            StringBuilder sb = new StringBuilder("");
            sb.append(this.notification.getContent());
            sb.append("\n");
            sb.append(" [Timestamp: " + System.currentTimeMillis() + "]");
            return sb.toString();
        } catch (Exception e) {
            System.out.println("Exception in TimestampDecorator: " + e.getMessage());
            e.printStackTrace();
            throw new UnsupportedOperationException("Unimplemented method 'getContent'");
        }
       
    }

}
