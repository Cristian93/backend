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
public class Vehicle {

    private String licensePlate;

    private String financeSecretariat;

    public Vehicle() {

    }

    public Vehicle(String licensePlate, String financeSecretariat) {
        super();
        this.licensePlate = licensePlate;
        this.financeSecretariat = financeSecretariat;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getFinanceSecretariat() {
        return financeSecretariat;
    }

    public void setFinanceSecretariat(String financeSecretariat) {
        this.financeSecretariat = financeSecretariat;
    }

}
