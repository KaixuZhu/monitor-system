package com.zr.auth.service.impl;

import com.zr.auth.mapper.UserMapper;
import com.zr.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


@Service(interfaceClass = AuthService.class)
@Transactional
public class AuthServiceImpl implements AuthService {


	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return userMapper.findByName(s);
	}
}
