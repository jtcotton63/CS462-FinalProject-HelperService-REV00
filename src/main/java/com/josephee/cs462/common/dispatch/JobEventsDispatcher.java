package com.josephee.cs462.common.dispatch;

import com.josephee.cs462.common.client.JobEventDispatcherClient;
import com.josephee.cs462.common.model.event.CreateEvent;
import com.josephee.cs462.common.model.event.UpdatedEvent;
import com.josephee.cs462.common.model.job.JobModel;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("jobEventsDispatcher")
public class JobEventsDispatcher extends EventsDispatcher {

    private JobEventDispatcherClient client;

    JobEventsDispatcher(JobEventDispatcherClient client) {
        super(LoggerFactory.getLogger(JobEventsDispatcher.class));
        this.client = client;
    }

    public void jobCreated(CreateEvent<JobModel> event) {
        logger.info("Firing job created event " + event.toString());
        client.jobCreated(event);
    }

    public void jobUpdated(UpdatedEvent<JobModel> event) {
        logger.info("Firing job updated event " + event.toString());
        client.jobUpdated(event);
    }
}