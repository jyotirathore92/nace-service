package com.naceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.naceservice.dto.NaceServiceRequestDTO;
import com.naceservice.model.NaceDetails;
import com.naceservice.response.dto.NaceServiceResponseDTO;

/**
 * Mapper interface to map the NaceServiceRequestDTO to NaceDetails
 * model and to map NaceDetails to NaceServiceResponseDTO.
 * 
 *
 * @author Jyoti
 */

@Mapper(componentModel = "spring")
public interface NaceServiceMapper {

	NaceServiceMapper INSTANCE = Mappers.getMapper(NaceServiceMapper.class);

	@Mappings({ @Mapping(source = "orderNumber", target = "orderNumber"), @Mapping(source = "level", target = "level"),
			@Mapping(source = "code", target = "code"), @Mapping(source = "parent", target = "parent"),
			@Mapping(source = "description", target = "description"),
			@Mapping(source = "itemsIncluded1", target = "itemsIncluded1"),
			@Mapping(source = "itemsIncluded2", target = "itemsIncluded2"),
			@Mapping(source = "rulings", target = "rulings"),
			@Mapping(source = "itemsExcluded", target = "itemsExcluded"),
			@Mapping(source = "referenceIsicRev4", target = "referenceIsicRev4") })
	NaceDetails toNaceData(NaceServiceRequestDTO naceServiceReqDto);

	@Mappings({ @Mapping(source = "orderNumber", target = "orderNumber"), @Mapping(source = "level", target = "level"),
			@Mapping(source = "code", target = "code"), @Mapping(source = "parent", target = "parent"),
			@Mapping(source = "description", target = "description"),
			@Mapping(source = "itemsIncluded1", target = "itemsIncluded1"),
			@Mapping(source = "itemsIncluded2", target = "itemsIncluded2"),
			@Mapping(source = "rulings", target = "rulings"),
			@Mapping(source = "itemsExcluded", target = "itemsExcluded"),
			@Mapping(source = "referenceIsicRev4", target = "referenceIsicRev4") })
	NaceServiceResponseDTO toNaceResponseDto(NaceDetails naceDetails);
}
