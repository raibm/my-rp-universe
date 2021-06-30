package com.wow.myrpuniverse.controller;

import com.wow.myrpuniverse.exception.CursedException;
import com.wow.myrpuniverse.service.UserService;
import com.wow.myrpuniverse.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.wow.myrpuniverse.util.MessageUtil.REQUEST_TO_CREATE_MSG;
import static com.wow.myrpuniverse.util.MessageUtil.REQUEST_TO_FIND_MSG;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final String ENTITY_NAME = "user";

    private final UserService userService;

    private static Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Salva um novo usuário
     * @param userDto objeto a ser salvo
     * @return novo usuário criado
     */
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        LOGGER.info(REQUEST_TO_CREATE_MSG, ENTITY_NAME);
        UserDto userCreated = userService.save(userDto);
        return ResponseEntity.created(URI.create("/api/user")).body(userCreated);
    }

    /**
     * Busca um novo usuário
     * @param id objeto a ser salvo
     * @return um usuário da base ou um erro 401
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value="id") Long id) {
        LOGGER.info(REQUEST_TO_FIND_MSG, ENTITY_NAME);
        UserDto userFinded = userService.findById(id);
        return ResponseEntity.ok().body(userFinded);
    }
}
