package com.naceservice.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NaceDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "NACE_SEQ", allocationSize = 1)
	private long id;
	
	@Column(name = "ORDER_NUMBER", unique = true, nullable = false)
	private long orderNumber;
	
	@Column(name = "LEVEL", nullable = false)
	private int level;
	
	@Column(name = "CODE", nullable = false)
	private String code;
	
	@Column(name = "PARENT")
	private String parent;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name = "ITEMS_INCLUDED_1")
	private String itemsIncluded1;
	
	@Column(name = "ITEMS_INCLUDED_2")
	private String itemsIncluded2;
	
	@Column(name = "RULINGS")
	private String rulings;
	
	@Column(name = "ITEMS_EXCLUDED")
	private String itemsExcluded;
	
	@Column(name = "REFERENCE_ISIC_REV_4", nullable = false)
	private String referenceIsicRev4;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;

}
