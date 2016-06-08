package com.nsdr.europeanaqa.api.abbreviation;

import com.nsdr.metadataqa.api.abbreviation.AbbreviationManager;
import java.util.Map;

/**
 *
 * @author Péter Király <peter.kiraly at gwdg.de>
 */
public class EdmDatasetManager extends AbbreviationManager {

	public EdmDatasetManager() {
		super();
		initialize("abbreviations/datasets.txt", true);
	}

	public Map<String, Integer> getDatasets() {
		return data;
	}

}
