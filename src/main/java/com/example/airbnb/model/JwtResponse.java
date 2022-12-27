package com.example.airbnb.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private UserDetail userDetail;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, Long id, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
        this.id = id;
    }

    public JwtResponse(String accessToken, Long id, String username, Collection<? extends GrantedAuthority> roles, UserDetail userDetail) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
        this.id = id;
        this.userDetail = userDetail;
    }



    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }
}
