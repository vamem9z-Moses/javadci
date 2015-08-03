package com.github.vamem9z.dci.core.domains.results;

public interface Result {
	boolean isFailure();
	String name();
	ResultTypes resultType();
}
