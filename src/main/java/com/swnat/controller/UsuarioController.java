package com.swnat.controller;

import com.swnat.model.Usuario;
import com.swnat.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ApiOperation(value = "Obtener datos de usuario", notes = "Obtener datos de un usuario por identificador")
    @GetMapping("/")
    public List<Usuario> getUsuario(@RequestParam(value = "id") Long id) {
        return usuarioService.findById(id);
    }
    
}
