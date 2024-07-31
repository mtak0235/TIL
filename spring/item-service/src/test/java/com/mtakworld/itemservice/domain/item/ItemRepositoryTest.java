package com.mtakworld.itemservice.domain.item;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {
	ItemRepository itemRepository = new ItemRepository();

	@AfterEach
	void afterEach() {
		itemRepository.clearStore();
	}
	@Test
	void save() {
		Item item = new Item("푸우링", 10000, 10);
		Item saved = itemRepository.save(item);
		Item find = itemRepository.findById(saved.getId());
		assertThat(find).isEqualTo(saved);
	}

	@Test
	void findAll() {
		Item item = new Item("푸우링", 10000, 10);
		Item item1 = new Item("템푸라", 20000, 20);
		itemRepository.save(item);
		itemRepository.save(item1);
		List<Item> items = itemRepository.findAll();
		assertThat(items).hasSize(2);
		assertThat(items).contains(item, item1);
	}

	@Test
	void update() {
		Item item = new Item("푸우링", 10000, 10);
		Item saved = itemRepository.save(item);
		Item update = new Item("blue 후우링", 20000, 20);
		itemRepository.update(saved.getId(), update);
		Item find = itemRepository.findById(saved.getId());
		assertThat(find.getItemName()).isEqualTo(update.getItemName());
		assertThat(find.getPrice()).isEqualTo(update.getPrice());
		assertThat(find.getQuantity()).isEqualTo(update.getQuantity());
	}
}