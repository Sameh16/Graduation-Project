package com.example.RestController;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repostitory.LocationRepository;
import com.example.models.Location;

@RestController
@CrossOrigin(origins = "*")

public class GPS {

	@Autowired
	private LocationRepository locationRepository;

	@RequestMapping(value = "/saveLocation/{lat}/{lon}", method = RequestMethod.GET)
	public boolean getLocation(@PathVariable String lat, @PathVariable String lon) {
		Location l = new Location();
		l.setLat(lat);
		l.setLon(lon);

		if (locationRepository.save(l) != null)
			return true;
		return false;
	}

	@RequestMapping(value = "/getCurrentLocation", method = RequestMethod.GET)
	public Location getLocation() {
		ArrayList<Location> l = locationRepository.findAll();
		Comparator<Location> locationComparator = new Comparator<Location>() {

			@Override
			public int compare(Location l1, Location l2) {
				return (int) (l1.getId() - l2.getId());
			}

		};
		Collections.sort(l, locationComparator);
		Location temp = l.get(l.size() - 1);
		if(temp.getId()==1)
		{
			temp = l.get(0);
		}
	
		return temp;
	}

}
