package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImpl implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) {
		Integer pk=nextPk();
		
		String sql = "INSERT INTO USER VALUES(?, ?, ?, ?, ?)";

		 int id = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return dto.getId();
	}

	public void update(UserDTO dto) {

		String sql = "UPDATE USER SET FIRST_NAME = ?, LAST_NAME = ?, LOGIN = ?, PASSWORD = ? WHERE ID = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

	}

	public void delete(long id) {
		String sql = "DELETE FROM USER WHERE ID = ?";
		Object[] params = { id };
		int i = jdbcTemplate.update(sql, params);
	}

	public UserDTO findByLogin(String login) {
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER WHERE LOGIN = ?";
		Object[] params = { login };
		UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
		return user;
	}

	public UserDTO findByPK(long pk) {
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER WHERE ID = ?";
		Object[] params = { pk };
		List list = jdbcTemplate.query(sql, params, new UserMapper());

		UserDTO dto = null;

		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		try {
			String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER WHERE LOGIN = ? AND PASSWORD = ?";
			Object[] params = { login, password };
			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List search(UserDTO dto) {
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER";
		List l = jdbcTemplate.query(sql, new UserMapper());
		return l;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER LIMIT " + pageNo + "," + pageSize;
		List l = jdbcTemplate.query(sql, new UserMapper());
		return l;
	}

	
	
	public Integer nextPk()  {

		Integer maxId=0;
		String sql="select max(id) from user";

		
		/* Object[] params = { pk }; */
		 maxId = jdbcTemplate.queryForObject(sql,  Integer.class);
	
		/*
		 * if (maxId == null) { maxId = 0; }
		 * System.out.println("max id is===>>>>"+maxId);
		 */
		return maxId+1;
		
		
		/* return pk + 1; */
}
	
	
	
}
