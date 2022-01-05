package com.sprinbootcrud.main.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.main.entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj,
			LocalDateTime startTime, LocalDateTime endTime) {
		long seconds = startTime.until( endTime, ChronoUnit.MILLIS );
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("data", responseObj);
		//map.put("startTime", startTime);//
		//map.put("endTime", endTime);//
		map.put("timeTaken", seconds);
		return new ResponseEntity<Object>(map, status);
	}

}