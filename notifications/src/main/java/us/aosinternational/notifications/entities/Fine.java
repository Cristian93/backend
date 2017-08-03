/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notifications.entities;

import java.math.BigInteger;

/**
 *
 * @author Assist 02
 */
public class Fine {

    private String id;
    private String secretariat;
    private BigInteger infringementDate;
    private String infringementDescription;
    private long amountPayWithoutCourse;

    public Fine() {

    }

    public Fine(String id, String secretariat, BigInteger infringementDate, String infringementDescription, long amountPayWithoutCourse) {
        super();
        this.id = id;
        this.secretariat = secretariat;
        this.infringementDate = infringementDate;
        this.infringementDescription = infringementDescription;
        this.amountPayWithoutCourse = amountPayWithoutCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecretariat() {
        return secretariat;
    }

    public void setSecretariat(String secretariat) {
        this.secretariat = secretariat;
    }

    public BigInteger getInfringementDate() {
        return infringementDate;
    }

    public void setInfringementDate(BigInteger infringementDate) {
        this.infringementDate = infringementDate;
    }

    public String getInfringementDescription() {
        return infringementDescription;
    }

    public void setInfringementDescription(String infringementDescription) {
        this.infringementDescription = infringementDescription;
    }

    public long getAmountPayWithoutCourse() {
        return amountPayWithoutCourse;
    }

    public void setAmountPayWithoutCourse(long amountPayWithoutCourse) {
        this.amountPayWithoutCourse = amountPayWithoutCourse;
    }

}