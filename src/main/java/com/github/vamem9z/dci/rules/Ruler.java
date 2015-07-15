package main.java.com.github.vamem9z.dci.rules;

import main.java.com.github.vamem9z.dci.contexts.Contexter;
import main.java.com.github.vamem9z.dci.contexts.results.ContextResult;

public interface Ruler {
	ContextResult action(Contexter ctx);
}
