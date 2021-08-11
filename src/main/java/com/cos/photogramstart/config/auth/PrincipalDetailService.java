package com.cos.photogramstart.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service //IOC
public class PrincipalDetailService implements UserDetailsService{

	//1.패스워드는 알아서 체킹하니깐 신경 쓸 필요없다
	//2.리턴이 잘되면 자동으로 UserDetails 타입을 세션으로 만든다
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.findByUsername(username);
		
		if(userEntity==null) {
			return null;
		}else {
			return new PrincipalDetails(userEntity);
		}
		
	}

}
