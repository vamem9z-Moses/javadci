package main.java.com.github.vamem9z.dci.domains.accounts;

public interface Account {
	String printAccountID();
	void recordTransaction(double amount, String msg, AccountActions actions);
	double calcBalance();
}
