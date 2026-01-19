package com.notifications.lld.notification;

public class SimpleHTMLNotification implements INotification{
    public String htmlText;
    
    public SimpleHTMLNotification(String htmlText){
        this.htmlText=htmlText;
    }

    @Override
    public String getContent() {
        try {
            return this.htmlText;
        } catch (Exception e) {
            System.out.println("Exception in SimpleHTMLNotification: " + e.getMessage());
            e.printStackTrace();
            throw new UnsupportedOperationException("Unimplemented method 'getContent'");
        }
    }

}
