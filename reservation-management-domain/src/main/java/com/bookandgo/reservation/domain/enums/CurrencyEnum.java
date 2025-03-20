/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.domain.enums;

import java.util.Arrays;

import com.bookandgo.reservation.domain.exceptions.BusinessException;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Types of supported currencies
 * 
 * @author manuelcobos66@gmail.com
 * 
 */
@Getter
@AllArgsConstructor
public enum CurrencyEnum {
	/**
	 * Euros
	 */
	EUR("EUR", "Euros");

	/**
	 * ISO currency code
	 */
	private String code;

	/**
	 * Description
	 */
	private String description;

	/**
	 * Gets a {@link CurrencyEnum} by Code
	 * 
	 * @param code
	 * @return
	 */
	public static final CurrencyEnum valueOfByCode(String code) {
		return Arrays.stream(CurrencyEnum.values()).filter(v -> v.getCode().equals(code)).findFirst()
				.orElseThrow(() -> new BusinessException(ErrorCode.UNKNOWN,
						String.format("Unknown CurrencyEnum.code: '%s'", code)));
	}
}
