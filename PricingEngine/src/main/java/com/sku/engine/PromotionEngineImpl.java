package com.sku.engine;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PromotionEngineImpl implements PromotionEngine{

	private static final Map<String, Double> items = PromotionUtil.ITEM_PRICE_SUPPLIER.get();
	private static final String IN = "IN";
	private static final String OUT = "OUT";
	private static final String COMBINED_OFFER_SEPERATOR = "&";
	
	public double calculatePriceWithApplyPromotion(List<String> selectedSkus) throws PromotionEngineException {
		double totalPrice = 100;
		
		try {
			final List<PromotionItem> promotionItems = PromotionUtil.PROMOTION_SUPPLIER.get();
			

		} catch (Exception exp) {
			exp.printStackTrace();
			throw new PromotionEngineException(exp.getMessage());
		}
		System.out.println(totalPrice);
		return totalPrice;
	}
	

}
