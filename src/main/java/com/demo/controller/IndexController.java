package com.demo.controller;

import com.demo.repository.CategoryRepository;
import com.demo.util.Crawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
        LOGGER.trace("This is TRACE");
        LOGGER.debug("This is DEBUG");
        LOGGER.info("This is INFO");
        LOGGER.warn("This is WARN");
        LOGGER.error("This is ERROR");

        // System.out.println(sessionFactory);
        System.out.println(categoryRepository.findAll());
        return "index";
    }

    @GetMapping("demo")
    public String demo(ModelMap modelMap) throws IOException {
        List<String> images = Crawler.getAllImage();

        modelMap.addAttribute("images", images);
        return "index";
    }

}
