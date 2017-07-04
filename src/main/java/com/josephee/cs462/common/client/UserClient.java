package com.josephee.cs462.common.client;

import com.josephee.cs462.common.model.user.Role;
import com.josephee.cs462.common.model.user.UserModel;
import com.josephee.cs462.common.model.page.UserPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service("userClient")
public class UserClient extends Client {

    @Value("${urls.service.user}")
    private String userServiceBase;

    public List<UserModel> getUsers(Optional<Role> roleOpt) {
        String url = userServiceBase + "/users?page={page}&size={size}";
        List<UserModel> users = new ArrayList<>();
        int page = 1;
        int size = 2000;

        if(roleOpt.isPresent())
            url += "&role={role}";

        while(true) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("page", page);
            params.put("size", size);

            if(roleOpt.isPresent()) {
                Role role = roleOpt.get();
                params.put("role", role.getId());
            }

            UserPage userPage = restTemplate.getForObject(url, UserPage.class, params);
            List<UserModel> contents = userPage.getContent();

            if(contents != null)
                users.addAll(contents);
            if(userPage.isLast())
                break;
            else
                page++;
        }

        return users;
    }
}
