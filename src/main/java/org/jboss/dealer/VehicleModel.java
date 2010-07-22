package org.jboss.dealer;

public enum VehicleModel {
	LANCER, GALANT, SPYDER, ENDEAVOR, EVO, ECLIPSE, OUTLANDER, RAIDERS;

	@Override
	public String toString() {
		// only capitalize the first letter
		String s = super.toString();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
	}
}
