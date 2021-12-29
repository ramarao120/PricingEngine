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
	@Test
	public void testScenario2()
	{
		double getTotalprice=new PromotionEngineImpl().calculatePriceWithApplyPromotion(
				Arrays.asList("A", "A", "A", "A", "A", "B", "B", "B", "B", "B", "C"));
		assertEquals(370.0, getTotalprice,0.0);
		
		
	}
	@Test
	public void testScenario3()
	{
		double getTotalprice=new PromotionEngineImpl().calculatePriceWithApplyPromotion(
				Arrays.asList("A", "A", "A", "B", "B", "B", "B", "B", "C", "D"));
		assertEquals(280.0, getTotalprice,0.0);
		
		
	}
	@Test
	public void testScenario4()
	{
		double getTotalprice=new PromotionEngineImpl().calculatePriceWithApplyPromotion(
				Arrays.asList("A", "A", "A", "B", "B", "B", "B", "B", "C", "D", "C", "D"));
		assertEquals(310.0, getTotalprice,0.0);
		
		
	}
	
}
