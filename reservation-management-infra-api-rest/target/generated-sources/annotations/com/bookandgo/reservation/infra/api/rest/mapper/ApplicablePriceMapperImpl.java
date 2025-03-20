package com.bookandgo.reservation.infra.api.rest.mapper;

import com.bookandgo.reservation.domain.model.ApplicablePrice;
import com.bookandgo.reservation.domain.model.Brand;
import com.bookandgo.reservation.infra.api.dto.ApplicablePriceDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-20T10:35:05+0100",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ApplicablePriceMapperImpl implements ApplicablePriceMapper {

    @Override
    public ApplicablePrice toModel(ApplicablePriceDTO t) {
        if ( t == null ) {
            return null;
        }

        ApplicablePrice applicablePrice = new ApplicablePrice();

        applicablePrice.setEndDate( t.getEndDate() );
        applicablePrice.setPrice( t.getPrice() );
        applicablePrice.setPriceList( t.getPriceList() );
        applicablePrice.setProductId( t.getProductId() );
        applicablePrice.setStartDate( t.getStartDate() );

        return applicablePrice;
    }

    @Override
    public List<ApplicablePriceDTO> toDTOList(List<ApplicablePrice> sList) {
        if ( sList == null ) {
            return null;
        }

        List<ApplicablePriceDTO> list = new ArrayList<ApplicablePriceDTO>( sList.size() );
        for ( ApplicablePrice applicablePrice : sList ) {
            list.add( toDTO( applicablePrice ) );
        }

        return list;
    }

    @Override
    public List<ApplicablePrice> toModelList(List<ApplicablePriceDTO> tList) {
        if ( tList == null ) {
            return null;
        }

        List<ApplicablePrice> list = new ArrayList<ApplicablePrice>( tList.size() );
        for ( ApplicablePriceDTO applicablePriceDTO : tList ) {
            list.add( toModel( applicablePriceDTO ) );
        }

        return list;
    }

    @Override
    public ApplicablePriceDTO toDTO(ApplicablePrice priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }

        ApplicablePriceDTO.ApplicablePriceDTOBuilder applicablePriceDTO = ApplicablePriceDTO.builder();

        applicablePriceDTO.brandId( priceEntityBrandId( priceEntity ) );
        applicablePriceDTO.endDate( priceEntity.getEndDate() );
        applicablePriceDTO.price( priceEntity.getPrice() );
        applicablePriceDTO.priceList( priceEntity.getPriceList() );
        applicablePriceDTO.productId( priceEntity.getProductId() );
        applicablePriceDTO.startDate( priceEntity.getStartDate() );

        return applicablePriceDTO.build();
    }

    private Long priceEntityBrandId(ApplicablePrice applicablePrice) {
        if ( applicablePrice == null ) {
            return null;
        }
        Brand brand = applicablePrice.getBrand();
        if ( brand == null ) {
            return null;
        }
        Long id = brand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
