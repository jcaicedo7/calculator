package com.capitole.scm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capitole.scm.model.Tariff;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {

	  @Query(value = "select PRODUCT_ID,BRAND_ID,TARIFF_ID,TARIFF_PRICE,TARIFF_START_DATE,TARIFF_END_DATE,TARIFF_CURR,TARIFF_PRIORITY  "
	  		+ "from TARIFF  "
	  		+ "where  PRODUCT_ID = ?1 and BRAND_ID = ?2 and  PARSEDATETIME(?3,'dd-MM-yyyy HH:mm:ss') "
	  		+ "between TARIFF_START_DATE and TARIFF_END_DATE "
	  		+ "order by TARIFF_PRIORITY ASC", nativeQuery = true)
	  List<Tariff> findByDateHour(Long productId, Long brandId, String date);
	  
}