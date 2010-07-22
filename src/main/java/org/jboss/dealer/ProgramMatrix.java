package org.jboss.dealer;

import java.util.List;

public class ProgramMatrix {
	
	private List<ProgramRecord> percentageMatrix;
	private List<ProgramRecord> quantityMatrix;
	
	public double getAwardLevel(int objective, int attained) {
		double percentageValue = 0;
		double quantityValue = 0;
		
		for(ProgramRecord record : quantityMatrix) {
			if (record.getLow() <= attained && record.getHigh() > attained) {
				quantityValue = record.getValue();
				break;
			}
		}
		
		double percentage = attained / objective * 100;
		for(ProgramRecord record : percentageMatrix) {
			if (record.getLow() <= percentage  && record.getHigh() > percentage) {
				percentageValue = record.getValue();
				break;
			}
		}
		
		return percentageValue > quantityValue ? percentageValue : quantityValue;
	}
	
	public class ProgramRecord {
		private double low;
		private double high;
		private double value;
		public double getLow() {
			return low;
		}
		public void setLow(double low) {
			this.low = low;
		}
		public double getHigh() {
			return high;
		}
		public void setHigh(double high) {
			this.high = high;
		}
		public double getValue() {
			return value;
		}
		public void setValue(double value) {
			this.value = value;
		}
	}
}
