package main.java.com.github.vamem9z.dci.core.domains.products;

public enum InterestRateTimePeriod {
	DAYS(365, "Days"), MONTHS(12, "Months"), WEEKS(52, "Weeks"), QUARTERS(4, "Quarters"), YEARS(1, "Years");
	
	public final double period;
	public final String formattedName;
	
	private InterestRateTimePeriod(double period, String formattedName) {
		this.period = period;
		this.formattedName = formattedName;
	}

}