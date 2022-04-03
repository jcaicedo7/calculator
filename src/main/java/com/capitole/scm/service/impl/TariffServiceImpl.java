package com.capitole.scm.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.scm.dto.TariffDto;
import com.capitole.scm.exception.RecordNotFoundException;
import com.capitole.scm.model.Tariff;
import com.capitole.scm.repository.TariffRepository;
import com.capitole.scm.service.TariffService;
import com.capitole.scm.util.ConvertDate;

@Service
public class TariffServiceImpl implements TariffService{
     
    @Autowired
    TariffRepository repository;
	@Autowired
	private ModelMapper modelMapper;	
     
    public TariffDto getTariff(Long productId,Long brandId,Date date) throws RecordNotFoundException{
    	TariffDto tariffResponse = null;
    	String dateString = ConvertDate.dateToString(date);
        List<Tariff> tariffList = repository.findByDateHour(productId,brandId,dateString); 
        if(tariffList.size() > 0) {
        	Tariff tariff = tariffList.get(0);
        	tariffResponse = mapDto(tariff);
        } 
        else {
            throw new RecordNotFoundException("No se dispone tarifa");
        }
        return tariffResponse;
    }
    
    private TariffDto mapDto(Tariff tariff) {
    	TariffDto tariffDto = modelMapper.map(tariff,TariffDto.class);
    	return tariffDto;
    }
}