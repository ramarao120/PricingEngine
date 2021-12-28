package com.sku.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class PromotionUtil {
	
	public static final Supplier<Map<String, Double>> ITEM_PRICE_SUPPLIER = () -> {
		Map<String, Double> itemsPriceMap = new HashMap<>();
		itemsPriceMap.put("A", (double) 50);
		itemsPriceMap.put("B", (double) 30);
		itemsPriceMap.put("C", (double) 20);
		itemsPriceMap.put("D", (double) 15);
		return itemsPriceMap;
	};
	
	public static final Supplier<List<PromotionItem>> PROMOTION_SUPPLIER = () -> {
		List<PromotionItem> promotionItems = new ArrayList<>();
		promotionItems.add(PromotionItem.builder().productName("A").offerPrice(130).numberOfItems(3).promotionType(PromotionType.INDIVIDUAL).build());
		promotionItems.add(PromotionItem.builder().productName("B").offerPrice(45).numberOfItems(2).promotionType(PromotionType.INDIVIDUAL).build());
		promotionItems.add(PromotionItem.builder().productName("C&D").offerPrice(30).numberOfItems(1).promotionType(PromotionType.COMBINED).build());
		return promotionItems;
	};

}
