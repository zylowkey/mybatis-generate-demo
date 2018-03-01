package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.dao.SysUserRepository;
import com.example.demo.domain.SysUser;

public class CustomUserService implements UserDetailsService {
	@Autowired
	SysUserRepository sysUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserRepository.findByUsername(username);
		if(null == user) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}

}
