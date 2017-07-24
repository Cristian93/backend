/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.aosinternational.entities.customers;

/**
 *
 * @author Cristian David Franco Garcia
 */
public class Customer {

    private String idType;
    private String idNumber;
    private String firstName;
    private String surname;
    private String email;
    private String cellPhone;

    public Customer() {

    }

    public Customer(String idType, String idNumber, String firstName, String surname, String email, String cellPhone) {
        super();
        this.idType = idType;
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.cellPhone = cellPhone;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

}
