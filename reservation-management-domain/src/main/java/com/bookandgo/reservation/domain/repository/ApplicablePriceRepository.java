/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.bookandgo.reservation.domain.model.ApplicablePrice;

/**
 * Defines operations to manage {@link ApplicablePrice} model in a repository
 * 
 * @author manuelcobos66@gmail.com
 *
 */
public interface ApplicablePriceRepository {
	/**
	 * Gets the applicable price {@link ApplicablePrice} list for a concrete product
	 * of a Brand in a specified date
	 * 
	 * @param brandId   the brand of the product
	 * @param productId the product
	 * @param date      the date to use in the search
	 * @return a list of {@link ApplicablePrice} that apply in this date
	 */
	List<ApplicablePrice> searchPrices(Long brandId, Long productId, LocalDateTime date);
}
