/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.domain.service;

import java.time.LocalDateTime;

import com.bookandgo.reservation.domain.exceptions.BusinessException;
import com.bookandgo.reservation.domain.model.ApplicablePrice;

/**
 * Interface to define operations over {@link ApplicablePrice} model
 * 
 * @author manuelcobos66@gmail.com
 *
 */
public interface ApplicablePriceService {

	/**
	 * Search for an applicable price for a concrete product in a concrete date
	 * 
	 * @param brandId   the brand id
	 * @param productId the product Id
	 * @param date      the date with which to search for the applicable price
	 * @return the {@link ApplicablePrice}
	 * @throws BusinessException if an {@link ApplicablePrice} can't be
	 *                                   resolved according to
	 *                                   {@link BusinessException#getErrorCode()}:
	 * 
	 */
	ApplicablePrice find(Long brandId, Long productId, LocalDateTime date) throws BusinessException;

}
