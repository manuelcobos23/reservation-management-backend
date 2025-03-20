/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookandgo.reservation.domain.DomainTestProvider;
import com.bookandgo.reservation.domain.enums.ErrorCode;
import com.bookandgo.reservation.domain.exceptions.BusinessException;
import com.bookandgo.reservation.domain.model.ApplicablePrice;
import com.bookandgo.reservation.domain.repository.ApplicablePriceRepository;
import com.bookandgo.reservation.domain.service.impl.ApplicablePriceServiceImpl;

/**
 * Test class for {@link ApplicablePriceService} implementation
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@ExtendWith(MockitoExtension.class)
class ApplicablePriceServiceTest {
	/** Test constants */
	private static final Long DEFAULT_BRAND_ID = 1l;
	private static final Long DEFAULT_PRODUCT_ID = 100l;
	private static final LocalDateTime DEFAULT_DATE = LocalDateTime.now();

	/** Insance to test */
	private ApplicablePriceService instance;

	@Mock
	private ApplicablePriceRepository mockApplicablePriceRepository;

	@BeforeEach
	void setUp() {
		instance = new ApplicablePriceServiceImpl(mockApplicablePriceRepository);
	}

	@Test
	void searchPrices_whenValidPrice_shouldReturnTheValidData() {
		// given
		
		List<ApplicablePrice> mockedPriceList = DomainTestProvider.buildPojoList(ApplicablePrice.class, 5);
		// Configure possible list of price: Index 1 will must be the returned value with max 3 priority
		Integer maxIndex = 1;
		mockedPriceList.get(0).setPriority(1);
		mockedPriceList.get(maxIndex).setPriority(3);
		mockedPriceList.get(2).setPriority(2);
		mockedPriceList.get(3).setPriority(2);
		mockedPriceList.get(4).setPriority(0);
		
		when(mockApplicablePriceRepository.searchPrices(DEFAULT_BRAND_ID, DEFAULT_PRODUCT_ID, DEFAULT_DATE))
				.thenReturn(mockedPriceList);

		// when
		final ApplicablePrice price = instance.find(DEFAULT_BRAND_ID, DEFAULT_PRODUCT_ID, DEFAULT_DATE);

		// then
		assertNotNull(price);
		assertThat(price).usingRecursiveComparison().isEqualTo(mockedPriceList.get(maxIndex)).ignoringFields();

		verify(mockApplicablePriceRepository, times(1)).searchPrices(DEFAULT_BRAND_ID, DEFAULT_PRODUCT_ID, DEFAULT_DATE);

	}

	@Test
	void find_whenPriceNotExist_shouldThrowsBusinessExceptionWithCodeNOT_EXIST() {
		// given
		List<ApplicablePrice> mockedPriceList = DomainTestProvider.buildPojoList(ApplicablePrice.class, 0);
		when(mockApplicablePriceRepository.searchPrices(DEFAULT_BRAND_ID, DEFAULT_PRODUCT_ID, DEFAULT_DATE))
				.thenReturn(mockedPriceList);

		// when
		BusinessException exception = assertThrows(BusinessException.class,
				() -> instance.find(DEFAULT_BRAND_ID, DEFAULT_PRODUCT_ID, DEFAULT_DATE));

		// then
		assertThat(exception.getErrorCode()).isEqualTo(ErrorCode.NOT_EXIST);

	}

	@Test
	void find_whenExistSeveralPricesWithMaxPriority_shouldThrowsBusinessExceptionWithCodeNOT_EXIST() {
		// given
		List<ApplicablePrice> mockedPriceList = DomainTestProvider.buildPojoList(ApplicablePrice.class, 5);
		// Configure possible list of price: two elements with 3 max priority
		mockedPriceList.get(0).setPriority(1);
		mockedPriceList.get(1).setPriority(0);
		mockedPriceList.get(2).setPriority(3);
		mockedPriceList.get(3).setPriority(2);
		mockedPriceList.get(4).setPriority(3);
				
		when(mockApplicablePriceRepository.searchPrices(DEFAULT_BRAND_ID, DEFAULT_PRODUCT_ID, DEFAULT_DATE))
				.thenReturn(mockedPriceList);

		// when
		BusinessException exception = assertThrows(BusinessException.class,
				() -> instance.find(DEFAULT_BRAND_ID, DEFAULT_PRODUCT_ID, DEFAULT_DATE));

		// then
		assertThat(exception.getErrorCode()).isEqualTo(ErrorCode.UNDETERMINED_PRICE);

	}

}