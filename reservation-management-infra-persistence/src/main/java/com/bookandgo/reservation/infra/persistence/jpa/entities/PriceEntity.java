/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.persistence.jpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents PRICES table in DDBB
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@Entity
@Table(name = "PRICES")
@SequenceGenerator(name = "SQ_PRICES", sequenceName = "SQ_PRICES", allocationSize = 1)
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PriceEntity extends GenericEntity<Long> {

	private static final long serialVersionUID = -7748708067287506269L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRICES")
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "brand_id")
	private BrandEntity brand;

	@Column(name = "product_id", nullable = false)
	private Long productId;

	@Column(name = "price_list", nullable = false)
	private Integer priceList;

	@Column(name = "start_date", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDateTime endDate;

	@Column(name = "priority", nullable = false)
	private Integer priority;

	@Column(name = "price", nullable = false)
	private Float price;

	@Column(name = "curr", nullable = false, length = 3)
	private String curr;

}
