package com.egnyte.locationsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egnyte.locationsearch.model.Location;

import facebook4j.Place;

@Service
public class LocationSearchServiceImpl implements LocationSearchService {

	@Autowired
	FacebookService facebookService;

	@Autowired
	FilterLocationService filterLocationService;

	@Override
	public List<Location> findLocation(String country, String city, String locationName) {
		List<Place> placeList = facebookService.getLocation(country, city, locationName);
		return filterLocationService.filterLocation(country, city, placeList);
	}

}
