package com.egnyte.locationsearch.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Place;
import facebook4j.Reading;
import facebook4j.ResponseList;

@Service
public class FacebookServiceImpl implements FacebookService {
	@Autowired
	private Facebook facebook;

	@Override
	public List<Place> getLocation(String country, String city, String locationName) {
		ResponseList<Place> places = null;

        try {
            places = facebook.searchPlaces((new StringBuffer(locationName).append(" ").append(city).append(" ").append(country).toString()), new Reading().fields("location", "name"));
        } catch (FacebookException e) {
            e.printStackTrace();
        }
        return places.stream().collect(Collectors.toList());
	}

}
