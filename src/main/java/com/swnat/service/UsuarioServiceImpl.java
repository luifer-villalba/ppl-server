package com.swnat.service;

import com.swnat.model.Usuario;
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
    public List<Usuario> findById(Long id) {
        return usuarioRepository.findUsuarioById(id);
    }

}