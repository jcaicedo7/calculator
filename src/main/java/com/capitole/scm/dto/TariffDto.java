package com.capitole.scm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class TariffDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long productId;
    private Long brandId;
    private Long tariffId;
    private Timestamp tariffStartDate;
    private Timestamp tariffEndDate;    
    private BigDecimal tariffPrice;
    
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getTariffId() {
		return tariffId;
	}
	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}
	public Timestamp getTariffStartDate() {
		return tariffStartDate;
	}
	public void setTariffStartDate(Timestamp tariffStartDate) {
		this.tariffStartDate = tariffStartDate;
	}
	public Timestamp getTariffEndDate() {
		return tariffEndDate;
	}
	public void setTariffEndDate(Timestamp tariffEndDate) {
		this.tariffEndDate = tariffEndDate;
	}
	public BigDecimal getTariffPrice() {
		return tariffPrice;
	}
	public void setTariffPrice(BigDecimal tariffPrice) {
		this.tariffPrice = tariffPrice;
	}       
}
