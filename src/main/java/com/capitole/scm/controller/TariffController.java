package com.capitole.scm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.scm.dto.TariffDto;
import com.capitole.scm.exception.RecordNotFoundException;
import com.capitole.scm.service.TariffService;

@RestController
@RequestMapping("/tariff")
public class TariffController {

	@Autowired
	TariffService service;
/**
 * Servicio permite consultar la tarifa aplicada para un producto de una cadena de almacena una fecha hora determinada
 * 		
 * @param productId : Numero identificador de producto
 * @param brandId   : Numero identificador de cadena de almacen
 * @param date		: Fecha hora en la que se consulta el producto 
 * @return			: identificador producto, identificador cadena, identificador tarifa, 
 *                    fecha final hasta donde la aplica el precio y precio del producto
 * 
 */
	@GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(
			@RequestParam(required = true, value="productId") 
			@Min(value = 1, message = "El identificador del producto, no puede ser menor a 1")
			@Max(value = 99999, message = "El identificador del producto, no puede ser mayor a 5 digitos") 			
			Long productId,
			@RequestParam(required = true, value="brandId") 
			@Min(value = 1, message = "El identificador de la cadena, no puede ser menor a 1")
			@Max(value = 999, message = "El identificador de la cadena, no puede ser mayor a 3 digitos") 			
			Long brandId,
			@RequestParam (required = true, name = "datetime") 
			@DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss") 
			Date date) {
		
		ResponseEntity<?> response = null;	
		try {
			TariffDto tariffResponse = service.getTariff(productId, brandId, date);
			response = new ResponseEntity<TariffDto>(tariffResponse, HttpStatus.OK);
		}
		catch(RecordNotFoundException exc) {
			Map<String, Object> result = new HashMap<>();
			result.put("mensaje",exc.getMessage());
			response = new ResponseEntity<Map<String, Object>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return response;		
	}	
}
