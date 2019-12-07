package com.demo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Acticle;
import com.demo.service.ActicleService;

@RestController
@RequestMapping("api")
//CẤU HÌNH Access-Control-Allow-Origin CHO ANGULAR GỌI API HOẶC TẠO BEAN CorsConfigurationSource THÌ KHÔNG CẦN NỮA
//@CrossOrigin(origins = "*", allowedHeaders="*")
public class ActicleApiController {

	@Autowired
	private ActicleService acticleService;

	@RequestMapping(method = RequestMethod.GET, value = "acticles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Acticle> findAll(
			@RequestParam(name = "offset", required = false) Integer offset,
			@RequestParam(name = "limit", required = false) Integer limit,
			@RequestParam(name = "sort", required = false) String sort
			) {

		if (offset != null && limit != null) {
			return acticleService.findFilter(offset, limit, sort);
		} else {
			return acticleService.findAll();			
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "acticles/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Acticle findOneById(@PathVariable("id") int id) {
		return acticleService.findOneById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "acticles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Acticle addOne(@RequestBody Acticle acticle) {
		return acticleService.addOne(acticle);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "acticles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Acticle editOne(@RequestBody Acticle acticle) {
		return acticleService.updaeOne(acticle);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "acticles/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String deleteOneById(@PathVariable("id") int id) {
		acticleService.deleteOneById(id);
		return "delete success";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "acticles/count", produces = { MediaType.APPLICATION_JSON_VALUE })
	public long countTotalItem() {
		return acticleService.countTotalItem();
	}
}
