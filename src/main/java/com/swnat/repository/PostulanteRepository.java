package com.swnat.repository;

import com.swnat.model.Postulante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulanteRepository extends JpaRepository<Postulante, Long> {

    /**
     * Obtener el listado de postulantes por alguno de los criterios siguientes:
     * nombre, apellido
     *
     * @param nombre
     * @param apellido
     * @param pageable
     * @return {@link Page <Postulante>}
     */
    Page<Postulante> findAllByNombreContainsOrApellidoContains(String nombre, String apellido, Pageable pageable);

}
