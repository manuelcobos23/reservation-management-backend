/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.domain.model;

import java.time.LocalDateTime;

import com.bookandgo.reservation.domain.enums.CurrencyEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represent a price applicable for a concrete produt/date
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicablePrice {
	/** brand */
	private Brand brand;

	/** price list */
	private Integer priceList;
	
	/** productId */
	private Long productId;
	
	/** start date */
	private LocalDateTime startDate;
	
	/** start date */
	private LocalDateTime endDate;
	
	/** priority to apply in case of several prices */
	private Integer priority;
	
	/** Price */
	private Float price;
	
	/** Currency of the price*/
	private CurrencyEnum currency;
}
