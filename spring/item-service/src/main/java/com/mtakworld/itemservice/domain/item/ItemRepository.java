package com.mtakworld.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
	private static final Map<Long, Item> store = new HashMap<Long, Item>();
	private static long sequence = 0L;

	public Item save(Item item) {
		item.setId(++sequence);
		store.put(item.getId(), item);
		return item;
	}
	public Item findById(Long id) {
		return store.get(id);
	}
	public List<Item> findAll() {
		return new ArrayList<Item>(store.values());
	}
	public void update(Long itemId, Item updatedItem) {
		Item findItem = findById(itemId);
		findItem.setItemName(updatedItem.getItemName());
		findItem.setPrice(updatedItem.getPrice());
		findItem.setQuantity(updatedItem.getQuantity());
		findItem.setOpen(updatedItem.getOpen());
		findItem.setRegions(updatedItem.getRegions());
		findItem.setDeliveryCode(updatedItem.getDeliveryCode());
	}

	public void clearStore() {
		store.clear();
	}
	public void delete(Item item) {
		store.remove(item.getId());
	}
}
