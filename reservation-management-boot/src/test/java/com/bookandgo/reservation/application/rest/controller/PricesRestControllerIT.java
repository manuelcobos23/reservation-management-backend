/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.application.rest.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Integration test for {@link PricesRestController}
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@SpringBootTest
@ActiveProfiles("test")
@WebAppConfiguration
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class PricesRestControllerIT {

	public static final String GET_APPLICABLE_PRICES_BY_PRODUCT_PATH = "/prices/{brandId}/priceList/{productId}?date={date}";
	public static final String DEFAULT_AUTHORIZATION_HEADER = "Basic Auth";
	public static final Long DEFAULT_BRAND_ID = 1L;
	public static final Long DEFAULT_PRODUCT_ID = 35455L;
	public static final Float DEFAULT_SELECTED_PRICE = 35.50f;
	public static final LocalDateTime DEFAULT_DATE = LocalDateTime.parse("2020-06-14 12:00:00",
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

	private MockMvc mockMvc;

	private final WebApplicationContext applicationContext;

	@Value("${app.api-rest.base-path}")
	private String basePath;

	public PricesRestControllerIT(WebApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	void getApplicablePricesByProduct_WhenApplicablePricesCanBeCalculated_ShouldReturn200OkWithValidData()
			throws Exception {
		// given

		// when, then
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(basePath + GET_APPLICABLE_PRICES_BY_PRODUCT_PATH,
				DEFAULT_BRAND_ID, DEFAULT_PRODUCT_ID, DEFAULT_DATE).header(HttpHeaders.AUTHORIZATION, DEFAULT_AUTHORIZATION_HEADER);

		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpectAll(jsonPath("$.brandId", is(DEFAULT_BRAND_ID), Long.class),
						jsonPath("$.productId", is(DEFAULT_PRODUCT_ID), Long.class),
						jsonPath("$.price", is(DEFAULT_SELECTED_PRICE), Float.class))
				.andDo(print());
	}

	// TODO: Complete tests
}
