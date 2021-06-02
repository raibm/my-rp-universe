package com.wow.myrpuniverse.controller;

import com.wow.myrpuniverse.service.UserService;
import com.wow.myrpuniverse.service.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.wow.myrpuniverse.util.MessageUtil.REQUEST_TO_CREATE_MSG;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private static final String ENTITY_NAME = "user";

    private UserService userService;

    private static Logger LOGGER = LogManager.getLogger(UserController.class);

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
}
