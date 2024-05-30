package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		dao.update(dto);
	}

	public UserDTO delete(long id) {
		UserDTO deletedUser = dao.delete(id);
		return deletedUser;
	}

	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public UserDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}

	public List search(UserDTO dto) {
		return dao.search(dto);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	public UserDTO authenticate(String login, String password) {
		UserDTO user = dao.auth(login, password);
		return user;
	}
}
