package com.capitole.scm;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;


public class TariffApplicationTests extends ScmApplicationTests{
	private static final String ENDPOINT_API = "/tariff/query";
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/** Prueba 1: Peticion a las 10:00 del dia 14/03/2022 del producto 35455 para la brand 1 (ZARA) **/			
	@Test
	public void queryTariffToTenHourFor14() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("productId", "35455");
		params.add("brandId", "1");
		params.add("datetime", "14-03-2022T10:00:00");
				
		mockMvc.perform(get(ENDPOINT_API)
				.params(params))
				.andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))	
				.andExpect(jsonPath("$.tariffId").value(1))
				.andExpect(jsonPath("$.tariffPrice").value(50.1));
	}
	
	/** Prueba 2: Peticion a las 16:00 del dia 14/03/2022 del producto 35455 para la brand 1 (ZARA) **/			
	@Test
	public void queryTariffToSixTeenHourFor14() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("productId", "35455");
		params.add("brandId", "1");
		params.add("datetime", "14-03-2022T16:00:00");
				
		mockMvc.perform(get(ENDPOINT_API)
				.params(params))
				.andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))	
				.andExpect(jsonPath("$.tariffId").value(3))
				.andExpect(jsonPath("$.tariffPrice").value(54.3));
	}
		
	/** Prueba 3: Peticion a las 21:00 del dia 14/03/2022 del producto 35455 para la brand 1 (ZARA) **/			
	@Test
	public void queryTariffToTwentyOneHourFor14() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("productId", "35455");
		params.add("brandId", "1");
		params.add("datetime", "14-03-2022T21:00:00");
				
		mockMvc.perform(get(ENDPOINT_API)
				.params(params))
				.andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))	
				.andExpect(jsonPath("$.tariffId").value(4))
				.andExpect(jsonPath("$.tariffPrice").value(58.4));
	}	
	
	/** Prueba 4: Peticion a las 10:00 del dia 15/03/2022 del producto 35455 para la brand 1 (ZARA) **/			
	@Test
	public void queryTariffToTenHourFor15() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("productId", "35455");
		params.add("brandId", "1");
		params.add("datetime", "15-03-2022T10:00:00");
				
		mockMvc.perform(get(ENDPOINT_API)
				.params(params))
				.andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))	
				.andExpect(jsonPath("$.tariffId").value(6))
				.andExpect(jsonPath("$.tariffPrice").value(40.15));
	}	
	
	/** Prueba 5: Peticion a las 21:00 del dia 16/03/2022 del producto 35455 para la brand 1 (ZARA) **/			
	@Test
	public void queryTariffToTwentyOneHourFor16() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("productId", "35455");
		params.add("brandId", "1");
		params.add("datetime", "16-03-2022T21:00:00");
				
		mockMvc.perform(get(ENDPOINT_API)
				.params(params))
				.andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))	
				.andExpect(jsonPath("$.tariffId").value(10))
				.andExpect(jsonPath("$.tariffPrice").value(65.16));
	}	
		
}
