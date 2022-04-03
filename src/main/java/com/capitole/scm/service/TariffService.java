package com.capitole.scm.service;

import java.util.Date;

import com.capitole.scm.dto.TariffDto;
import com.capitole.scm.exception.RecordNotFoundException;

public interface TariffService {
    public TariffDto getTariff(Long productId,Long brandId,Date date) throws RecordNotFoundException;

}
