package com.swnat.controller;

import com.swnat.dto.PaginationResponse;
import com.swnat.model.Postulante;
import com.swnat.service.PostulanteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/postulante")
public class PostulanteController {

    private PostulanteService postulanteService;

    public PostulanteController(PostulanteService postulanteService) {
        this.postulanteService = postulanteService;
    }

    @ApiOperation(value = "Obtener lista de postulantes", notes = "Obtener lista de postulantes filtrando con un texto y devolviendo paginado")
    @GetMapping("/")
    public PaginationResponse<Postulante> getAllPostulante(@RequestParam(value = "filter", required = false) String filter, @RequestParam("page") int page, @RequestParam("size") int size) {
        return postulanteService.findByFilter(filter, page, size);
    }

    @ApiOperation(value = "Crear un postulante", notes = "Crea un nuevo postulante.")
    @PostMapping("/")
    public Postulante savePostulante(@Valid @RequestBody Postulante postulante) {
        return postulanteService.add(postulante);
    }

    @ApiOperation(value = "Editar un postulante", notes = "Actualiza datos de un postulante ya existente.")
    @PutMapping("/{id}")
    public Postulante updatePostulante(@Valid @RequestBody Postulante postulante, @PathVariable Long id) {
        return postulanteService.update(id, postulante);
    }
    
}
