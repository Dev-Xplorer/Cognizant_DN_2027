package com.cognizant.loan_service.controller;

import com.cognizant.loan_service.model.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @GetMapping("/{number}")
    public Loan getLoan(@PathVariable String number){
        return new Loan(
                number,
                "car",
                40000,
                4500,
                7
        );
    }
}
