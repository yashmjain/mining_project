package com.derive.real.time.location.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.derive.real.time.location.service.VehicleInformationService;
import com.derive.real.time.location.service.pojo.SearchVehicleInfoRequest;
import com.derive.real.time.location.service.pojo.Tag;

@RestController
@RequestMapping(value = VehicleInformationController.ROOT)
public class VehicleInformationController {	
	static final String ROOT ="api/v1/vehicleinformation";
	
	@Autowired
	private VehicleInformationService vehicleInfo;
	
	 public static final class Defaults {
	        public static final String SIZE = "100";
	        public static final String FROM = "0";
	        public static final String SORT = "name:asc";
	        public static final String PAGE = "0";

	        private Defaults() {}
	    }
	
	 public static final class Params {
	        public static final String SIZE = "size";
	        public static final String FROM = "from";
	        public static final String FILTER = "filter";
	        public static final String SORT = "sort";
	        public static final String PAGE = "page";

	        private Params() {}
	    }
	
	@PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tag>> getVehicleInformation(@RequestBody @Valid SearchVehicleInfoRequest searchPatchesRequest)
	{
		List<Tag> tags = vehicleInfo.getVehicleInformation(searchPatchesRequest);
		if (tags.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}
        return new ResponseEntity<>(tags, HttpStatus.OK);
	}
	
	
	 

}
