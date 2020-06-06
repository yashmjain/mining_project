package com.derive.real.time.location.service.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.derive.real.time.location.service.dao.VehicleInformationDAO;
import com.derive.real.time.location.service.pojo.SearchVehicleInfoRequest;
import com.derive.real.time.location.service.pojo.Tag;

public class VehicleInformationDAOImpl implements VehicleInformationDAO {

	@Autowired
	NamedParameterJdbcTemplate nameParameterTemplate;

	private static final String WHERE_CLAUSE = "where";
	private static final String SPACE = " ";
	private static final String EQUAL = "=";

	@Override
	public List<Tag> getVehicleInformation(SearchVehicleInfoRequest searchvehiclesDetail) {

		String query = String.format("SELECT * FROM TAG %s", createWhereClause(searchvehiclesDetail));

		return nameParameterTemplate.query(query, new VehicleInfoRowMapper());
	}

	private static String createWhereClause(SearchVehicleInfoRequest searchvehiclesDetail) {
		String whereClause="WHERE TRACK_DATE BETWEEN "+searchvehiclesDetail.getStartDate() + "and " +
	     searchvehiclesDetail.getEndDate() + " AND TRACK_TIME BETWEEN "+ searchvehiclesDetail.getStartTime()
	     +"AND "+searchvehiclesDetail.getEndTime() +"AND TAG_NAME = "+searchvehiclesDetail.getTagName();
	
		return whereClause;

	}	

	class VehicleInfoRowMapper implements RowMapper<Tag> {

		@Override
		public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tag tag = new Tag();
			// ToDo : Need to add all the setters here
			// tag.setTag(tag);
			return tag;
		}

	}

}
