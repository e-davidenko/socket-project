package com.e.davidenko.socketproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user_", indexes = {
        @Index(name = "idx_securityuser_username", columnList = "USERNAME")
})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "USERNAME", unique = true, length = 50)
    private String username;

    @Column(name = "PASSWORD", length = 500)
    private String password;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"))
    @BatchSize(size = 50)
    private Set<Authority> authorities = new LinkedHashSet<>();

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}