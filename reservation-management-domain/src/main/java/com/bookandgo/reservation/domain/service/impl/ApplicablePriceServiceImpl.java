/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.domain.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookandgo.reservation.domain.enums.ErrorCode;
import com.bookandgo.reservation.domain.exceptions.BusinessException;
import com.bookandgo.reservation.domain.model.ApplicablePrice;
import com.bookandgo.reservation.domain.repository.ApplicablePriceRepository;
import com.bookandgo.reservation.domain.service.ApplicablePriceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Concrete implementation for {@link ApplicablePriceService}
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@RequiredArgsConstructor
@Slf4j
public class ApplicablePriceServiceImpl implements ApplicablePriceService {
	/** The repository */
	private final ApplicablePriceRepository applicablePriceRepository;

	/**
	 * {@inheritDoc}
	 */
    @Override
	public ApplicablePrice find(Long brandId, Long productId, LocalDateTime date) throws BusinessException {
		log.debug("find ApplicablePrice by brandId:{}, productId:{}, date: {}", brandId, productId, date);

		List<ApplicablePrice> priceList = this.applicablePriceRepository.searchPrices(brandId, productId, date);

		// Generate Stream with prices that applies in that date
		// And gets the list of prices with the max priority
		Optional<Entry<Integer, List<ApplicablePrice>>> applicablePriceOptional = Optional.ofNullable(priceList)
				.orElse(Collections.emptyList()).stream().collect(Collectors.groupingBy(ApplicablePrice::getPriority))
				.entrySet().stream().max(Map.Entry.comparingByKey());

		// Gets the list of prices with the max priority

		// Check errors: Not exits price
		// Check errors: Several prices with same priority
		List<ApplicablePrice> applicablePriceList = applicablePriceOptional
				.orElseThrow(() -> new BusinessException(ErrorCode.NOT_EXIST)).getValue();
		if (applicablePriceList.size() > 1) {
			throw new BusinessException(ErrorCode.UNDETERMINED_PRICE);
		}

		// Return the price that finally applies
		return applicablePriceList.get(0);
	}

}