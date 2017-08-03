package com.taxrobot.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailTaxDto {

    @JsonProperty("codBanco")
    private String codeBank;

    @JsonProperty("fechaPresentacion")
    private String sDatePresent;
    private Date datePresent;

    @JsonProperty("idSoporteTributario")
    private String idTaxSupport;

    @JsonProperty("indPago")
    private String payFlag;

    @JsonProperty("nomBanco")
    private String bankName;

    @JsonProperty("nombrePeriodo")
    private String periodName;

    @JsonProperty("nroFormulario")
    private String idForm;

    @JsonProperty("nroIdRepLegal")
    private String idRepLegal;

    @JsonProperty("nroIdRevFiscal")
    private String idRevFiscal;

    @JsonProperty("nroIdentificacion")
    private String identification;

    @JsonProperty("nroReferencia")
    private String reference;

    @JsonProperty("nroTransaccion")
    private String idTransaction;

    @JsonProperty("periodo")
    private String period;

    @JsonProperty("vigencia")
    private String validity;

    @JsonProperty("valorPagar")
    private Double taxValue;

    public DetailTaxDto() {}

    public String getCodeBank() {
        return codeBank;
    }

    public void setCodeBank(String codeBank) {
        this.codeBank = codeBank;
    }

    public String getsDatePresent() {
        return sDatePresent;
    }

    public void setsDatePresent(String sDatePresent) {
        this.sDatePresent = sDatePresent;
    }

    public Date getDatePresent() {
        return parseDate(sDatePresent);
    }

    public void setDatePresent(Date datePresent) {
        this.datePresent = datePresent;
    }

    public String getIdTaxSupport() {
        return idTaxSupport;
    }

    public void setIdTaxSupport(String idTaxSupport) {
        this.idTaxSupport = idTaxSupport;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public String getIdRepLegal() {
        return idRepLegal;
    }

    public void setIdRepLegal(String idRepLegal) {
        this.idRepLegal = idRepLegal;
    }

    public String getIdRevFiscal() {
        return idRevFiscal;
    }

    public void setIdRevFiscal(String idRevFiscal) {
        this.idRevFiscal = idRevFiscal;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public Double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }

    @Override
    public String toString() {
        return "DetailTaxDto{" +
                "codeBank='" + codeBank + '\'' +
                ", sDatePresent='" + sDatePresent + '\'' +
                ", datePresent=" + datePresent +
                ", idTaxSupport='" + idTaxSupport + '\'' +
                ", payFlag='" + payFlag + '\'' +
                ", bankName='" + bankName + '\'' +
                ", periodName='" + periodName + '\'' +
                ", idForm='" + idForm + '\'' +
                ", idRepLegal='" + idRepLegal + '\'' +
                ", idRevFiscal='" + idRevFiscal + '\'' +
                ", identification='" + identification + '\'' +
                ", reference='" + reference + '\'' +
                ", idTransaction='" + idTransaction + '\'' +
                ", period='" + period + '\'' +
                ", validity='" + validity + '\'' +
                ", taxValue=" + taxValue +
                '}';
    }

    public Date parseDate(String sFecha) {
        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(sFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }
}
