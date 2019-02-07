package com.swnat.controller;

import com.swnat.model.Usuario;
import com.swnat.dto.MessageDTO;
import com.swnat.dto.PaginationResponse;
import com.swnat.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
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

    @ApiOperation(value = "Cambiar contraseña", notes = "Actualiza la contraseña de un usuario")
    @PutMapping("/{id}/change-password")
    public ResponseEntity updatePassword(@Valid @RequestBody String password, @PathVariable Long id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.editUserPassword(id, password));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO("error"));
        }
    }
    
}
