package com.watch.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
	private Map<String, Item> items;

	public Cart() {
		this.items = new HashMap<String, Item>();
	}

	public Map<String, Item> getItems() {
		return items;
	}

	public void setItems(Map<String, Item> items) {
		this.items = items;
	}

	public Item getItem(String id) {
		if (items.containsKey(id)) {
			return items.get(id);
		}
		return null;
	}

	public void addItem(Item item) {
		if (items.containsKey(item.getProduct().getId())) {
			Item exItem = this.getItem(item.getProduct().getId());
			exItem.setQuantity(exItem.getQuantity() + item.getQuantity());
			exItem.setPrice(exItem.getPrice() + item.getPrice());
		} else {
			items.put(item.getProduct().getId(), item);
		}
	}

	public void addjustItem(String id) {
		if (items.containsKey(id)) {
			Item exItem = this.getItem(id);
			exItem.setQuantity(exItem.getQuantity() + 1);
			exItem.setPrice(exItem.getPrice() + exItem.getProduct().getPrice());
		}
	}

	public void minusItem(String id) {
		if (items.containsKey(id)) {
			Item exItem = this.getItem(id);
			exItem.setQuantity(exItem.getQuantity() - 1);
			exItem.setPrice(exItem.getPrice() - exItem.getProduct().getPrice());
			if (exItem.getQuantity() <= 0) {
				this.removeItem(id);
			}
		}
	}

	public void removeItem(String id) {
		if (items.containsKey(id)) {
			items.remove(id);

		}
	}

	public double getTotalPrice() {
		double result = 0.0;
		Set<String> keys = items.keySet();
		for (String key : keys) {
			result += this.items.get(key).getPrice();
		}
		return result;
	}

}
