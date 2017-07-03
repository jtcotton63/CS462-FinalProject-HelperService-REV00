package com.josephee.cs462.common.client;

import com.josephee.cs462.common.model.event.CreateEvent;
import com.josephee.cs462.common.model.event.UpdatedEvent;
import com.josephee.cs462.common.model.job.JobModel;
import com.josephee.cs462.common.path.EventPaths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("jobEventDispatcherClient")
public class JobEventDispatcherClient extends EventDispatcherClient {

    public JobEventDispatcherClient() {
    }

    public void jobCreated(CreateEvent<JobModel> event) {
        String path = EventPaths.EVENTS_JOBS_CREATE;
        List<String> otherServiceBases = getOtherServiceBases();
        for(String otherServiceBase: otherServiceBases) {
            ResponseEntity<String> response = restTemplate.postForEntity(otherServiceBase + path, event, String.class);
        }
    }

    public void jobUpdated(UpdatedEvent<JobModel> event) {
        String path = EventPaths.EVENTS_JOBS_UPDATE;
        List<String> otherServiceBases = getOtherServiceBases();
        for(String otherServiceBase: otherServiceBases) {
            ResponseEntity<String> response = restTemplate.postForEntity(otherServiceBase + path, event, String.class);
        }
    }
}
