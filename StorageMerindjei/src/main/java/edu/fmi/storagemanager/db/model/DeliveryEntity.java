package edu.fmi.storagemanager.db.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery_Entity")
public class DeliveryEntity {
	
	@Id
	@Column(name="delivery_entity_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
	private Delivery delivery;

	@ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
	private Material material;
	
	@Column(name="material_form", length = 50)
	private String materialForm;
	
	@Column(name="type", length = 100)
	private String type;
	
	@Column(name="color", length = 30)
	private String color;
	
	@Column(name="price", nullable = false)
	private BigDecimal price;
	
	@Column(name="size")
	private BigDecimal size;
	
	@Column(name="size_metric", length = 20)
	private String sizeMetric;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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
		return "DeliveryEntity [id=" + id + ", delivery=" + delivery + ", material=" + material + ", materialForm="
				+ materialForm + ", type=" + type + ", color=" + color + ", price=" + price + ", size=" + size
				+ ", sizeMetric=" + sizeMetric + "]";
	}
}