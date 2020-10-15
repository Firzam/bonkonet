package com.bonkonet.BonkonetApp.Controllers;

import com.bonkonet.BonkonetApp.Services.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService service;
    
}