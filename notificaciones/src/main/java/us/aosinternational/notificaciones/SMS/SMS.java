/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notificaciones.SMS;

/**
 *
 * @author Cristian David Franco Garcia
 */
public class SMS {

    private String to;
    private String from;
    private String text;

    public SMS() {

    }

    public SMS(String to, String from, String text) {
        super();
        this.to = to;
        this.from = from;
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
