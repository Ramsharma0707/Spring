package com.rays.ioc;

import org.springframework.beans.factory.annotation.Value;

public class Inventory {
	
	@Value(value = "100")
	int stock = 0;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int sold(int qty) {
		stock -= qty; // stock = stock - qty;
		return stock;
	}

}
