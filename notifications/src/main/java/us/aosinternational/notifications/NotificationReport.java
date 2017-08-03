/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notifications;

import java.util.List;

/**
 *
 * @author Assist 02
 */
public class NotificationReport {

    private String licensePlate;

    private int emailSentNotifications;

    private int SMSSentNotifications;

    private List<Notification> notifications;
    //private int emailReceivedNotifications;  //private int SMSReceivedNotifications;

    public NotificationReport() {

    }

    public NotificationReport(String licensePlate, int emailSentNotifications, int SMSSentNotifications, List<Notification> notifications) {
        super();
        this.licensePlate = licensePlate;
        this.emailSentNotifications = emailSentNotifications;
        this.SMSSentNotifications = SMSSentNotifications;
        this.notifications = notifications;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getEmailSentNotifications() {
        return emailSentNotifications;
    }

    public void setEmailSentNotifications(int emailSentNotifications) {
        this.emailSentNotifications = emailSentNotifications;
    }

    public int getSMSSentNotifications() {
        return SMSSentNotifications;
    }

    public void setSMSSentNotifications(int SMSSentNotifications) {
        this.SMSSentNotifications = SMSSentNotifications;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

}
