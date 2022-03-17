package com.sample.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(value = "/api/v1/users")
@CrossOrigin("*")
public class UserController {

	@Operation(summary = "about me", description = "Details about myseld", parameters = {
			@Parameter(name = "city", in = ParameterIn.QUERY, description = "city ex: Bangalore", required = true, schema = @Schema(type = "string", allowableValues = {
					"Bangalore", "Chennai", "Hyderabad" })) })
	@GetMapping("/by-city")
	public ResponseEntity<Map<String, Object>> infoByName(
			@RequestParam(name = "city", required = false) String firstName) {

		Map<String, Object> usersByCity = new HashMap<>();

		return ResponseEntity.ok(usersByCity);

	}

}