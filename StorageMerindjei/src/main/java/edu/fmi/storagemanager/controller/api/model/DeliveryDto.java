package edu.fmi.storagemanager.controller.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String vendor;

	private Date deliveryDate;
	
    private List<DeliveryEntityDto> deliveryEntities;
    
	public DeliveryDto() {
		this.deliveryEntities = new ArrayList<>();
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<DeliveryEntityDto> getDeliveryEntities() {
		return deliveryEntities;
	}

	public void setDeliveryEntities(List<DeliveryEntityDto> deliveryEntities) {
		this.deliveryEntities = deliveryEntities;
	}

	@Override
	public String toString() {
		return "DeliveryDto [vendor=" + vendor + ", deliveryDate=" + deliveryDate + ", deliveryEntities="
				+ deliveryEntities + "]";
	}
}
