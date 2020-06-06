package com.derive.real.time.location.service.pojo;

import lombok.Data;

@Data
public class SearchVehicleInfoRequest {

	private String tagName;

	private String startTime;

	private String endTime;
	
	private String startDate;
	
	private String endDate;

	private int size;

	private int page;

	private String sort;

}
