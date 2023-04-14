package com.example.demo2.dao;

import com.example.demo2.bean.TypeDeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypedeclarationTvaDao extends JpaRepository<TypeDeclarationTva , Long> {
    TypeDeclarationTva findByRef(String ref);
    int deleteByRef(String ref);

    TypeDeclarationTva findByLibelle(String libelle);
    }
