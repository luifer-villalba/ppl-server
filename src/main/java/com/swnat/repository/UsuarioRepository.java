package com.swnat.repository;

import com.swnat.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Buscar usuario por correo electronico
     *
     * @param email
     * @return {@link Usuario}
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Buscar usuarios por nombre, apellido o correo electronico.
     *
     * @param nombre
     * @param apellido
     * @param correoElectronico
     * @param pageable
     * @return {@link Page <Usuario>}
     */
    Page<Usuario> findAllByNombreContainsOrApellidoContainsOrEmailContains(String nombre, String apellido,
                                                                                       String correoElectronico,
                                                                                       Pageable pageable);

}
