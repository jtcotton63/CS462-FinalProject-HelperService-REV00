package com.josephee.cs462.job.service;

import com.josephee.cs462.job.domain.Helper;
import com.josephee.cs462.job.model.HelperModel;
import com.josephee.cs462.job.repository.HelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("helperService")
public class HelperService {

    @Autowired
    private HelperRepository helperRepository;

    public HelperModel create(HelperModel incoming) {
        incoming.setId(null);
        Helper toBeSaved = new Helper(incoming);
        Helper saved = helperRepository.save(toBeSaved);
        HelperModel toBeReturned = saved.toModel();
        return toBeReturned;
    }

    public Page<HelperModel> getHelpers(Pageable pageable) {
        Page<Helper> helpersPage = helperRepository.findAll(pageable);
        Page<HelperModel> modelsPage = toModelsPage(helpersPage);
        return modelsPage;
    }

    private Page<HelperModel> toModelsPage(Page<Helper> helpersPage) {
        List<Helper> helpers = helpersPage.getContent();
        List<HelperModel> models = new ArrayList<>(helpers.size());
        for(Helper helper : helpers) {
            HelperModel model = helper.toModel();
            models.add(model);
        }

        return new PageImpl<>(
                models,
                new PageRequest(
                        helpersPage.getNumber(),
                        helpersPage.getSize(),
                        helpersPage.getSort()
                ),
                helpersPage.getTotalElements()
        );
    }
}
