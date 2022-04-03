package com.capitole.scm.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="TARIFF")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tariffId;
    
    @Column(name="PRODUCT_ID")
    private Long productId;
    
    @Column(name="BRAND_ID")
    private Long brandId;
    
    @Column(name="TARIFF_START_DATE")
    private Timestamp tariffStartDate;
    
    @Column(name="TARIFF_END_DATE")
    private Timestamp tariffEndDate;
    
    @Column(name="TARIFF_PRICE")
    private BigDecimal tariffPrice;
    
    @Column(name="TARIFF_CURR")
    private String tariffCurr;
    
    @Column(name="TARIFF_PRIORITY")
    @Min(1)
    @Max(9)
    private Integer tariffPriority;

	public Long getTariffId() {
		return tariffId;
	}

	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	public Long getProductId() {
		return productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getTariffCurr() {
		return tariffCurr;
	}

	public void setTariffCurr(String tariffCurr) {
		this.tariffCurr = tariffCurr;
	}

	public Integer getTariffPriority() {
		return tariffPriority;
	}

	public void setTariffPriority(Integer tariffPriority) {
		this.tariffPriority = tariffPriority;
	}
    

}