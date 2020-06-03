package com.derive.real.time.location.service.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class Tag {
	
	private int tagId;
	
	private String tag;
	
	private String xCordinate;
	
	private String yCordinate;
	
	private String zCordinate;
	
	private String direction;
	
	private String current_zone;
	
	private String entered_zone_at;
	
	private String createat;
	
	private String updateat;
	
	private String vehUniqueId;
	
	private String eqtUniqueId;
	
	private int assignType;
	
	private int assignStatus;
	
	private int status;
	
	private String add_by;
	
	private Date mdf_date;
	
	private String tag_hex_code;
	
	private String tag_name;
	
	

}
