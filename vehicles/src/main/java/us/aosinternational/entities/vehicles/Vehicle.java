/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.entities.vehicles;

import us.aosinternational.entities.customers.Customer;

/**
 *
 * @author Cristian David Franco Garcia
 */
public class Vehicle {

    private String licensePlate;

    private String financeSecretariat;

    private Customer customer;

    public Vehicle() {

    }

    public Vehicle(String licensePlate, String financeSecretariat, Customer customer) {
        super();
        this.licensePlate = licensePlate;
        this.financeSecretariat = financeSecretariat;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
