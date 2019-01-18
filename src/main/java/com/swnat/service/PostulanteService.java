package com.swnat.service;

import com.swnat.dto.PaginationResponse;
import com.swnat.model.Postulante;

public interface PostulanteService extends IGenericService<Postulante, Long> {

    /**
     * Trae los registros que entren en el filtro
     * @param filter
     * @param page
     * @param size
     * @return
     */
    PaginationResponse<Postulante> findByFilter(String filter, int page, int size);

}
