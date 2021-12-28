package com.sku.engine;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PromotionItem {

	private int numberOfItems;
	private PromotionType promotionType;
	private String productName;
	private double offerPrice;
	
}
