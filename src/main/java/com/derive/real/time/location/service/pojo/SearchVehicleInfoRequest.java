package com.derive.real.time.location.service.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class SearchVehicleInfoRequest {

	private String tagName;

	private Date startTime;

	private Date endTime;

	private int size;

	private int page;

	private String sort;

}
