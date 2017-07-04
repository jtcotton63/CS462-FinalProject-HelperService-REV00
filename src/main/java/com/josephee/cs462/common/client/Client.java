package com.josephee.cs462.common.client;

import org.springframework.web.client.RestTemplate;

abstract class Client {

    RestTemplate restTemplate;

    Client() {
        this.restTemplate = new RestTemplate();
    }
}
