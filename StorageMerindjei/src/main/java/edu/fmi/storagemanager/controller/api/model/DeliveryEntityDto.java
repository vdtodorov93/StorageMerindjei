package edu.fmi.storagemanager.controller.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DeliveryEntityDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String material;
	
	private BigDecimal quantity;
	
	private String materialForm;
	
	private String type;
	
	private String color;
	
	private BigDecimal price;
	
	private BigDecimal size;
	
	private String sizeMetric;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getMaterialForm() {
		return materialForm;
	}

	public void setMaterialForm(String materialForm) {
		this.materialForm = materialForm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public String getSizeMetric() {
		return sizeMetric;
	}

	public void setSizeMetric(String sizeMetric) {
		this.sizeMetric = sizeMetric;
	}

	@Override
	public String toString() {
		return "DeliveryEntityDto [material=" + material + ", quantity=" + quantity + ", materialForm=" + materialForm
				+ ", type=" + type + ", color=" + color + ", price=" + price + ", size=" + size + ", sizeMetric="
				+ sizeMetric + "]";
	}
}
