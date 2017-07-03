package com.josephee.cs462.job.controller;

import com.josephee.cs462.job.model.HelperModel;
import com.josephee.cs462.job.service.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helpers")
public class HelperController {

    @Autowired
    private HelperService helperService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long create(@RequestBody HelperModel model) {
        HelperModel saved = helperService.create(model);
        return saved.getId();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<HelperModel> getHelpers(Pageable pageable) {
        Page<HelperModel> modelsPage = helperService.getHelpers(pageable);
        return modelsPage;
    }
}
