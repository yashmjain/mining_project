package com.derive.real.time.location.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.derive.real.time.location.service.VehicleInformationService;
import com.derive.real.time.location.service.dao.VehicleInformationDAO;
import com.derive.real.time.location.service.pojo.SearchVehicleInfoRequest;
import com.derive.real.time.location.service.pojo.Tag;

public class VehicleInformationServiceImpl implements VehicleInformationService {

	@Autowired
	VehicleInformationDAO vehicleInfoDAO;
	
	@Override
	public List<Tag> getVehicleInformation(SearchVehicleInfoRequest searchvehiclesDetail) {
		return vehicleInfoDAO.getVehicleInformation(searchvehiclesDetail);
	}

}
