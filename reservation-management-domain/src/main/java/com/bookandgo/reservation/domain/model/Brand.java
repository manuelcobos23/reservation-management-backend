/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represent a Brand
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
	/** Brand's id */
	private Long id;

	/** Brand's name */
	private String name;

	/** Brand's description */
	private String description;
}
