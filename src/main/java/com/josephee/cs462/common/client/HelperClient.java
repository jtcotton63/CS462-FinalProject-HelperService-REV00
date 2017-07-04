package com.josephee.cs462.common.client;

import com.josephee.cs462.common.model.helper.HelperModel;
import com.josephee.cs462.common.model.page.HelperPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("helperClient")
public class HelperClient extends Client {

    @Value("${urls.service.helper}")
    private String helperServiceBase;

    public List<HelperModel> getAllHelpers() {
        String url = helperServiceBase + "/helpers?page={page}&size={size}";
        List<HelperModel> helpers = new ArrayList<>();
        int page = 1;
        int size = 2000;

        while(true) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("page", page);
            params.put("size", size);
            HelperPage helperPage = restTemplate.getForObject(url, HelperPage.class, params);
            List<HelperModel> contents = helperPage.getContent();

            if(contents != null)
                helpers.addAll(contents);
            if(helperPage.isLast())
                break;
            else
                page++;
        }

        return helpers;
    }
}
