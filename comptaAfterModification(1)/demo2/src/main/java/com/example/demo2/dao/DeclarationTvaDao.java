package com.example.demo2.dao;

import com.example.demo2.bean.DeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeclarationTvaDao extends JpaRepository<DeclarationTva,Long> {
    DeclarationTva findByRef(String ref);
    int deleteByRef(String ref);
    List<DeclarationTva> findByAnneeAndMois(double annee, double mois);
    List<DeclarationTva> findByAnneeAndTrim(double annee,double trim);
    List<DeclarationTva> findBySocieteIce(String ice);
    int deleteBySocieteIce(String ice);
    List<DeclarationTva> findByTypeDeclarationTvaRef(String ref);
    int deleteByTypeDeclarationTvaRef(String ref);

}
