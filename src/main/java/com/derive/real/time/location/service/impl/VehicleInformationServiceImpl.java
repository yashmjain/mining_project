package com.derive.real.time.location.service.impl;

import java.util.List;

import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derive.real.time.location.service.VehicleInformationService;
import com.derive.real.time.location.service.dao.VehicleInformationDAO;
import com.derive.real.time.location.service.pojo.SearchVehicleInfoRequest;
import com.derive.real.time.location.service.pojo.Tag_Log;
import com.derive.real.time.location.service.pojo.VehicleInfoResponse;

@Service
public class VehicleInformationServiceImpl implements VehicleInformationService {

	@Autowired
	VehicleInformationDAO vehicleInfoDAO;
	
	@Override
	public VehicleInfoResponse getVehicleInformation(SearchVehicleInfoRequest searchvehiclesDetail) {
		VehicleInfoResponse vehicleRespo = new VehicleInfoResponse();
		List<Tag_Log> tagLogList =  vehicleInfoDAO.getVehicleInformation(searchvehiclesDetail);
		Float startingLocationX = Float.valueOf(tagLogList.get(0).getXCordinate());
		Float startingLocationY = Float.valueOf(tagLogList.get(0).getYCordinate()); 
		Float startingLocationZ = Float.valueOf(tagLogList.get(0).getZCordinate()); 

		Float endLocationX = Float.valueOf(tagLogList.get((tagLogList.size()-1)).getXCordinate()); 
		Float endLocationY = Float.valueOf(tagLogList.get((tagLogList.size()-1)).getYCordinate()); 
		Float endLocationZ = Float.valueOf(tagLogList.get((tagLogList.size()-1)).getZCordinate()); 
		
		double startingPoint[] = {startingLocationX,startingLocationY,startingLocationZ};
		double endPoint[] = {endLocationX,endLocationY,endLocationZ};
		
		EuclideanDistance ed = new EuclideanDistance();
		double distance = ed.compute(startingPoint, endPoint);
		vehicleRespo.setTagInfoList(tagLogList);
		vehicleRespo.setDistance(distance);
		return vehicleRespo;
		
		
	}

}
