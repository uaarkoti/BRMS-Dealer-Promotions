package org.jboss.dealer;

import java.io.Serializable;

public class Vehicle implements Serializable {

	private static final long serialVersionUID = -1556185480733731620L;

	private String model;;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String model) {
		this.model = model;
	}
	public Vehicle(VehicleModel model) {
		this.model = model.toString();
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		return "Vehicle [model=" + model + "]";
	}
}
