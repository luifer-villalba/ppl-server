package com.swnat.security;

import com.swnat.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UsuarioPrincipal implements UserDetails {

    private Long idUsuario;

    private String username;

    private String nombre;

    private String apellido;

    private String password;

    private String email;

    private final Collection<? extends GrantedAuthority> authorities;

    private boolean enabled;

    private UsuarioPrincipal(Long idUsuario, String nombre, String apellido, String username, String password,
                             String email, Collection<? extends GrantedAuthority> authorities,
                             boolean enabled) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.username = username;
        this.apellido = apellido;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    public static UsuarioPrincipal create(Usuario usuario) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRol()));

        return new UsuarioPrincipal(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getClave(),
                usuario.getEmail(),
                authorities,
                usuario.isActivo()
        );
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPrincipal that = (UsuarioPrincipal) o;
        return Objects.equals(idUsuario, that.idUsuario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUsuario);
    }
}