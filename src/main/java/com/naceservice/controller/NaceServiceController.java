package com.naceservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naceservice.dto.NaceServiceRequestDTO;
import com.naceservice.response.dto.NaceServiceResponseDTO;
import com.naceservice.service.NaceService;
import com.naceservice.validator.NaceServiceValidator;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Class is marked with the RestController annotation.It contains all the NACE
 * service applications apis with different request URIs
 *
 * @author Jyoti
 */

@RestController
@Slf4j
public class NaceServiceController {

	@Autowired
	private NaceServiceValidator naceServiceValidator;
	
	@Autowired
	private NaceService naceService;

	/**
	 * Method to add the NACE details that comes from the client into the
	 * database
	 *
	 * @param naceServiceReqDto object which contains the request attributes for
	 *                         adding NACE details in the application
	 * @param result           instance of BindingRsult. Used for validation
	 *                         purpose.
	 * @return Map as a response entity
	 */
	
	@PostMapping(value = "/putNaceDetails")
	@ApiOperation(value = "Add nace details", produces = "application/json")
	public ResponseEntity<Map<Long, String>> putNaceDetails(@Valid @RequestBody NaceServiceRequestDTO naceServiceReqDto,
			BindingResult result) {
		log.info("Inside nace details");
		naceServiceValidator.validate(naceServiceReqDto, result);
		Long orderNumber = naceService.putNaceDetails(naceServiceReqDto);
		Map<Long, String> response = new HashMap<>();
		response.put(orderNumber, "Order successfully saved");
		return new ResponseEntity<Map<Long, String>>(response, HttpStatus.OK);
	}
	
	/**
	 * Method to get the NACE details for the requested order number present in the application from the
	 * database
	 *
	 * @param orderNumber request parameter containing the order number
	 *                         
	 * @return NaceServiceResponseDTO as a response entity
	 */
	
	@GetMapping(value = "/getNaceDetails")
	@ApiOperation(value = "Get nace detail", produces = "application/json")
	public ResponseEntity<NaceServiceResponseDTO> getNaceDetails(@RequestParam long orderNumber) {
		log.info("Getting all credit cards");
		NaceServiceResponseDTO naceServiceResponse = naceService.getNaceDetails(orderNumber);
		return new ResponseEntity<NaceServiceResponseDTO>(naceServiceResponse, HttpStatus.OK);

	}
}
