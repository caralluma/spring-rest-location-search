package com.egnyte.locationsearch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.egnyte.locationsearch.model.Location;

import facebook4j.Place;

@Service
public class FilterLocationServiceImpl implements FilterLocationService {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public List<Location> filterLocation(String country, String city, List<Place> placeList) {
		List<Location> resultList = new ArrayList<>();

        List<facebook4j.Place> filteredPlaces = placeList.stream()
                .filter(place -> place.getLocation().getCountry()!=null &&place.getLocation().getCountry().equalsIgnoreCase(country))
                .filter(place ->place.getLocation().getCity()!=null && place.getLocation().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        //In case no place is found
        if(filteredPlaces == null || filteredPlaces.isEmpty()){
        	Location location = new Location(messageSource.getMessage("location.not.available", null, Locale.ENGLISH), 0.0F, 0.0F);
            resultList.add(location);
            return resultList;
        }
        
         resultList =  filteredPlaces.stream().map(p -> new Location(p.getName(), p.getLocation().getLatitude().floatValue(), p.getLocation().getLongitude().floatValue()))
        .collect(Collectors.toList());

        return resultList;
	}



}
