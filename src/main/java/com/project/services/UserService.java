package com.project.services;

import com.project.entities.User;
import com.project.enums.Role;
import com.project.forms.RegistrationForm;
import com.project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private User createUser(User user) {
        return userRepository.save(user);
    }

    public User createUserfromForm(RegistrationForm form, Role role) {

        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setGender(form.getGender());
        user.setPassword(form.getPassword());
        user.setRole(role);
        return createUser(user);
    }

    public List<User> getUsersByRole(Role role) {
        return userRepository.findUserByRole(role);
    }

    public void deleteUser(int id) {
        User user = userRepository.findById(id).get();
        if (user.getRole() == Role.LIBRARIAN) {
            userRepository.delete(user);
        }
    }


    public void banUser(int id, boolean value) {
        User user = userRepository.findById(id).get();
        user.setBanList(value);

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById (int id){
        return userRepository.findById(id).get();
    }
}
