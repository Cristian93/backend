/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.parametrization.entities;

/**
 *
 * @author Assist 02
 */
public class Parametrization {

    private long initialDelay;
    private long period;
    private String customerEmailSubject;
    private String customerEmailContentText;

    public Parametrization() {

    }

    public Parametrization(long initialDelay, long period, String customerEmailSubject, String customerEmailContentText) {
        super();
        this.initialDelay = initialDelay;
        this.period = period;
        this.customerEmailSubject = customerEmailSubject;
        this.customerEmailContentText = customerEmailContentText;
    }

    public long getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(long initialDelay) {
        this.initialDelay = initialDelay;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public String getCustomerEmailSubject() {
        return customerEmailSubject;
    }

    public void setCustomerEmailSubject(String customerEmailSubject) {
        this.customerEmailSubject = customerEmailSubject;
    }

    public String getCustomerEmailContentText() {
        return customerEmailContentText;
    }

    public void setCustomerEmailContentText(String customerEmailContentText) {
        this.customerEmailContentText = customerEmailContentText;
    }

}