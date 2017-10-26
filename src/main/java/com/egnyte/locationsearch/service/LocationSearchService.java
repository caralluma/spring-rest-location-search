package com.egnyte.locationsearch.service;

import java.util.List;

import com.egnyte.locationsearch.model.Location;

public interface LocationSearchService {
	public List<Location> findLocation(String country, String city, String locationName);
}
