package com.taxrobot.services.dto;

/**
 *
 * @author Cristian David Franco Garcia
 */
public class VehicleDto {

    private String licensePlate;
    private String financeSecretariat;
    private CustomerDto customer;
    private NotificationType notificationType;

    public VehicleDto() {

    }

    public VehicleDto(String licensePlate, String financeSecretariat, CustomerDto customer, NotificationType notificationType) {
        super();
        this.licensePlate = licensePlate;
        this.financeSecretariat = financeSecretariat;
        this.customer = customer;
        this.notificationType = notificationType;
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

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

}
