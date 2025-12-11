package com.example.board_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 30)
    private String username;

    @Column(name = "password", nullable = false,length = 30)
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
}
