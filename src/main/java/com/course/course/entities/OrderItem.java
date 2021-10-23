package com.course.course.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.course.course.entities.pk.OrderItemPk;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_ordem_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	@EqualsAndHashCode.Include
	@EmbeddedId
	private OrderItemPk id;

	private Integer quantity;
	private BigDecimal price;

	public OrderItem(Order order, Product product, Integer quantity, BigDecimal price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

}
