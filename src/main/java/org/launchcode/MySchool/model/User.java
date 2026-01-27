package org.launchcode.MySchool.model;
import jakarta.persistence.*;
import org.launchcode.MySchool.model.Role;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String password;

        @Enumerated(EnumType.STRING)
        private Role role;
    }


