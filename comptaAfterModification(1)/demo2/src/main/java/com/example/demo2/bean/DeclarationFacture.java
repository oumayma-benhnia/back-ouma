package com.example.demo2.bean;

import com.example.demo2.service.SocieteService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DeclarationFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateoperation ;

    public Date getDateoperation() {
        return dateoperation;
    }

    public void setDateoperation(Date dateoperation) {
        this.dateoperation = dateoperation;
    }

    private String ref;
    private String libelle;
    private double montantHorsTaxe;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOperatin;
    @ManyToOne
    private DemandeDeclaration demandeDeclaration;

    private Double montantTTC;
    private Double montantTVA;
    @ManyToOne
    private DeclarationTva declarationTva;
    @ManyToOne
    private CategorieComptable categorieComptable;

    public CategorieComptable getCategorieComptable() {
        return categorieComptable;
    }

    public void setCategorieComptable(CategorieComptable categorieComptable) {
        this.categorieComptable = categorieComptable;
    }

    public DeclarationTva getDeclarationTva() {
        return declarationTva;
    }

    public void setDeclarationTva(DeclarationTva declarationTva) {
        this.declarationTva = declarationTva;
    }


    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    @ManyToOne
    private Societe societeSource;
    @ManyToOne
    private Societe societeDistination;

    @ManyToOne
    private DeclarationIR declarationIR;
    @ManyToOne
     private Tva tva;
    private double montantHT;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFacture;
    @ManyToOne
    private TypeFacture typeFacture;
    private double annee;
    private double mois;
    private double trim;

    public double getMontantHorsTaxe() {
        return montantHorsTaxe;
    }

    public void setMontantHorsTaxe(double montantHorsTaxe) {
        this.montantHorsTaxe = montantHorsTaxe;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DemandeDeclaration getDemandeDeclaration() {
        return demandeDeclaration;
    }

    public void setDemandeDeclaration(DemandeDeclaration demandeDeclaration) {
        this.demandeDeclaration = demandeDeclaration;
    }

    public Double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public Double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(Double montantHT) {
        this.montantHT = montantHT;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public TypeFacture getTypeFacture() {
        return typeFacture;
    }

    public void setTypeFacture(TypeFacture typeFacture) {
        this.typeFacture = typeFacture;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Double getMontantTVA() {
        return montantTVA;
    }

    public void setMontantTVA(Double montantTVA) {
        this.montantTVA = montantTVA;
    }

    public Societe getSocieteSource() {
        return societeSource;
    }

    public void setSocieteSource(Societe societeSource) {
        this.societeSource = societeSource;
    }

    public Societe getSocieteDistination() {
        return societeDistination;
    }

    public void setSocieteDistination(Societe societeDistination) {
        this.societeDistination = societeDistination;
    }






    public DeclarationIR getDeclarationIR() {
        return declarationIR;
    }

    public void setDeclarationIR(DeclarationIR declarationIR) {
        this.declarationIR = declarationIR;
    }

}

