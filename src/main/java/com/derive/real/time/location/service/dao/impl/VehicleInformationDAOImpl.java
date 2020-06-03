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

	private static StringBuilder createWhereClause(SearchVehicleInfoRequest searchvehiclesDetail) {
		StringBuilder whereclause = new StringBuilder(WHERE_CLAUSE);
		String tagname = searchvehiclesDetail.getTagName();
		Date startTime = searchvehiclesDetail.getStartTime();
		Date endTime = searchvehiclesDetail.getEndTime();

		if (!tagname.isBlank()) {
			appendCondition(whereclause, "tag", tagname);
		}

		// ToDo : Need to apply for StartDate and endDate

		return whereclause;

	}

	private static StringBuilder appendCondition(StringBuilder existingclause, String key, String value) {
		return existingclause.append(SPACE).append(key).append(EQUAL).append(value);
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
