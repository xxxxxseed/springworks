package com.cloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cloud.domain.MemberVO;
import com.cloud.mapper.MemberMapper;
import com.cloud.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName : " + username);
		
		MemberVO vo = mapper.read(username);	//ȸ�� �� ����
		
		log.warn("queried by member mapper : " + vo);
		
		//�˻��� vo�� �ִ� CustomUser ��ü ������ ��ȯ
		return vo == null ? null : new CustomUser(vo);
	}

}
