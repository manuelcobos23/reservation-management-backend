/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.api.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.bookandgo.reservation.infra.api.mapper.ApplicationGenericMapper;
import com.bookandgo.reservation.domain.model.ApplicablePrice;
import com.bookandgo.reservation.infra.api.dto.ApplicablePriceDTO;

/**
 * Mapping between entity infra model and domain model
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApplicablePriceMapper extends ApplicationGenericMapper<ApplicablePrice, ApplicablePriceDTO> {

	ApplicablePriceMapper INSTANCE = Mappers.getMapper(ApplicablePriceMapper.class);

	@Mapping(target = "brandId", source = "brand.id")
	@Override
	ApplicablePriceDTO toDTO(ApplicablePrice priceEntity);

}