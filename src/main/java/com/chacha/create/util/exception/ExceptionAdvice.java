package com.chacha.create.util.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.chacha.create.common.exception.LoginFailException;
import com.chacha.create.common.exception.NeedLoginException;

@ControllerAdvice
public class ExceptionAdvice {

	// 404 에러 처리
	@ExceptionHandler(NoHandlerFoundException.class)
	public String exception404(HttpServletRequest request) {
		return "error/error404";
	}
	@ExceptionHandler(Exception.class)
	public String exception500(HttpServletRequest request) {
		return "error/error500";
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public String exception400(HttpServletRequest request) {
		return "error/error400";
	}
	@ExceptionHandler({LoginFailException.class, NeedLoginException.class})
	public String exception401(HttpServletRequest request) {
		return "error/error401";
	}
}
