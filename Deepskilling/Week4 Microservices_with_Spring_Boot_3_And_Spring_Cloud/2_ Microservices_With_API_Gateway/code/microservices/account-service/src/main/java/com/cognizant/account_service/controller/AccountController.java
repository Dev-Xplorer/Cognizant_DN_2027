package com.cognizant.account_service.controller;

import com.cognizant.account_service.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/{number}")
    public Account getAccount(@PathVariable String number){
        return new Account(
                number,
                "saving",
                500090.00
        );
    }

}
