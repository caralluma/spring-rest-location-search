package com.egnyte.locationsearch.service;

import java.util.List;

import com.egnyte.locationsearch.model.Location;

public interface FilterLocationService {
	public List<Location> filterLocation(String country, String city, List<facebook4j.Place> placeList);
}
