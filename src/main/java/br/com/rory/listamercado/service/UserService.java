package br.com.rory.listamercado.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rory.listamercado.dto.UserInputDto;
import br.com.rory.listamercado.model.UserModel;
import br.com.rory.listamercado.repository.IUserRepository;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public UserModel createUser(UserInputDto userInputDto) {
        UserModel user = new UserModel();

        user.setName(userInputDto.getName());
        user.setEmail(userInputDto.getEmail());
        user.setUsername(userInputDto.getUsername());
        user.setPassword(userInputDto.getPassword());
        user.setAvatarUrl(userInputDto.getAvatarUrl());

        return userRepository.save(user);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserModel updateUser(UUID id, UserInputDto userInputDto) {
        var user = getUserById((UUID) id);

        if (user != null) {
            user.setName(userInputDto.getName());
            user.setEmail(userInputDto.getEmail());
            user.setUsername(userInputDto.getUsername());
            user.setPassword(userInputDto.getPassword());
            user.setAvatarUrl(userInputDto.getAvatarUrl());
        }

        var userUpdate = userRepository.save(user);

        return userUpdate;
    }

    public void deleteUser(UUID id) {
        var user = getUserById((UUID) id);
        userRepository.delete(user);

    }

}
