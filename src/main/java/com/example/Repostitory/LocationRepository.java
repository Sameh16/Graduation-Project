package com.example.Repostitory;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
	public ArrayList<Location> findAll();
	
}
