package com.integration.assetsRepo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.integration.model.Asset;

@Repository
public interface AssetsRepo extends PagingAndSortingRepository<Asset, Long> {// CrudRepository<Asset, Long>{

	/*
	 * @Override
	 * 
	 * @RestResource(exported = false) void delete(Long id);
	 

	@Override
	@RestResource(exported = false)
	void delete(Asset entity);*/

}

