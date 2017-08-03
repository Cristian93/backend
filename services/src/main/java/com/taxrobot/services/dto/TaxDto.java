package com.taxrobot.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxDto {

    @JsonProperty("dato1")
    private String licensePlate;

    @JsonProperty("dato2")
    private String startYear;

    @JsonProperty("detalles")
    private List<DetailTaxDto> detailTaxDtos;

    public TaxDto() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public List<DetailTaxDto> getDetailTaxDtos() {
        return detailTaxDtos;
    }

    public void setDetailTaxDtos(List<DetailTaxDto> detailTaxDtos) {
        this.detailTaxDtos = detailTaxDtos;
    }

    @Override
    public String toString() {
        return "TaxDto{" +
                "licensePlate='" + licensePlate + '\'' +
                ", startYear='" + startYear + '\'' +
                ", detailTaxDtos=" + detailTaxDtos +
                '}';
    }
}
