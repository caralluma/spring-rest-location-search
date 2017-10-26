package com.egnyte.locationsearch.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.egnyte.locationsearch.config.Facebook4JConfig;
import com.egnyte.locationsearch.model.Location;

import facebook4j.Place;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { FilterLocationServiceImpl.class, FacebookServiceImpl.class, Facebook4JConfig.class, MessageSource.class})
public class LocationSearchServiceImplTest {

	@Autowired
	private FacebookService facebookService;

	@Autowired
	private FilterLocationService filterLocationService;

	@Test
	public void testFilterSuccess() {
		List<Place> placeList = facebookService.getLocation("poland", "poznan", "egnyte");

		List<Location> filteredPlaces = filterLocationService.filterLocation("poland", "poznan", placeList);
		
		//In case we get only single record
		assertEquals(1, filteredPlaces.size());
		assertFalse(filteredPlaces.isEmpty());
		
		Location foundPlace = filteredPlaces.get(0);
		
		//Confirm the right location
		assertEquals("Egnyte Poland", foundPlace.getName());
		
		assertEquals(52.40475, foundPlace.getLatitude(), 1);
		assertEquals(16.940681, foundPlace.getLongitude(), 1);
	}

	@Test
	public void testSearchCorrectNumber() {
		List<Place> placeList = facebookService.getLocation("poland", "poznan", "kfc");
		//count places
		assertEquals(5, placeList.size());
		assertFalse(placeList.isEmpty());
	}

}
