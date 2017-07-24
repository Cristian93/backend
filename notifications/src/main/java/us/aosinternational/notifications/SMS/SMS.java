/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notifications.SMS;

/**
 *
 * @author Cristian David Franco Garcia
 */
public class SMS {

    private String to;
    private String text;

    public SMS() {

    }

    public SMS(String to, String text) {
        super();
        this.to = to;
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
