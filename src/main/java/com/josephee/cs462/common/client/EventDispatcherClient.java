package com.josephee.cs462.common.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

class EventDispatcherClient extends Client {

    @Value("${urls.self}")
    private String self;
    @Value("${urls.service.user}")
    private String userServiceBase;
    @Value("${urls.service.job}")
    private String jobServiceBase;
    @Value("${urls.service.message}")
    private String messageServiceBase;

    private List<String> otherServiceBases;

    List<String> getOtherServiceBases() {
        if(this.otherServiceBases == null) {
            Assert.notNull(self);
            Assert.notNull(userServiceBase);
            Assert.notNull(jobServiceBase);
            Assert.notNull(messageServiceBase);

            this.otherServiceBases = new ArrayList<>();
            this.otherServiceBases.add(userServiceBase);
            this.otherServiceBases.add(jobServiceBase);
            this.otherServiceBases.add(messageServiceBase);
            Assert.isTrue(this.otherServiceBases.remove(self));
        }

        return this.otherServiceBases;
    }
}
