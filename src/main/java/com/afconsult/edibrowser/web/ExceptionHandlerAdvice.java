package com.afconsult.edibrowser.web;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.afconsult.exception.ItemNotFoundException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
	
	@ExceptionHandler(ItemNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError error404(Exception exception, WebRequest request){
		return createError(exception, request);
	}
	
	@ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError error400(Exception exception, WebRequest request){
		return createError(exception, request);
	}
	
	// TODO: change to support different exceptions and status events
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ApiError error(Exception exception, WebRequest request){
		logger.error("Server error", exception);
		return createError(exception, request);
	}
	
	private ApiError createError(Exception exception, WebRequest request){
		ApiError error = new ApiError(exception.getMessage());
		return error;
	}
}
