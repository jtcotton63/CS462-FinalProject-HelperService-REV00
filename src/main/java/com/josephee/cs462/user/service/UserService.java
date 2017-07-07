package com.josephee.cs462.user.service;

import com.josephee.cs462.common.model.user.Role;
import com.josephee.cs462.user.domain.User;
import com.josephee.cs462.common.model.user.UserModel;
import com.josephee.cs462.user.model.AuthenticationModel;
import com.josephee.cs462.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel create(UserModel incoming) {
        incoming.setId(null);
        User toBeSaved = new User(incoming);
        User saved = userRepository.save(toBeSaved);
        UserModel toBeReturned = saved.toModel();
        return toBeReturned;
    }

    public Page<UserModel> getUsers(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        return getUsers(usersPage);
    }

    public Page<UserModel> getUsers(Pageable pageable, Role role) {
        Page<User> usersPage = userRepository.findUsersByRole(role, pageable);
        return getUsers(usersPage);
    }

    private Page<UserModel> getUsers(Page<User> usersPage) {
        Page<UserModel> modelsPage = toModelsPage(usersPage);
        return modelsPage;
    }

    private Page<UserModel> toModelsPage(Page<User> usersPage) {
        List<User> users = usersPage.getContent();
        List<UserModel> models = new ArrayList<>(users.size());
        for(User user : users) {
            UserModel model = user.toModel();
            models.add(model);
        }

        return new PageImpl<>(
                models,
                new PageRequest(
                        usersPage.getNumber(),
                        usersPage.getSize(),
                        usersPage.getSort()
                ),
                usersPage.getTotalElements()
        );
    }

    public UserModel getById(Long id) {
        User user = userRepository.findOne(id);
        return user.toModel();
    }

    public AuthenticationModel authenticate(String username, String password) {
        AuthenticationModel auth;

        User user = userRepository.findOneByUsername(username);
        if(user == null || !user.getPassword().equals(password)) {
            auth = new AuthenticationModel(false);
            return auth;
        }

        // They must have been authenticated
        auth = new AuthenticationModel(true, user.toModel().getId());
        return auth;
    }
}
