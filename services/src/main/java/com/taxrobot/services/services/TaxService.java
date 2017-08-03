package com.taxrobot.services.services;

import com.taxrobot.services.dto.DetailTaxDto;
import com.taxrobot.services.dto.TaxDto;
import com.taxrobot.services.dto.VehicleDto;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class TaxService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TaxService.class);

    public List<TaxDto> getTax(List<String> licensesList) {
        String url = "http://recursosweb.shd.gov.co/ConsultaPagos/resources/servicios/relacionPagos";
        List<TaxDto> taxList = new ArrayList<>();

        licensesList.stream().forEach(licensePlate -> {
            URI targetUrl = UriComponentsBuilder.fromUriString(url)
                    .queryParam("impuesto", "3")
                    .queryParam("objeto", licensePlate)
                    .build().encode().toUri();

            TaxDto taxDto = null;
            try {
                taxDto = new RestTemplate().getForObject(targetUrl, TaxDto.class);
            }catch (RestClientException e){
                LOGGER.error(e.getClass() + " - " + e.getMessage());
            }

            if (taxDto.getDetailTaxDtos() != null && !taxDto.getDetailTaxDtos().isEmpty()) {
                taxDto.getDetailTaxDtos().stream().forEach(detailTaxDto -> detailTaxDto.setTaxValue(generateValue(new Random())));
                taxList.add(taxDto);
            } else {
                LOGGER.error("Placa " + licensePlate + " no posee información");
            }
        });
        return taxList;
    }


    public Double getValueTax(String idTaxSupport) {

        String url = "http://recursosweb.shd.gov.co/Tareaps/TaxPayment.jsp";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> request = new HttpEntity<>("idSoporte=" + idTaxSupport + "&valor=", headers);
        ResponseEntity<String> html = restTemplate.postForEntity(url, request, String.class);

        int start = html.getBody().indexOf("<input type=\"hidden\" id=\"refer\" value=\"") + 39;
        int end = html.getBody().indexOf("\"", start);
        long id = Long.parseLong(html.getBody().substring(start, end));

        url = "http://recursosweb.shd.gov.co/Tareaps/resources/presentacion/" + id;
        DetailTaxDto detailTaxDto = restTemplate.getForObject(url, DetailTaxDto.class);
        return detailTaxDto.getTaxValue();
    }

    public double generateValue(Random number){
        int low = 100000;
        int high = 500500;
        int result = number.nextInt(high-low) + low;
        return result;
    }
}
