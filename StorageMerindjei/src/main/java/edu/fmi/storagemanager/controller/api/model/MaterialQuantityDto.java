package edu.fmi.storagemanager.controller.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class MaterialQuantityDto implements Serializable {

	private static final long serialVersionUID = 1L;

	BigDecimal quantity;

	String material;

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "MaterialQuantityDto [quantity=" + quantity + ", material=" + material + "]";
	}
}
