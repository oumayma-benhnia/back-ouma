package com.example.demo2.dao;

import com.example.demo2.bean.DeclarationFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DeclarationFactureDao extends JpaRepository<DeclarationFacture,Long> {
    DeclarationFacture findByRef(String ref);
    int deleteByRef(String ref);
    List<DeclarationFacture> findBySocieteSourceIceAndAnnee(String ice, double annee);
    List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTrim(String ice, double annee, double trim);
    List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndMois(String ice, double annee, double mois);
    List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTrimAndTypeFacture(String ice, double annee,double trim,String typeoperation);
    List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndMoisAndTypeFacture(String ice, double annee,double mois,String typeoperation);
    List<DeclarationFacture> findBySocieteSourceIceAndTypeFacture(String ice,String typeoperation);

    List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTypeFacture(String ice, double annee,String typeoperation);
List<DeclarationFacture> findByAnneeAndMois (double annee , double mois);
}
