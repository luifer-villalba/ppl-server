package com.swnat.repository;

import com.swnat.model.Postulante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostulanteRepository extends JpaRepository<Postulante, Long> {

    /**
     * Obtener el listado de postulantes por alguno de los criterios siguientes:
     * nombre, apellido
     *
     * @return {@link Page <Postulante>}
     */
    @Query("select p from Postulante p where concat(nombre,' ',apellido) like %:nombre% or documento like %:documento%")
    Page<Postulante> findAllByNombreContainsOrApellidoContains(@Param("nombre") String nombre, @Param("documento") String documento, Pageable pageable);

}
