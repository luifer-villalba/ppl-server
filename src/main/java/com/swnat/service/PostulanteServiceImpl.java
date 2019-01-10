package com.swnat.service;

import com.swnat.dto.PaginationResponse;
import com.swnat.model.Postulante;
import com.swnat.repository.PostulanteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostulanteServiceImpl implements PostulanteService {

    private PostulanteRepository postulanteRepository;

    public PostulanteServiceImpl(PostulanteRepository postulanteRepository) {
        this.postulanteRepository = postulanteRepository;
    }

    @Override
    public PaginationResponse<Postulante> findByFilter(String filter, int page, int size) {
        Page<Postulante> searchResult;
        PageRequest pageRequest = PageRequest.of(page, size);

        if (filter.isEmpty()) {
            searchResult = postulanteRepository.findAll(pageRequest);
        } else {
            searchResult = postulanteRepository.findAllByNombreContainsOrApellidoContains(filter, filter, pageRequest);
        }

        PaginationResponse<Postulante> response = new PaginationResponse<>();
        response.setContent(searchResult.getContent());
        response.setCount(searchResult.getTotalElements());
        return response;
    }

}
