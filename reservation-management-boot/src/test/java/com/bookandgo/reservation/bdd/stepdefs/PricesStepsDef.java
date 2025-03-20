/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.bdd.stepdefs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bookandgo.reservation.bdd.CucumberSpringConfiguration;
import com.bookandgo.reservation.infra.api.dto.ApplicablePriceDTO;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

/**
 * Cucumber step definitions for Prices feature
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@CucumberContextConfiguration
public class PricesStepsDef extends CucumberSpringConfiguration {
    public static final String GET_APPLICABLE_PRICES_BY_PRODUCT_PATH = "/prices/{brandId}/priceList/{productId}?date={date}";

    private ResponseEntity<?> response;

    @ParameterType(".*")
    public LocalDateTime date(String dateString) {
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
    }

    @Before()
    public void setupBasicAuth() {
        headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/json");

    }

    @Given("I perform basic authorization")
    public void performBasicAuthorization() {
        headers.setBasicAuth(user, password);
    }

    @When("I request to get applicable price for concrete {long} and {long} in a specific {date}")
    public void theUserRequestToApplicablePrice(long brandId, long productId, LocalDateTime date) {
        headers.set(HttpHeaders.ACCEPT, "application/json");

        response = testRestTemplate.exchange(basePath + GET_APPLICABLE_PRICES_BY_PRODUCT_PATH, HttpMethod.GET,
                new HttpEntity<Object>(headers), ApplicablePriceDTO.class, brandId, productId, date);
    }

    @Then("I get the applicable {float}")
    public void theUserGetsValidApplicablePrice(float price) {
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(price, ((ApplicablePriceDTO) response.getBody()).getPrice());

    }
}
