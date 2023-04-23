package com.example.demo2.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class DeclarationTva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private double tvacollecter;
    @OneToMany
    private List<DeclarationFacture> declarationFactures ;
    private double tvaperdue;
    private double difftva;
    private double annee;
    private double mois;
    private double trim;
@ManyToOne
    private Societe societe;
@ManyToOne
    private TypeDeclarationTva typeDeclarationTva;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getTvacollecter() {
        return tvacollecter;
    }

    public void setTvacollecter(double tvacollecter) {
        this.tvacollecter = tvacollecter;
    }

    public double getTvaperdue() {
        return tvaperdue;
    }

    public void setTvaperdue(double tvaperdue) {
        this.tvaperdue = tvaperdue;
    }

    public double getDifftva() {
        return difftva;
    }

    public void setDifftva(double difftva) {
        this.difftva = difftva;
    }

    public double getAnnee() {
        return annee;
    }

    public void setAnnee(double annee) {
        this.annee = annee;
    }

    public double getMois() {
        return mois;
    }

    public void setMois(double mois) {
        this.mois = mois;
    }

    public double getTrim() {
        return trim;
    }

    public void setTrim(double trim) {
        this.trim = trim;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public TypeDeclarationTva getTypeDeclarationTva() {
        return typeDeclarationTva;
    }

    public void setTypeDeclarationTva(TypeDeclarationTva typeDeclarationTva) {
        this.typeDeclarationTva = typeDeclarationTva;
    }
}
