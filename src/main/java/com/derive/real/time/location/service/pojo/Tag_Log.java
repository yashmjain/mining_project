package com.derive.real.time.location.service.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class Tag_Log {
	
	private int tag_log_id;
	
	private String tag;
	
	private String unit;
	
	private String xCordinate;
	
	private String yCordinate;
	
	private String zCordinate;
	
	private String tag_group;
	
	private String zone;
	
	private String tag_log_date;
	
	private String tag_index;
	
	private String date_track;
	
	private String track_datetime;
	
	private String track_date;
	
	private String track_time;
	
	private int status;
	
	private int add_by;
	
	private String mdf_by;
	
	private Date add_dt;
	
	private String mdf_dt;
	

}
