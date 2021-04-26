package com.naceservice.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.naceservice.dto.NaceServiceRequestDTO;
import com.naceservice.exception.BadRequestException;

/**
 * Class to validate the input parameters which are present in the request
 * object
 *
 * @author Jyoti
 */

@Component
public class NaceServiceValidator implements Validator {

	static final String ORDER_NUMBER = "orderNumber";
	static final String LEVEL = "level";
	static final String CODE = "code";
	static final String DESCRIPTION = "description";
	static final String REFERENCE_ISIC_REV_4 = "referenceIsicRev4";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NaceServiceRequestDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		NaceServiceRequestDTO naceServiceRequestDTO = (NaceServiceRequestDTO) target;
		
		if (naceServiceRequestDTO.getOrderNumber() == 0) {
			errors.rejectValue(ORDER_NUMBER, "Please enter order number");
		}
		if (naceServiceRequestDTO.getLevel() == 0) {
			errors.rejectValue(LEVEL, "Please enter level");
		}
		if (null == naceServiceRequestDTO.getCode() || naceServiceRequestDTO.getCode().isEmpty()) {
			errors.rejectValue(CODE, "Please enter code");
		}
		if (null == naceServiceRequestDTO.getDescription() || naceServiceRequestDTO.getDescription().isEmpty()) {
			errors.rejectValue(DESCRIPTION, "Please enter description");
		}
		if (null == naceServiceRequestDTO.getReferenceIsicRev4() || naceServiceRequestDTO.getReferenceIsicRev4().isEmpty()) {
			errors.rejectValue(REFERENCE_ISIC_REV_4, "Please enter reference isic rev");
		}
		if (errors.hasErrors()) {
			throw new BadRequestException(errors.getAllErrors());
		}
	}

}
