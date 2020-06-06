package com.derive.real.time.location.service.pojo;

import java.util.List;

import lombok.Data;

@Data
public class VehicleInfoResponse {
	
	private List<Tag_Log> tagInfoList;
	
	private Double distance;

}
