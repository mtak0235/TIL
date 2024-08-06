package com.mtakworld.itemservice.domain.item;

import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
// @ScriptAssert(lang="javascript", script = "_this.price*_this.quantity>= 10000", message = "총 합이 10000원 넘어야 합니다.")
public class Item {
	// @NotNull(groups = UpdateCheck.class)
	private Long id;
	// @NotBlank(message = "공백 ㄴㄴ", groups = {UpdateCheck.class, SaveCheck.class})
	private String itemName;
	// @NotNull(groups = {UpdateCheck.class, SaveCheck.class} )
	// @Range(min = 1000, max = 1000000)
	private Integer price;
	// @NotNull(groups = {UpdateCheck.class, SaveCheck.class})
	// @Max(value = 9999, groups = SaveCheck.class)
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
