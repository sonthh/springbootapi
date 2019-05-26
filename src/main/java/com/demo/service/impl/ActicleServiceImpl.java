package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entity.Acticle;
import com.demo.repository.ActicleRepository;
import com.demo.service.ActicleService;
import com.demo.util.OffsetBasedPageRequest;

@Service
public class ActicleServiceImpl implements ActicleService {

	@Autowired
	private ActicleRepository acticleRepository;
	
	@Override
	public List<Acticle> findAll() {
		List<Acticle> acticles = new ArrayList<>();
		acticleRepository.findAll().forEach(a -> {
			acticles.add(a);
		});
		return acticles;
	}

	@Override
	public Acticle findOneById(int id) {
		Optional<Acticle> optional = acticleRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Acticle addOne(Acticle acticle) {
		return acticleRepository.save(acticle);
	}

	@Override
	public Acticle updaeOne(Acticle acticle) {
		return acticleRepository.save(acticle);
	}

	@Override
	public void deleteOneById(int id) {
		acticleRepository.deleteById(id);
	}

	@Override
	public List<Acticle> findFilter(int offset, int limit, String sort) {
		Sort sortBy = Sort.by(sort).descending();
		Pageable pageable = new OffsetBasedPageRequest(offset, limit, sortBy);
		return acticleRepository.findFilter(pageable);
	}

	@Override
	public long countTotalItem() {
		return acticleRepository.count();
	}

}
