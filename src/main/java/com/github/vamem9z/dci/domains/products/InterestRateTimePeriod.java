package main.java.com.github.vamem9z.dci.domains.products;

public enum InterestRateTimePeriod {
	Daily(365, "Daily"), MONTHLY(12, "Monthly"), WEEKLY(52, "Weekly");
	
	public final double period;
	public final String formattedName;
	
	private InterestRateTimePeriod(double period, String formattedName) {
		this.period = period;
		this.formattedName = formattedName;
	}

}