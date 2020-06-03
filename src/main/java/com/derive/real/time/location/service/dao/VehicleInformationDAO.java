package com.derive.real.time.location.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.derive.real.time.location.service.pojo.SearchVehicleInfoRequest;
import com.derive.real.time.location.service.pojo.Tag;

@Repository
public interface VehicleInformationDAO {
	
	public List<Tag> getVehicleInformation(SearchVehicleInfoRequest searchvehiclesDetail);

}
