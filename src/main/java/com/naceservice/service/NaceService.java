package com.naceservice.service;

import com.naceservice.dto.NaceServiceRequestDTO;
import com.naceservice.response.dto.NaceServiceResponseDTO;

public interface NaceService {

	Long putNaceDetails(NaceServiceRequestDTO naceServiceReqDto);
	NaceServiceResponseDTO getNaceDetails(Long orderNumber);
}
