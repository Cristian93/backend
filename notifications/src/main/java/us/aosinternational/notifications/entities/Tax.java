/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notifications.entities;

/**
 *
 * @author Assist 02
 */
public class Tax {

    private String id;
    private String secretariat;
    private long amount;

    public Tax() {

    }

    public Tax(String id, String secretariat, long amount) {
        super();
        this.id = id;
        this.secretariat = secretariat;
        this.amount = amount;
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
