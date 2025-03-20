package com.bookandgo.reservation.infra.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Data structure containing the applicable price for a concrete date
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@Schema(name = "ApplicablePrice", description = "Data structure containing the applicable price for a concrete date")
@JsonTypeName("ApplicablePrice")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-20T10:35:07.434864600+01:00[Europe/Madrid]")
public class ApplicablePriceDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("productId")
  private Long productId;

  @JsonProperty("brandId")
  private Long brandId;

  @JsonProperty("priceList")
  private Integer priceList;

  @JsonProperty("startDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime startDate;

  @JsonProperty("endDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime endDate;

  @JsonProperty("price")
  private Float price;

  public ApplicablePriceDTO productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  
  @Schema(name = "productId", required = false)
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public ApplicablePriceDTO brandId(Long brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Get brandId
   * @return brandId
  */
  
  @Schema(name = "brandId", required = false)
  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public ApplicablePriceDTO priceList(Integer priceList) {
    this.priceList = priceList;
    return this;
  }

  /**
   * Get priceList
   * @return priceList
  */
  
  @Schema(name = "priceList", required = false)
  public Integer getPriceList() {
    return priceList;
  }

  public void setPriceList(Integer priceList) {
    this.priceList = priceList;
  }

  public ApplicablePriceDTO startDate(LocalDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Creation date and time
   * @return startDate
  */
  @Valid 
  @Schema(name = "startDate", example = "2020-07-16T16:55:42Z", description = "Creation date and time", required = false)
  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public ApplicablePriceDTO endDate(LocalDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Creation date and time
   * @return endDate
  */
  @Valid 
  @Schema(name = "endDate", example = "2020-07-16T16:55:42Z", description = "Creation date and time", required = false)
  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public ApplicablePriceDTO price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  
  @Schema(name = "price", required = false)
  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicablePriceDTO applicablePrice = (ApplicablePriceDTO) o;
    return Objects.equals(this.productId, applicablePrice.productId) &&
        Objects.equals(this.brandId, applicablePrice.brandId) &&
        Objects.equals(this.priceList, applicablePrice.priceList) &&
        Objects.equals(this.startDate, applicablePrice.startDate) &&
        Objects.equals(this.endDate, applicablePrice.endDate) &&
        Objects.equals(this.price, applicablePrice.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, priceList, startDate, endDate, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicablePriceDTO {\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

