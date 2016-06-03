package com.nsdr.europeanaqa.api.interfaces;

import com.nsdr.europeanaqa.api.model.JsonPathCache;
import java.util.Map;

/**
 * Implementation of the Observer design pattern (https://en.wikipedia.org/wiki/Observer_pattern)
 * See comments of the Observable interface
 * @author Péter Király <peter.kiraly at gwdg.de>
 */
public interface Observer {

	void update(JsonPathCache cache, Map<String, Double> results);

}
