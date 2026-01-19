package com.notifications.lld.observable;

import com.notifications.lld.notification.INotification;
import com.notifications.lld.observers.IObserver;

public interface IObservable {
    public boolean notifyObservers();
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void setNotification(INotification notification);
    //public INotification getNotification();
    public String getNotificationContent();
}
