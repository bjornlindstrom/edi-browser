package com.afconsult.edibrowser.web;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import exception.ItemNotFoundException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	
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
		return createError(exception, request);
	}
	
	private ApiError createError(Exception exception, WebRequest request){
		ApiError error = new ApiError(exception.getMessage());
		return error;
	}
}
