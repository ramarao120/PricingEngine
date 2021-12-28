package com.sku.engine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class PromotionEngineImpl implements PromotionEngine{

	private static final Map<String, Double> items = PromotionUtil.ITEM_PRICE_SUPPLIER.get();
	private static final String IN = "IN";
	private static final String OUT = "OUT";
	private static final String COMBINED_OFFER_SEPERATOR = "&";
	
	public double calculatePriceWithApplyPromotion(List<String> selectedSkus) throws PromotionEngineException {
		double totalPrice = 0;
		
		try {
			final List<PromotionItem> promotionItems = PromotionUtil.PROMOTION_SUPPLIER.get();
			Map<String, Set<String>> itemsMap = generateItemsInOutPromotion(selectedSkus, promotionItems);
			System.out.println(itemsMap);
			totalPrice = itemsMap.getOrDefault(OUT, new HashSet<>()).stream().map(item -> items.get(item))
					.reduce((double) 0, (a, b) -> a + b);

			Map<String, Integer> promotionItemsCountMap = getPromotionItemCountMap(selectedSkus, itemsMap.get(IN));

			for (PromotionItem promotionItem : promotionItems) {
				if (PromotionType.INDIVIDUAL.equals(promotionItem.getPromotionType())) {
					totalPrice += processIndividualPromotion(promotionItem, promotionItemsCountMap);
				} 
			}

		} catch (Exception exp) {
			exp.printStackTrace();
			throw new PromotionEngineException(exp.getMessage());
		}
		System.out.println(totalPrice);
		return totalPrice;
	}
	private Map<String, Set<String>> generateItemsInOutPromotion(List<String> selectedSkus,
			List<PromotionItem> promotionItems) {
		Set<String> itemsInPromotion = new HashSet<>();
		for (PromotionItem promotionItem : promotionItems) {
			if (PromotionType.INDIVIDUAL.equals(promotionItem.getPromotionType())) {
				itemsInPromotion.add(promotionItem.getProductName());
			} else if (PromotionType.COMBINED.equals(promotionItem.getPromotionType())) {
				itemsInPromotion.addAll(Arrays.asList(promotionItem.getProductName().split(COMBINED_OFFER_SEPERATOR)));
			}
		}
		Set<String> itemsNotInPromotion = selectedSkus.stream().filter(item -> !itemsInPromotion.contains(item))
				.collect(Collectors.toSet());
		Map<String, Set<String>> itemsMap = new HashMap<>();
		itemsMap.put(IN, itemsInPromotion);
		itemsMap.put(OUT, itemsNotInPromotion);
		return itemsMap;
	}
	private Map<String, Integer> getPromotionItemCountMap(List<String> selectedItems, Set<String> itemsInPromotion) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String item : selectedItems) {
			if (itemsInPromotion.contains(item)) {
				int count = map.getOrDefault(item, 0);
				map.put(item, count + 1);
			}
		}
		return map;
	}

	private double calculateSum(int numberOfitems, PromotionItem promotionItem, double total) {
		if (numberOfitems <= 0) {
			return total;
		}
		if (numberOfitems < promotionItem.getNumberOfItems()) {
			total += numberOfitems * items.get(promotionItem.getProductName());
			return total;
		}
		if (numberOfitems > promotionItem.getNumberOfItems()) {
			total += promotionItem.getOfferPrice();
			return calculateSum(numberOfitems - promotionItem.getNumberOfItems(), promotionItem, total);
		}
		return total;
	}
	private double processIndividualPromotion(PromotionItem promotionItem,
			Map<String, Integer> promotionItemsCountMap) { 
		int numberOfItems = promotionItemsCountMap.getOrDefault(promotionItem.getProductName(), 0);
		if (numberOfItems == promotionItem.getNumberOfItems()) {
			return promotionItem.getOfferPrice();
		}
		double total = 0;
		return calculateSum(numberOfItems, promotionItem, total);
	}
}
