
package com.example.RestController;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.Repostitory.LocationRepository;
import com.example.Repostitory.TruckRepository;
import com.example.models.Truck;
import com.example.models.Driver;
import com.example.models.Location;

@RestController
@CrossOrigin(origins = "*")
public class TruckRestController {
	
	@Autowired
	private TruckRepository truckRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	/* it gets all the active trucks, helping to draw markers of all the active trucks*/
	@RequestMapping(value = "/getActiveTrucks", method = RequestMethod.GET)
	public ArrayList<Truck> getAllActiveTrucks() {
		ArrayList<Truck> trucks = (ArrayList<Truck>) truckRepository.findAll();
		ArrayList<Truck> activeTrucks=new ArrayList<Truck>();
		for(int i=0;i<trucks.size();i++)
		{
			if(trucks.get(i).getActive())
			{
				activeTrucks.add(trucks.get(i));
			}
		}
		return activeTrucks;
	}
	
	/* it gets an object of a specific truck, helping to get truck data*/
	@RequestMapping(value = "/viewTruck/{id}", method = RequestMethod.GET)
	public Truck getSpecificTruck(@PathVariable Long id) {
		Truck truck = truckRepository.findOne(id);
		return truck;
	}
	
	
	/* it gets the current location of truck to draw a  marker on the map */
	@RequestMapping(value = "/viewCurrentLocation/{truck_id}", method = RequestMethod.GET)
	public Location getCurrentLocation(@PathVariable String truck_id) {
		ArrayList<Location> locations=(ArrayList<Location>) locationRepository.findAll();
		ArrayList<Location> truckLocations=new ArrayList<Location>();
		for(int i=0;i<locations.size();i++)
		{
			if(locations.get(i).getTruck().getId().equals(truck_id))
			{
				truckLocations.add(locations.get(i));
			}
		}
		return truckLocations.get(truckLocations.size()-1);
	
	}
	/* it gets all locations of a truck, helping to get check points  */
	@RequestMapping(value = "/viewTruckLocations/{id}", method = RequestMethod.GET)
	public ArrayList<Location> getLocations(@PathVariable String id) {
		ArrayList<Location> locations=(ArrayList<Location>) locationRepository.findAll();
		ArrayList<Location> truckLocations=new ArrayList<Location>();
		for(int i=0;i<locations.size();i++)
		{
			if(locations.get(i).getTruck().getId().equals(id))
			{
				truckLocations.add(locations.get(i));
			}
		}
		return truckLocations;
	}
	
	@RequestMapping(value = "/viewDriverData/{id}", method = RequestMethod.GET)
	public Driver getDriver(@PathVariable Long id) 
	{
		Truck truck=truckRepository.findOne(id);
		return truck.getDriver();
	}
	
	

}
