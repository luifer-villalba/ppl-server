package com.swnat.controller;

import com.swnat.dto.PaginationResponse;
import com.swnat.model.Postulante;
import com.swnat.service.PostulanteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/postulante")
public class PostulanteController {

    private PostulanteService postulanteService;

    public PostulanteController(PostulanteService postulanteService) {
        this.postulanteService = postulanteService;
    }

    @ApiOperation(value = "Obtener lista de postulantes", notes = "Obtener lista de postulantes filtrando con un texto y devolviendo paginado")
    @GetMapping("/")
    public PaginationResponse<Postulante> getAllPostulante(@RequestParam("filter") String filter, @RequestParam("page") int page, @RequestParam("size") int size) {
        return postulanteService.findByFilter(filter, page, size);
    }

}
