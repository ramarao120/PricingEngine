package com.sku.engine;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class PromotionEngineImplTest {
	
	@Test
	public void testScenario1()
	{
		double getTotalprice=new PromotionEngineImpl().calculatePriceWithApplyPromotion(
				Arrays.asList("A", "B", "C"));
		assertEquals(100.0, getTotalprice,0.0);
		
		
	}

}
