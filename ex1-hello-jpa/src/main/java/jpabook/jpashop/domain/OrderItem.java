package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {
    @Id
    @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue
    private Long id;
    private Long orderId;
    private Long itemId;
    private int orderPrice;
    private int count;
}
