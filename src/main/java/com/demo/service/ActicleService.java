package com.demo.service;

import java.util.List;

import com.demo.entity.Acticle;

public interface ActicleService {
	public List<Acticle> findAll();
	public Acticle findOneById(int id);
	public Acticle addOne(Acticle acticle);
	public Acticle updaeOne(Acticle acticle);
	public void deleteOneById(int id);
	public List<Acticle> findFilter(int offset, int limit, String sort);
	public long countTotalItem();
	
}
