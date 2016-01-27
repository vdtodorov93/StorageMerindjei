use storagemanager;

CREATE TABLE IF NOT EXISTS Vendor (
	vendor_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(100),
	phone_number VARCHAR(30),
	bank_account VARCHAR(100),
	PRIMARY KEY (vendor_id)
);

CREATE TABLE IF NOT EXISTS Material (
	material_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (material_id)
);

CREATE TABLE IF NOT EXISTS Delivery (
	delivery_id INT NOT NULL AUTO_INCREMENT,
	vendor_id INT NOT NULL,
	date_of_delivery DATETIME NOT NULL,
	PRIMARY KEY (delivery_id),
	CONSTRAINT `fk_delivery_vendor`
	  FOREIGN KEY (vendor_id)
	  REFERENCES Vendor (vendor_id)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Delivery_Entity (
	delivery_entity_id INT NOT NULL AUTO_INCREMENT,
	delivery_id INT NOT NULL,
	material_id INT NOT NULL,	
	quantity DECIMAL(12, 3) NOT NULL,
	material_form VARCHAR(50),
	type VARCHAR(100),
	color VARCHAR(30),
	price DECIMAL(10,2) NOT NULL,
	size DECIMAL(20,5),
	size_metric VARCHAR(20),
	PRIMARY KEY (delivery_entity_id),
	CONSTRAINT `fk_deliveryentity_delivery`
	  FOREIGN KEY (delivery_id)
	  REFERENCES Delivery (delivery_id)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION,
	CONSTRAINT `fk_deliveryentity_material`
	  FOREIGN KEY (material_id)
	  REFERENCES Material (material_id)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Used_Material (
	id INT NOT NULL AUTO_INCREMENT,
	material_id INT NOT NULL,
	quantity DECIMAL(12, 3) NOT NULL,
	usage_date DATETIME NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT `fk_usedmaterial_material`
	  FOREIGN KEY (material_id)
	  REFERENCES Material (material_id)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION
);

INSERT INTO Material(`name`)
VALUES ('foil'), ('vinil'), ('komatex'), ('backlit'), ('canavatza'), ('paper'), ('ink');