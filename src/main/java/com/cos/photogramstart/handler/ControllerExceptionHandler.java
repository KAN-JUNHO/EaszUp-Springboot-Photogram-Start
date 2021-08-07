package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomValidationException.class)
	public String validationException(CustomValidationException e) {
		//CMRespoDto, script 비교
		//1.클라이언트에게 응답할 때는 Script 좋음
		//2.Ajax - CMRespoDto
		//3.Android 통신 - CMRespoDto
		return Script.back(e.getErrorMap().toString());
		//		return new CMRespDto(-1,e.getMessage(),e.getErrorMap());
	}
}
