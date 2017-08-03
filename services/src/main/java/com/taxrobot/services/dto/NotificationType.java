/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxrobot.services.dto;

/**
 *
 * @author Cristian David Franco Garcia
 */
public class NotificationType {

    private boolean email;
    private boolean SMS;

    public NotificationType() {

    }

    public NotificationType(boolean email, boolean SMS) {
        super();
        this.email = email;
        this.SMS = SMS;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isSMS() {
        return SMS;
    }

    public void setSMS(boolean SMS) {
        this.SMS = SMS;
    }

}