/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.bookandgo.reservation.domain.model.ApplicablePrice;
import com.bookandgo.reservation.infra.persistence.jpa.entities.PriceEntity;

/**
 * Mapping between entity infra model and domain model
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@Mapper(componentModel = "spring", uses = { JpaBrandMapper.class }, unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JpaPriceMapper extends JpaGenericMapper<PriceEntity, ApplicablePrice> {
	
	JpaPriceMapper INSTANCE = Mappers.getMapper(JpaPriceMapper.class);

	@Override
	@Mapping(target = "currency", expression = "java(com.bookandgo.reservation.domain.enums.CurrencyEnum.valueOfByCode(priceEntity.getCurr()))")
	ApplicablePrice toDomainModel(PriceEntity priceEntity);

}