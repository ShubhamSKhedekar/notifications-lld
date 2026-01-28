package com.notifications.lld;

import com.notifications.lld.decorator.INotificationDecorator;
import com.notifications.lld.services.NotificationService;

public class App 
{
    public static void main( String[] args )
    {
        //java -cp target/notificationslld-1.0-SNAPSHOT.jar com.notifications.lld.App
        System.out.println( "Hello World! Learn Notifications LLD" );
        System.out.println("----------------------------------------" );

        // Initialize Notification Service
        System.out.println("Starting Notification Service...");
        NotificationService notificationService = NotificationService.getInstance();
        System.out.println("----------------------------------------" );

        System.out.println("Creating Notification...");
        // 1. HTML Notification Body
        // Note: We use \" to escape double quotes inside the HTML attributes.
        String htmlBody = "<html>\n"
                        + "<body>\n"
                        + "<h3 style=\"color: #2E86C1;\">System Update</h3>\n"
                        + "<p>Your upload was <b>successful</b>.</p>\n"
                        + "<p>Click <a href=\"https://example.com\">here</a> to view details.</p>\n"
                        + "</body>\n"
                        + "</html>\n";

        // 2. Simple Text Notification Body
        // Note: We use \n to create a new line.
        String textBody = "System Update\n"
                        + "Your upload was successful.\n"
                        + "Visit https://example.com to view details.";

        // Printing to verify
        System.out.println("--- HTML Version ---");
        System.out.println(htmlBody);
        System.out.println("\n--- Text Version ---");
        System.out.println(textBody);

        INotificationDecorator decorator1 = notificationService.createNotification(htmlBody, "email", "signature");
        System.out.println("----------------------------------------" );

        System.out.println("Notification Service is running...");
        System.out.println("----------------------------------------" );

        boolean triggered = notificationService.triggerNotification(decorator1);
        System.out.println("Notification triggered: " + triggered);
        System.out.println("----------------------------------------" );

        System.out.println("Completed Notification Service execution.");
    }
}
