package com.demo.controller;

import com.demo.repository.CategoryRepository;
import com.demo.util.Crawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

//	@Autowired
//	private ActicleService acticleService;

    @Autowired
    private CategoryRepository categoryRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("index")
    public String index() {
//        LOGGER.trace("This is TRACE");
//        LOGGER.debug("This is DEBUG");
//        LOGGER.info("This is INFO");
//        LOGGER.warn("This is WARN");
//        LOGGER.error("This is ERROR");

        // System.out.println(sessionFactory);
        System.out.println("ffffffhhhhhhhhhhhhhhfffff");
        System.out.println(categoryRepository.findAll());
        return "view";
    }

    @GetMapping(value = {"demo"})
    public String demo(@RequestParam(name = "page", required = false) Integer page, ModelMap modelMap) throws IOException {
        if (page == null) page = 1;
        List<String> images = Crawler.getAllImage(page);

        modelMap.addAttribute("images", images);
        modelMap.addAttribute("page", page);
        int a = 16;
        modelMap.addAttribute("numberOfPages", a);
        return "index";
    }

}
