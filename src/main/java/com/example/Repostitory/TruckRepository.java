package com.example.Repostitory;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Truck;

public interface TruckRepository extends CrudRepository<Truck, Long>  {
	

}
