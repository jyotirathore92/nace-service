package com.naceservice.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naceservice.dto.NaceServiceRequestDTO;
import com.naceservice.exception.NoContentException;
import com.naceservice.mapper.NaceServiceMapper;
import com.naceservice.model.NaceDetails;
import com.naceservice.repository.NaceServiceRepository;
import com.naceservice.response.dto.NaceServiceResponseDTO;
import com.naceservice.service.NaceService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service class containing the business logic to add and retrieve NACE
 * details
 * 
 *
 * @author Jyoti
 */

@Service
@Slf4j
public class NaceServiceImpl implements NaceService{

	@Autowired
	private NaceServiceMapper naceMapper;
	
	
	@Autowired
	private NaceServiceRepository naceRepository;
	
	/**
	 * Method to add the NACE details that comes from the client into the
	 * database. It maintains the transaction and rollsback in case of any issue.
	 *
	 * @param naceServiceReqDto object which contains the request attributes for
	 *                         adding NACE details in the application
	 * @return orderNumber response after pushing the data into the
	 *         database
	 */
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long putNaceDetails(NaceServiceRequestDTO naceServiceReqDto) {
		// TODO Auto-generated method stub
		NaceDetails naceDetails = naceMapper.toNaceData(naceServiceReqDto);
		naceDetails.setCreationDate(new Date());
		NaceDetails naceDetailsAfterSaving = naceRepository.save(naceDetails);
		return naceDetailsAfterSaving.getOrderNumber();
	}

	/**
	 * Method to get the NACE details for a specific orderNumber
	 *
	 *@param orderNumber parameter for which the NACE data is requested
	 *                         
	 * @return NaceServiceResponseDTO contains all the NACE data for the requested orderNumber
	 *         
	 */
	
	@Override
	public NaceServiceResponseDTO getNaceDetails(Long orderNumber) {
		NaceDetails naceDetails = naceRepository.findByOrderNumber(orderNumber);
		log.info("naceDetails :{}",naceDetails);
		if(null == naceDetails) {
			throw new NoContentException("No data found for order "+orderNumber);
		}
		return naceMapper.toNaceResponseDto(naceDetails);
	}

}
