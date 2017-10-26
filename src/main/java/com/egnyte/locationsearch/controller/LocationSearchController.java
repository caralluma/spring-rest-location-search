package com.egnyte.locationsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.egnyte.locationsearch.model.Location;
import com.egnyte.locationsearch.service.LocationSearchService;

@RestController
public class LocationSearchController {
	
	@Autowired
    private LocationSearchService locationService;

    @GetMapping(value = "/{country}/{city}/{locationName}")
    public List<Location> getPlaces( @PathVariable(value = "country") String country, 
    													   @PathVariable(value = "city") String city, 
    													   @PathVariable(value = "locationName") String locationName ){

       return locationService.findLocation(country, city, locationName);
    }
}
