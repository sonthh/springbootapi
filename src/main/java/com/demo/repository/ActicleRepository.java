package com.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Acticle;

@Repository
public interface ActicleRepository extends CrudRepository<Acticle, Integer>  {
	@Query("from Acticle")//jpal hql
	public List<Acticle> findFilter(Pageable pageable);
}
