package com.josephee.cs462.common.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

class EventDispatcherClient {

    @Value("${urls.self}")
    private String self;
    @Value("${urls.service.helper}")
    private String helper;
    @Value("${urls.service.job}")
    private String job;
    @Value("${urls.service.message}")
    private String message;

    private List<String> otherServiceBases;
    RestTemplate restTemplate;

    EventDispatcherClient() {
        this.restTemplate = new RestTemplate();
    }

    List<String> getOtherServiceBases() {
        if(this.otherServiceBases == null) {
            Assert.notNull(self);
            Assert.notNull(helper);
            Assert.notNull(job);
            Assert.notNull(message);

            this.otherServiceBases = new ArrayList<>();
            this.otherServiceBases.add(helper);
            this.otherServiceBases.add(job);
            this.otherServiceBases.add(message);
            Assert.isTrue(this.otherServiceBases.remove(self));
        }

        return this.otherServiceBases;
    }
}
