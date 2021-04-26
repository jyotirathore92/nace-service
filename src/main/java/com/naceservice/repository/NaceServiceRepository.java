package com.naceservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naceservice.model.NaceDetails;

@Repository
public interface NaceServiceRepository extends CrudRepository<NaceDetails, Long>{

	NaceDetails findByOrderNumber(Long orderNumber);
}
