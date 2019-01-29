package com.swnat.repository;

import com.swnat.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    /**
     * Obtener el listado de postulantes por alguno de los criterios siguientes:
     * nombre, apellido
     *
     * @return {@link Page <Usuario>}
     */
    @Query("select p from Usuario p where concat(nombre,' ',apellido) like %:filtro% or email like %:filtro% or rol like %:filtro%")
    Page<Usuario> findAllByNombreContainsOrApellidoContains(@Param("filtro") String nombre, Pageable pageable);


}