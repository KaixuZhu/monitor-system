package com.zr.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {
    private Integer id;
    private String roleName;
    private String roleDesc;
    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
