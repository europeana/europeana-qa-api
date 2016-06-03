package com.nsdr.europeanaqa.api.problemcatalog;

import com.nsdr.europeanaqa.api.interfaces.Observer;
import com.nsdr.europeanaqa.api.interfaces.Observable;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.nsdr.europeanaqa.api.counter.Counters;
import com.nsdr.europeanaqa.api.interfaces.Calculator;
import com.nsdr.europeanaqa.api.model.JsonPathCache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Péter Király <peter.kiraly at gwdg.de>
 */
public class ProblemCatalog implements Calculator, Serializable, Observable {

	private static final Logger logger = Logger.getLogger(ProblemCatalog.class.getCanonicalName());

	private final List<Observer> problems = new ArrayList<>();
	private String jsonString;
	private Object jsonDocument;
	private JsonPathCache cache;
	private Map<String, Double> results;

	public String getJsonString() {
		return jsonString;
	}

	public Object getJsonDocument() {
		return jsonDocument;
	}

	@Override
	public void addObserver(Observer observer) {
		problems.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		if (problems.contains(observer)) {
			problems.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : problems) {
			observer.update(cache, results);
		}
	}

	@Override
	public void calculate(JsonPathCache cache, Counters counters) {
		this.cache = cache;
		this.results = new LinkedHashMap<>();
		notifyObservers();
		counters.setProblemList(results);
	}

}
