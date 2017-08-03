/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.notifications.email;

import us.aosinternational.notifications.entities.Customer;
import us.aosinternational.notifications.entities.Fine;
import us.aosinternational.notifications.entities.Tax;
import us.aosinternational.notifications.entities.Vehicle;

/**
 *
 * @author Cristian David Franco Garcia
 */
public class Email {

    private Vehicle vehicle;

    private Customer customer;

    private Fine fine;

    private Tax tax;

    public Email() {

    }

    public Email(Vehicle vehicle, Customer customer, Fine fine, Tax tax) {
        super();
        this.vehicle = vehicle;
        this.customer = customer;
        this.fine = fine;
        this.tax = tax;

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

}
