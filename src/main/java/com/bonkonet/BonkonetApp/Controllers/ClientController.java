package com.bonkonet.BonkonetApp.Controllers;

import com.bonkonet.BonkonetApp.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping()
    public String test () {
        return "Hello Yahya";
    }

    
}