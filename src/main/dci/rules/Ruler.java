package main.dci.rules;

import main.dci.contexts.Contexter;
import main.dci.contexts.ContextResult;

public interface Ruler {
	ContextResult action(Contexter ctx);
}
