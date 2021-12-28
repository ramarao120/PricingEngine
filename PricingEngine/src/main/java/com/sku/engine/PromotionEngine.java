package com.sku.engine;

import java.util.List;


/**
 * @author RamaRao
 *
 */
public interface PromotionEngine {
	
	public double calculatePriceWithApplyPromotion(List<String> selectedSkus) throws PromotionEngineException;

}
