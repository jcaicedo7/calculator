package com.appgate.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appgate.calculator.dto.Calculation;
import com.appgate.calculator.facade.ICalculateFacade;



public class CalculatorServiceTest extends CalculatorApplicationTests{

    @Autowired
    ICalculateFacade service;

	/** Prueba Adicion**/			
	@Test
	public void additionTest() throws Exception {	
		double value = 18.0;
		Calculation resultAddition = service.processCalculate("3,6,9","Addition");
		assertEquals(value,resultAddition.getResult().doubleValue(),0);
	}

	/** Prueba Sustraccion**/			
	@Test
	public void sustractionTest() throws Exception {	
		double value = 7.5;
		Calculation resultAddition = service.processCalculate("20,10,2.5","Sustraction");
		assertEquals(value,resultAddition.getResult().doubleValue(),0);
	}

	/** Prueba Multiplication**/			
	@Test
	public void multiplicationTest() throws Exception {	
		double value = 600.0;
		Calculation resultAddition = service.processCalculate("2,3,100","Multiplication");
		assertEquals(value,resultAddition.getResult().doubleValue(),0);
	}

	/** Prueba Division**/			
	@Test
	public void divisionTest() throws Exception {	
		double value = 3.0;
		Calculation resultAddition = service.processCalculate("18,3,2","Division");
		assertEquals(value,resultAddition.getResult().doubleValue(),0);
	}

	/** Prueba Exponential**/			
	@Test
	public void exponentialTest() throws Exception {	
		double value = 16.0;
		Calculation resultAddition = service.processCalculate("2,2,2","Exponential");
		assertEquals(value,resultAddition.getResult().doubleValue(),0);
	}
		

}
