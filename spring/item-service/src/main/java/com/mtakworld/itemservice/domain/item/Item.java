package com.mtakworld.itemservice.domain.item;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Item {
	private Long id;
	@NotBlank(message = "공백 ㄴㄴ")
	private String itemName;
	@NotNull
	@Range(min = 1000, max = 1000000)
	private Integer price;
	@NotNull
	@Max(9999)
	private Integer quantity;
	private Boolean open;
	private List<String> regions;
	private ItemType itemType;
	private String deliveryCode;

	public Item(String itemName, Integer price, Integer quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
}
