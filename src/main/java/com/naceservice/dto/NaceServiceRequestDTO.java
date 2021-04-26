package com.naceservice.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NaceServiceRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private long orderNumber;
	
	@NotNull
	private int level;
	
	@NotNull
	private String code;
	
	private String parent;
	
	@NotNull
	private String description;
	private String itemsIncluded1;
	private String itemsIncluded2;
	private String rulings;
	private String itemsExcluded;
	
	@NotNull
	private String referenceIsicRev4;
	
}
