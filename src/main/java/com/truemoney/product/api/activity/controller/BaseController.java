package com.truemoney.product.api.activity.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.truemoney.product.api.bill.bean.ErrorBean;

public class BaseController {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	ErrorBean handleAllExceptions(Exception ex) {
		com.truemoney.product.api.bill.bean.ErrorBean errorbean = new com.truemoney.product.api.bill.bean.ErrorBean();
		Map<String, String> outputMap = new HashMap<String, String>();

		outputMap.put("message", ex.getLocalizedMessage());
		outputMap.put("code", ex.getCause().toString());
		outputMap.put("type", "Activity System.");
		errorbean.setError(outputMap);

		// System.out.println(ex.getClass());

		return errorbean;
	}

	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED, reason = "Contact not found")
	public void notAllow() {
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Contact not found")
	public void notFound() {
		System.out.println("Not Found");
	}
}
