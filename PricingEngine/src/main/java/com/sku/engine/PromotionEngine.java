package com.sku.engine;

import java.util.List;

public interface PromotionEngine {
	
	public double calculatePriceWithApplyPromotion(List<String> selectedSkus) throws PromotionEngineException;

}
