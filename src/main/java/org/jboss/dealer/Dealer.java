package org.jboss.dealer;


public class Dealer {
	private String name;
	private String id;
	private double objective;
	private double attainment;
	private double totalAward;
	
	public Dealer() {
		
	}
	
	public Dealer(String name, double objective, double attainment) {
		this.name = name;
		this.objective = objective;
		this.attainment = attainment;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getObjective() {
		return objective;
	}
	public void setObjective(double objective) {
		this.objective = objective;
	}
	public double getAttainment() {
		return attainment;
	}
	public void setAttainment(double attainment) {
		this.attainment = attainment;
	}
	public double getTotalAward() {
		return totalAward;
	}
	public void setTotalAward(double totalAward) {
		this.totalAward = totalAward;
	}
	
	public void checkAndSetTotalAward(double totalAward) {
		//System.out.println("Current TotalAward = " + this.totalAward + " New TotalAward = " + totalAward);
		if (this.totalAward < totalAward) {
			this.totalAward = totalAward;
		}
		//System.out.println("Final Total Award = " + this.totalAward);
	}
	
	@Override
	public String toString() {
		return "Dealer [attainment=" + attainment + ", name=" + name
				+ ", objective=" + objective + ", totalAward=" + totalAward
				+ "]";
	}
}
