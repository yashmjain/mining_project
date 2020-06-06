package com.derive.real.time.location.service.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.derive.real.time.location.service.dao.VehicleInformationDAO;
import com.derive.real.time.location.service.pojo.SearchVehicleInfoRequest;
import com.derive.real.time.location.service.pojo.Tag_Log;

@Repository
public class VehicleInformationDAOImpl implements VehicleInformationDAO {

	@Autowired
	NamedParameterJdbcTemplate nameParameterTemplate;

	public static class COLUMN_LABEL{
		
		private static final String TAG = "TAG";
		private static final String UNIT = "UNIT";
		private static final String C_X = "C_X";
		private static final String C_Y = "C_Y";
		private static final String C_Z = "C_Z";
		private static final String TRACK_DATETIME = "TRACK_DATETIME";
		
	}

	@Override
	public List<Tag_Log> getVehicleInformation(SearchVehicleInfoRequest searchvehiclesDetail) {

		String query = String.format("SELECT TAG,UNIT,C_X,C_Y,C_Z,TRACK_DATETIME FROM TAG_LOG %s ", createWhereClause(searchvehiclesDetail));

		return nameParameterTemplate.query(query, new VehicleInfoRowMapper());
	}

	private static String createWhereClause(SearchVehicleInfoRequest searchvehiclesDetail) {
		String whereClause="WHERE TRACK_DATE BETWEEN '"+searchvehiclesDetail.getStartDate() + "' and '" +
	     searchvehiclesDetail.getEndDate() + "' AND TRACK_TIME BETWEEN '"+ searchvehiclesDetail.getStartTime()
	     +"' AND '"+searchvehiclesDetail.getEndTime() +"' AND UNIT = '"+searchvehiclesDetail.getTagName()+"' ORDER BY TRACK_DATETIME ";
	
		return whereClause;

	}	

	class VehicleInfoRowMapper implements RowMapper<Tag_Log> {

		@Override
		public Tag_Log mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tag_Log tag = new Tag_Log();
			tag.setTag(rs.getString(COLUMN_LABEL.TAG));
			tag.setUnit(rs.getString(COLUMN_LABEL.UNIT));
			tag.setXCordinate(rs.getString(COLUMN_LABEL.C_X));
			tag.setYCordinate(rs.getString(COLUMN_LABEL.C_Y));
			tag.setZCordinate(rs.getString(COLUMN_LABEL.C_Z));
			tag.setTrack_datetime(rs.getString(COLUMN_LABEL.TRACK_DATETIME));
			return tag;
		}

	}

}
