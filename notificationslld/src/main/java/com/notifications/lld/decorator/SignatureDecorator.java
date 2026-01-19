package com.notifications.lld.decorator;

import com.notifications.lld.notification.INotification;

public class SignatureDecorator implements NotificationDecorator{

    public INotification notification;
    
    public SignatureDecorator(INotification notification){
        this.notification=notification;
    }

    @Override
    public String getContent() {
        try {
            StringBuilder sb = new StringBuilder("");
            sb.append(this.notification.getContent());
            sb.append("\n");
            sb.append(" Shubham S. Khedekar - Signature");
            return sb.toString();
        } catch (Exception e) {
            System.out.println("Exception in SignatureDecorator: " + e.getMessage());
            e.printStackTrace();
            throw new UnsupportedOperationException("Unimplemented method 'getContent'");
        }
    }

}
