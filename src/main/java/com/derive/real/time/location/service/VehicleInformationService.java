package com.derive.real.time.location.service;

import com.derive.real.time.location.service.pojo.SearchVehicleInfoRequest;
import com.derive.real.time.location.service.pojo.VehicleInfoResponse;

public interface VehicleInformationService {
	
	public VehicleInfoResponse getVehicleInformation(SearchVehicleInfoRequest searchvehiclesDetail);

}
