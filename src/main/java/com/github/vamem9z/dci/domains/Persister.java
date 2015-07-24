package main.java.com.github.vamem9z.dci.domains;

import main.java.com.github.vamem9z.dci.data.models.Model;
import main.java.com.github.vamem9z.dci.usecases.results.UseCaseResult;

public interface Persister {
	Model createModel();
	
	default UseCaseResult save() {
		Model model = createModel();
		return model.save();
	}
}
