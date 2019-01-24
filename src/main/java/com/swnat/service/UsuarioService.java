package com.swnat.service;

import java.util.List;

import com.swnat.model.Usuario;

public interface UsuarioService extends IGenericService<Usuario, Long> {

    /**
     * Trae el usuario que corresponde al id
     * @param id
     * @return
     */
    List<Usuario> findById(Long id);

}
