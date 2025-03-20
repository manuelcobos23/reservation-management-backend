/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.persistence.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Reprsents BRANDS table in DDBB
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@Entity
@Table(name = "BRANDS")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BrandEntity extends GenericEntity<Long> {

	private static final long serialVersionUID = -7748708067287506269L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@Column(name = "DESCRIPTION", length = 255)
	private String description;

}
