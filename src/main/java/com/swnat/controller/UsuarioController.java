package com.swnat.controller;

import com.swnat.model.Usuario;
import com.swnat.dto.PaginationResponse;
import com.swnat.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ApiOperation(value = "Obtener datos de usuario", notes = "Obtener datos de un usuario por identificador")
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.getOne(id);
    }

    @ApiOperation(value = "Obtener lista de usuarios", notes = "Obtener lista de usuarios filtrando con un texto y devolviendo paginado")
    @GetMapping("/")
    public PaginationResponse<Usuario> getAllUsuarios(@RequestParam(value = "filter", required = false) String filter, @RequestParam("page") int page, @RequestParam("size") int size) {
        return usuarioService.findByFilter(filter, page, size);
    }

    @ApiOperation(value = "Crear un usuario", notes = "Crea un nuevo usuario.")
    @PostMapping("/")
    public Usuario saveUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.add(usuario);
    }

    @ApiOperation(value = "Editar un usuario", notes = "Actualiza datos de un usuario ya existente sin cambiar la contraseña")
    @PutMapping("/{id}")
    public Usuario updateUsuario(@Valid @RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioService.editUser(id, usuario);
    }
    
}
