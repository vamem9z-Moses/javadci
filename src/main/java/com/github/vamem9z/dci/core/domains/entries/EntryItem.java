package com.github.vamem9z.dci.core.domains.entries;

import com.github.vamem9z.dci.core.data.models.Model;

public interface EntryItem {
	double transactionAmount();
	Model createModel();
}
