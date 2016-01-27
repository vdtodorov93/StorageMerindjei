package edu.fmi.storagemanager.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Delivery")
public class Delivery {

	@Id
	@Column(name = "delivery_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_delivery")
	private Date deliveryDate;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private List<DeliveryEntity> deliveryEntities;
	
	public Delivery() {
		this.deliveryEntities = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<DeliveryEntity> getDeliveryEntities() {
		return deliveryEntities;
	}

	public void setDeliveryEntities(List<DeliveryEntity> deliveryEntities) {
		this.deliveryEntities = deliveryEntities;
	}
	
	public void addDeliveryEntity(DeliveryEntity deliveryEntity) {
		deliveryEntity.setDelivery(this);
		deliveryEntities.add(deliveryEntity);
	}

	@PrePersist
	private void setDeliveryDate() {
		if (deliveryDate == null) {
			deliveryDate = new Date();
		}
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", vendor=" + vendor + ", deliveryDate=" + deliveryDate + "]";
	}
}