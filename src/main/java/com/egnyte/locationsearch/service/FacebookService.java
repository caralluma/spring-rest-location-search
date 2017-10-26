package com.egnyte.locationsearch.service;

import java.util.List;

import facebook4j.Place;

public interface FacebookService {
	public List<Place> getLocation(String country, String city, String locationName);
}
