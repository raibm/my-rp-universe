package com.wow.myrpuniverse.service;

import com.wow.myrpuniverse.service.dto.UserDto;

public interface UserService {

    /**
     * @param userDto Usuário a ser persistido/atualizado.
     * @return Um Usuário devidamente atualizado.
     */
    UserDto save(UserDto userDto);

    /**
     * @param id Chave primária do Usuário usada para realizar a busca.
     * @return Um Usuário caso exista
     */
    UserDto findById(Long id);

}
