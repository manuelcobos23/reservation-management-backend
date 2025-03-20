/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.bookandgo.reservation.domain.model.Brand;
import com.bookandgo.reservation.infra.persistence.jpa.entities.BrandEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface JpaBrandMapper extends JpaGenericMapper<BrandEntity, Brand> {

	JpaBrandMapper INSTANCE = Mappers.getMapper(JpaBrandMapper.class);

	@Override
	Brand toDomainModel(BrandEntity brandEntity);

}