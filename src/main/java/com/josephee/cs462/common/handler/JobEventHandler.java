package com.josephee.cs462.common.handler;

import com.josephee.cs462.common.model.event.CreateEvent;
import com.josephee.cs462.common.model.job.JobModel;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service("jobEventHandler")
public abstract class JobEventHandler extends EventHandler {

    protected JobEventHandler(Logger logger) {
        super(logger);
    }

    public void jobCreated(CreateEvent<JobModel> event) {
        logger.info("Handling job created event " + event.toString());
        jobCreatedChild(event);
    };

    protected abstract void jobCreatedChild(CreateEvent<JobModel> event);
}
