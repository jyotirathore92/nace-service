package com.naceservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.naceservice.config.NaceServiceTestConfig;
import com.naceservice.dto.NaceServiceRequestDTO;
import com.naceservice.exception.NoContentException;
import com.naceservice.impl.NaceServiceImpl;
import com.naceservice.mapper.NaceServiceMapper;
import com.naceservice.model.NaceDetails;
import com.naceservice.repository.NaceServiceRepository;

public class NaceServiceTest extends NaceServiceTestConfig {

	@InjectMocks
	private NaceServiceImpl naceServiceImpl;

	@Mock
	NaceServiceMapper naceMapper;

	@Mock
	NaceServiceRepository naceRepository;

	@Test
	public void putNaceDetailsTest() {

		NaceServiceRequestDTO request = new NaceServiceRequestDTO(1234, 1, "J", "", "Agriculture", "include",
				"include1", "", "", "B");

		NaceDetails naceDetails = NaceDetails.builder().code("J").description("Agriculture").itemsIncluded1("include")
				.itemsIncluded2("include1").level(1).orderNumber(1234).parent(null).rulings(null).referenceIsicRev4("B")
				.build();

		NaceDetails naceDetailsAfterSaving = NaceDetails.builder().id(1).code("J").description("Agriculture")
				.itemsIncluded1("include").itemsIncluded2("include1").level(1).orderNumber(1234).parent(null)
				.rulings(null).referenceIsicRev4("B").creationDate(new Date()).build();
		when(naceMapper.toNaceData(request)).thenReturn(naceDetails);
		when(naceRepository.save(naceDetails)).thenReturn(naceDetailsAfterSaving);

		naceServiceImpl.putNaceDetails(request);

		verify(naceRepository, times(1)).save(naceDetails);
	}

	@Test
	public void getNaceDetailsTest() {

		NaceDetails naceDetails = NaceDetails.builder().id(1).code("J").description("Agriculture")
				.itemsIncluded1("include").itemsIncluded2("include1").level(1).orderNumber(1234).parent(null)
				.rulings(null).referenceIsicRev4("B").creationDate(new Date()).build();

		when(naceRepository.findByOrderNumber(1234L)).thenReturn(naceDetails);

		naceServiceImpl.getNaceDetails(1234L);

		verify(naceRepository, times(1)).findByOrderNumber(1234L);
	}

	@Test
	public void getNaceDetailsThrowTest() {

		NaceDetails naceDetails = null;
		long ordernumber = 1234;
		try {
			when(naceRepository.findByOrderNumber(ordernumber)).thenReturn(naceDetails);
			naceServiceImpl.getNaceDetails(ordernumber);
		} catch (NoContentException ex) {
			assertEquals("No data found for order " + ordernumber, ex.getMessage());
		}

	}

}
