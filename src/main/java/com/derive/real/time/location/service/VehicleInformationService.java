package com.derive.real.time.location.service;

import java.util.List;

import com.derive.real.time.location.service.pojo.SearchVehicleInfoRequest;
import com.derive.real.time.location.service.pojo.Tag;

public interface VehicleInformationService {
	
	public List<Tag> getVehicleInformation(SearchVehicleInfoRequest searchvehiclesDetail);

}
