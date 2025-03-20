/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.api.rest.controllers;

import java.time.LocalDateTime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookandgo.reservation.infra.api.rest.mapper.ApplicablePriceMapper;
import com.bookandgo.reservation.domain.model.ApplicablePrice;
import com.bookandgo.reservation.domain.service.ApplicablePriceService;

import com.bookandgo.reservation.infra.api.dto.ApplicablePriceDTO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${app.api-rest.base-path:}")
@AllArgsConstructor
@Slf4j
public class PricesRestController implements PricesApi {

	/** Model Service */
	private ApplicablePriceService applicablePriceService;

	/** mapper */
	private ApplicablePriceMapper applicablePriceMapper;

	@Override
	public ResponseEntity<ApplicablePriceDTO> getApplicablePricesByProduct(@NotNull String authorization,
			Integer brandId, Long productId, @NotNull @Valid LocalDateTime date, String xB3TraceId, String xB3SpanId,
			String xB3ParentSpanId, String xB3Sampled) {

		log.info("Searching price list for a concrete product/date", brandId, productId, date);

		ApplicablePrice applicablePrice = applicablePriceService.find(brandId.longValue(), productId, date);

		return new ResponseEntity<>(applicablePriceMapper.toDTO(applicablePrice), HttpStatus.OK);
	}

}
