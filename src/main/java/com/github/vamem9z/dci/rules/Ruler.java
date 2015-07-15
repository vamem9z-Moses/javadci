package main.java.com.github.vamem9z.dci.rules;

import main.java.com.github.vamem9z.dci.contexts.ContextResult;
import main.java.com.github.vamem9z.dci.contexts.Contexter;

public interface Ruler {
	ContextResult action(Contexter ctx);
}
