package com.swnat.service;

import com.swnat.model.Usuario;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.swnat.dto.MessageDTO;
import com.swnat.dto.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.swnat.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.core.status.Status;
import io.swagger.models.Response;


@Service
@Transactional
public class UsuarioServiceImpl extends GenericService<Usuario, Long> implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public JpaRepository<Usuario, Long> getRepository() {
        return this.usuarioRepository;
    }

    @Override
    public PaginationResponse<Usuario> findByFilter(String filter, int page, int size) {
        Page<Usuario> searchResult;
        PageRequest pageRequest = PageRequest.of(page, size);

        if (filter == null || filter.isEmpty()) {
            searchResult = usuarioRepository.findAll(pageRequest);
        } else {
            searchResult = usuarioRepository.findAllByNombreContainsOrApellidoContains(filter, pageRequest);
        }

        PaginationResponse<Usuario> response = new PaginationResponse<>();
        response.setContent(searchResult.getContent());
        response.setTotalCount(searchResult.getTotalElements());
        return response;
    }

    @Override
    public Usuario editUser(Long id, Usuario usuario){
        Usuario user = this.getOne(id);
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setEmail(usuario.getEmail());
        user.setRol(usuario.getRol());
        user.setActivo(usuario.isActivo());

        return this.update(id, user);

    }

    @Override  
    public MessageDTO editUserPassword(Long id, String password){
        Usuario user = this.getOne(id);
        user.setClave(password);
        this.update(id, user);
        return new MessageDTO("success");
    }

}