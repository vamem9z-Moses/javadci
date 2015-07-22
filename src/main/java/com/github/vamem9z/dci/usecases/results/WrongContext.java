package main.java.com.github.vamem9z.dci.usecases.results;

public final class WrongContext extends Failure {
	public WrongContext() {
		this.name = "Wrong Context";
		this.code = 100;
	}
}
