package com.swnat.service;

import java.util.List;

import com.swnat.model.Usuario;

import org.springframework.web.bind.annotation.ResponseBody;

import com.swnat.dto.MessageDTO;
import com.swnat.dto.PaginationResponse;

public interface UsuarioService extends IGenericService<Usuario, Long> {
    
    /**
     * Trae los registros que entren en el filtro
     * @param filter
     * @param page
     * @param size
     * @return
     */
    PaginationResponse<Usuario> findByFilter(String filter, int page, int size);

    /**
     * Edita un usuario, ignorando la contraseña
     * @param id
     * @param usuario
     * @return
     */
    Usuario editUser(Long id, Usuario usuario);

    MessageDTO editUserPassword(Long id, String password);
}
