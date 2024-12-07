package com.klef.jfsd.springboot.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;

@Entity
@Data
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;

    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String image;
}
