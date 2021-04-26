package com.naceservice.validator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.naceservice.config.NaceServiceTestConfig;
import com.naceservice.dto.NaceServiceRequestDTO;
import com.naceservice.exception.BadRequestException;

public class NaceServiceValidatorTest extends NaceServiceTestConfig {

	@InjectMocks
	private NaceServiceValidator naceServiceValidator;

	@Test
	public void supportsTest() {
		assertTrue(naceServiceValidator.supports(NaceServiceRequestDTO.class));
	}

	@Test
	public void orderNumberValidityTest() {
		NaceServiceRequestDTO request = NaceServiceRequestDTO.builder().orderNumber(0).code("A").description("Test")
				.level(1).referenceIsicRev4("J").build();
		Errors errors = new BeanPropertyBindingResult(request, "NaceServiceRequestDTO");
		try {
		naceServiceValidator.validate(request, errors);
		} catch(BadRequestException ex) {
		assertTrue(errors.hasErrors());
		assertNotNull(errors.getFieldError(NaceServiceValidator.ORDER_NUMBER));
		}
	}
	
	@Test
	public void levelValidityTest() {
		NaceServiceRequestDTO request = NaceServiceRequestDTO.builder().orderNumber(1).code("A").description("Test")
				.level(0).referenceIsicRev4("J").build();
		Errors errors = new BeanPropertyBindingResult(request, "NaceServiceRequestDTO");
		try {
		naceServiceValidator.validate(request, errors);
		} catch(BadRequestException ex) {
		assertTrue(errors.hasErrors());
		assertNotNull(errors.getFieldError(NaceServiceValidator.LEVEL));
		}
	}
	
	@Test
	public void codeValidityTest() {
		NaceServiceRequestDTO request = NaceServiceRequestDTO.builder().orderNumber(1).code(null).description("Test")
				.level(1).referenceIsicRev4("J").build();
		Errors errors = new BeanPropertyBindingResult(request, "NaceServiceRequestDTO");
		try {
		naceServiceValidator.validate(request, errors);
		} catch(BadRequestException ex) {
		assertTrue(errors.hasErrors());
		assertNotNull(errors.getFieldError(NaceServiceValidator.CODE));
		}
	}
	
	@Test
	public void codeEmptyValidityTest() {
		NaceServiceRequestDTO request = NaceServiceRequestDTO.builder().orderNumber(1).code("").description("Test")
				.level(1).referenceIsicRev4("J").build();
		Errors errors = new BeanPropertyBindingResult(request, "NaceServiceRequestDTO");
		try {
		naceServiceValidator.validate(request, errors);
		} catch(BadRequestException ex) {
		assertTrue(errors.hasErrors());
		assertNotNull(errors.getFieldError(NaceServiceValidator.CODE));
		}
	}
	
	@Test
	public void descriptionValidityTest() {
		NaceServiceRequestDTO request = NaceServiceRequestDTO.builder().orderNumber(1).code("A").description(null)
				.level(1).referenceIsicRev4("J").build();
		Errors errors = new BeanPropertyBindingResult(request, "NaceServiceRequestDTO");
		try {
		naceServiceValidator.validate(request, errors);
		} catch(BadRequestException ex) {
		assertTrue(errors.hasErrors());
		assertNotNull(errors.getFieldError(NaceServiceValidator.DESCRIPTION));
		}
	}
	
	@Test
	public void descriptionEmptyValidityTest() {
		NaceServiceRequestDTO request = NaceServiceRequestDTO.builder().orderNumber(1).code("A").description("")
				.level(1).referenceIsicRev4("J").build();
		Errors errors = new BeanPropertyBindingResult(request, "NaceServiceRequestDTO");
		try {
		naceServiceValidator.validate(request, errors);
		} catch(BadRequestException ex) {
		assertTrue(errors.hasErrors());
		assertNotNull(errors.getFieldError(NaceServiceValidator.DESCRIPTION));
		}
	}
	
	@Test
	public void referenceValidityTest() {
		NaceServiceRequestDTO request = NaceServiceRequestDTO.builder().orderNumber(1).code("A").description("Test")
				.level(1).referenceIsicRev4("").build();
		Errors errors = new BeanPropertyBindingResult(request, "NaceServiceRequestDTO");
		try {
		naceServiceValidator.validate(request, errors);
		} catch(BadRequestException ex) {
		assertTrue(errors.hasErrors());
		assertNotNull(errors.getFieldError(NaceServiceValidator.REFERENCE_ISIC_REV_4));
		}
	}
	
	@Test
	public void referenceNullValidityTest() {
		NaceServiceRequestDTO request = NaceServiceRequestDTO.builder().orderNumber(1).code("A").description("Test")
				.level(1).referenceIsicRev4(null).build();
		Errors errors = new BeanPropertyBindingResult(request, "NaceServiceRequestDTO");
		try {
		naceServiceValidator.validate(request, errors);
		} catch(BadRequestException ex) {
		assertTrue(errors.hasErrors());
		assertNotNull(errors.getFieldError(NaceServiceValidator.REFERENCE_ISIC_REV_4));
		}
	}
	
}
