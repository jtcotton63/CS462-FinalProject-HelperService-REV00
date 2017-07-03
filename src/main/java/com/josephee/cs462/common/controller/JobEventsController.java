package com.josephee.cs462.common.controller;

import com.josephee.cs462.common.handler.JobEventHandler;
import com.josephee.cs462.common.model.event.CreateEvent;
import com.josephee.cs462.common.model.job.JobModel;
import com.josephee.cs462.common.path.EventPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobEventsController {

    private JobEventHandler handler;

    @Autowired
    public JobEventsController(JobEventHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(value = EventPaths.EVENTS_JOBS_CREATE, method = RequestMethod.POST)
    public void jobCreated(@RequestBody CreateEvent<JobModel> event) {
        handler.jobCreated(event);
    }
}
