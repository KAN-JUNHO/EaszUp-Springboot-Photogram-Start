package com.cos.photogramstart.web.api;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMRespDto;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {
	
	private final UserService userService;
	
	@PutMapping("/api/user/{id}")
	public CMRespDto<?> update(@PathVariable int id, UserUpdateDto userUpdateDto) {
		User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
		//principalDetails.setUser(userEntity);
		return new CMRespDto<>(1,"회원수정완료",userEntity);
	}
}
