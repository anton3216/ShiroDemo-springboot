package org.cskj.boot.shiro.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.cskj.boot.shiro.bean.Role;
import org.cskj.boot.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping(value = "queryAllRole")
	public List<Role> queryAllRole() {
		return roleService.queryAllRole();
	}

	/*
	 * @PostMapping(value="addUser") public boolean addUser(@RequestBody User user)
	 * { System.out.println(user.getName()); System.out.println(user.getPassword());
	 * return userService.addUser(user) > 0 ? true : false; }
	 * 
	 * @PostMapping(value="updateUser") public boolean updateUser(@RequestBody User
	 * user) { return userService.updateUser(user) > 0 ? true : false; }
	 * 
	 * @PostMapping(value="deleteUser") public boolean deleteUser(@RequestBody User
	 * user) { return userService.deleteUser(user) > 0 ? true : false; }
	 */
}
