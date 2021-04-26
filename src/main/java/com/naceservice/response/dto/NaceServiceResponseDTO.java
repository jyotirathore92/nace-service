package com.naceservice.response.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NaceServiceResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long orderNumber;
	private int level;
	private String code;
	private String parent;
	private String description;
	private String itemsIncluded1;
	private String itemsIncluded2;
	private String rulings;
	private String itemsExcluded;
	private String referenceIsicRev4;
	
}
