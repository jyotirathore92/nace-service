package com.naceservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.naceservice.config.NaceServiceTestConfig;
import com.naceservice.dto.NaceServiceRequestDTO;
import com.naceservice.response.dto.NaceServiceResponseDTO;
import com.naceservice.service.NaceService;
import com.naceservice.validator.NaceServiceValidator;

public class NaceServiceControllerTest extends NaceServiceTestConfig {

	@InjectMocks
	private NaceServiceController naceServiceController;

	@Mock
	private NaceServiceValidator naceServiceValidator;

	@Mock
	private NaceService naceService;

	@Test
	public void putNaceDetailsTest() {
		BindingResult bindingResult = new BeanPropertyBindingResult(new NaceServiceRequestDTO(), "request");
		NaceServiceRequestDTO request = new NaceServiceRequestDTO(1234, 1, "J", "", "Agriculture", "", "", "", "", "B");
		doNothing().when(naceServiceValidator).validate(request, bindingResult);
		long orderNumber = 1234L;
		Mockito.when(naceService.putNaceDetails(request)).thenReturn(orderNumber);

		Map<Long, String> response = new HashMap<>();
		response.put(orderNumber, "Order successfully saved");
		naceServiceController.putNaceDetails(request, bindingResult);
		for (long key : response.keySet()) {
			assertEquals(key, 1234);
		}
	}

	@Test
	public void getAllTest() {

		NaceServiceResponseDTO naceResponseDto = NaceServiceResponseDTO.builder().code("A").description("Agriculture")
				.itemsExcluded(null).itemsIncluded1("test").itemsIncluded2(null).level(1).orderNumber(38542).parent("B")
				.rulings(null).referenceIsicRev4("A").build();
		Mockito.when(naceService.getNaceDetails(38542L)).thenReturn(naceResponseDto);

		naceServiceController.getNaceDetails(38542L);
		assertEquals(naceResponseDto.getOrderNumber(), 38542);
	}

}
