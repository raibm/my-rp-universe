package com.wow.myrpuniverse.service;

import com.wow.myrpuniverse.exception.CursedException;
import com.wow.myrpuniverse.service.dto.UserDto;
import javassist.NotFoundException;

public interface UserService {

    /**
     * @param userDto Usuário a ser persistido.
     * @return Um novo usuário.
     */
    UserDto save(UserDto userDto);

    /**
     * @param id Chave primária do Usuário usada para realizar a busca.
     * @return Um usuário caso exista
     */
    UserDto findById(Long id) throws CursedException, NotFoundException;

}
