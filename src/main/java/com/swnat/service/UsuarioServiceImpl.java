package com.swnat.service;

import com.swnat.model.Usuario;
import com.swnat.dto.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.swnat.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

}