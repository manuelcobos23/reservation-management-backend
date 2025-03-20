/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.api.rest.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bookandgo.reservation.infra.api.ApplicationTestProvider;
import com.bookandgo.reservation.domain.model.ApplicablePrice;
import com.bookandgo.reservation.infra.api.dto.ApplicablePriceDTO;

/**
 * Test class for {@link ApplicablePriceMapper}
 * 
 * @author manuelcobos66@gmail.com
 *
 */
public class ApplicablePriceMapperTest {

	private ApplicablePriceMapper instance;

	@BeforeEach
	public void setUp() throws Exception {
		this.instance = ApplicablePriceMapper.INSTANCE;
	}

	@Test
	public void toDomainModel_when_defaultCaseShouldOk() {
		// given
		ApplicablePrice applicablePrice = ApplicationTestProvider.buildPojo(ApplicablePrice.class);

		// when
		ApplicablePriceDTO applicablePriceDto = this.instance.toDTO(applicablePrice);

		// then
		assertThat(applicablePriceDto.getBrandId()).isEqualTo(applicablePrice.getBrand().getId());
		assertThat(applicablePriceDto.getPrice()).isEqualTo(applicablePrice.getPrice());
		assertThat(applicablePriceDto.getEndDate()).isEqualTo(applicablePrice.getEndDate());
		assertThat(applicablePriceDto.getPriceList()).isEqualTo(applicablePrice.getPriceList());
		assertThat(applicablePriceDto.getProductId()).isEqualTo(applicablePrice.getProductId());
		assertThat(applicablePriceDto.getStartDate()).isEqualTo(applicablePrice.getStartDate());
	}

}
