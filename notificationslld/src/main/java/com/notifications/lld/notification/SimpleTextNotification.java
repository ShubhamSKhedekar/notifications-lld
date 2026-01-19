package com.notifications.lld.notification;

public class SimpleTextNotification implements INotification{

    public String text;
    
    public SimpleTextNotification(String text){
        this.text=text;
    }

    @Override
    public String getContent() {
        try {
            return this.text;
        } catch (Exception e) {
            System.out.println("Exception in SimpleTextNotification: " + e.getMessage());
            e.printStackTrace();  
            throw new UnsupportedOperationException("Unimplemented method 'getContent'");
        }
    }


}
