package com.cognizant.spring_learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    public List<Country> getCountries(){
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries =(List<Country>) context.getBean("countryList" );
        return countries;
    }

    public Country getCountryByCode(String code){
        List<Country> countryList = getCountries();

        for (Country country: countryList){
            if(country.getCode().equalsIgnoreCase(code)){
                return country;
            }
        }
        return null;
    }
}
