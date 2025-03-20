/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.persistence.jpa.entities;

import jakarta.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericEntity<T> implements BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	// Default structure of a generic entity: To define

}