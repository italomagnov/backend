package br.com.rory.listamercado.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rory.listamercado.dto.UserInputDto;
import br.com.rory.listamercado.model.UserModel;
import br.com.rory.listamercado.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserModel> getAllUsers(HttpServletRequest request) {
        return userService.getAllUsers();
    }

    @GetMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUserById(@PathVariable UUID id, HttpServletRequest request) {
        return userService.getUserById((UUID) id);
    }

    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel createUser(@RequestBody UserInputDto userInputDto) {
        return userService.createUser(userInputDto);
    }

    @PutMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserModel updateUser(@PathVariable UUID id, @RequestBody UserInputDto userInputDto) {
        return userService.updateUser((UUID) id, userInputDto);
    }

    @DeleteMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable UUID id, HttpServletRequest request) {
        userService.deleteUser((UUID) id);

        return "Usuario deletado";
    }
}
