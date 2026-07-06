package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private CountryService countryService;
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping("/country")
    public Country getCountryIndia(){
        logger.info("START : getCountryIndia()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("countryIndia" , Country.class);
        logger.info("END : getCountryIndia()");
        return country;
    }

    @GetMapping("country/{code}")
    public Country getCountryByCode(@PathVariable String code){
        Country country = countryService.getCountryByCode(code);
        return country;
    }
}
