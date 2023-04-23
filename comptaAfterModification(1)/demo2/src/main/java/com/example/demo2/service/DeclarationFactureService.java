package com.example.demo2.service;

import com.example.demo2.bean.CategorieComptable;
import com.example.demo2.bean.DeclarationFacture;
import com.example.demo2.bean.Societe;
import com.example.demo2.bean.Tva;
import com.example.demo2.dao.DeclarationFactureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class DeclarationFactureService {
    @Autowired
    private DeclarationFactureDao declarationFactureDao;
    @Autowired
    private TvaSevice tvaService;
    @Autowired
    private  DeclarationTvaService declarationTvaService;
@Autowired
  private SocieteService societeService;
    @Autowired
    private CategorieComptableService comptComptableService;
    @Autowired
    private DeclarationIRService declarationIRService;
    public int save(DeclarationFacture declarationFacture){
        if (findByRef(declarationFacture.getRef()) != null) {
            return -1;
        }else{
            declarationFactureDao.save(declarationFacture);
            return 1;
        }
    }

    public DeclarationFacture findByRef(String ref) {
        return declarationFactureDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return declarationFactureDao.deleteByRef(ref);
    }

    public List<DeclarationFacture> findAll() {
        return declarationFactureDao.findAll();
    }
    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTrim(String ice, double annee, double trim) {
        return declarationFactureDao.findBySocieteSourceIceAndAnneeAndTrim(ice, annee, trim);
    }
    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndMois(String ice, double annee, double mois) {
        return declarationFactureDao.findBySocieteSourceIceAndAnneeAndMois(ice, annee, mois);
    }


    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTrimAndTypeOperation(String ice, double annee, double trim, String typeoperation) {
        return declarationFactureDao.findBySocieteSourceIceAndAnneeAndTrimAndTypeFacture(ice, annee, trim, typeoperation);
    }

    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndMoisAndTypeOperation(String ice, double annee, double mois, String typeoperation) {
        return declarationFactureDao.findBySocieteSourceIceAndAnneeAndMoisAndTypeFacture(ice, annee, mois, typeoperation);
    }

    public List<DeclarationFacture> findBySocieteSourceIceAndTypeOperation(String ice, String typeoperation) {
        return declarationFactureDao.findBySocieteSourceIceAndTypeFacture(ice, typeoperation);
    }
    public int update(DeclarationFacture declarationFacture){
        Societe societeS = societeService.findByIce(declarationFacture.getSocieteSource().getIce());
        declarationFacture.setSocieteSource(societeS);
        Societe societeD = societeService.findByIce(declarationFacture.getSocieteDistination().getIce());
        declarationFacture.setSocieteDistination(societeD);
        Tva tv = tvaService.findByRef(declarationFacture.getTva().getRef());
        declarationFacture.setTva(tv);
        CategorieComptable cpt = comptComptableService.findByCode(declarationFacture.getCategorieComptable().getCode());
        declarationFacture.setCategorieComptable(cpt);
        DeclarationFacture facture1 = declarationFactureDao.findByRef(declarationFacture.getRef());

        if (societeS == null) {
            return -1;
        } else if (societeD == null || societeD == societeS) {
            return -2;
        } else if (tv == null) {
            return -3;
        } else if (cpt == null) {
            return -4;
        }

        else{

            declarationFacture.setMontantTVA((declarationFacture.getMontantHorsTaxe() * declarationFacture.getTva().getValeur()) /100);
            declarationFacture.setMontantTTC(declarationFacture.getMontantHorsTaxe() + declarationFacture.getMontantTVA());
            declarationFacture.setTrim(Trouvertrim(declarationFacture.getDateoperation()));
            declarationFacture.setMois(declarationFacture.getDateoperation().getMonth() +1);
            declarationFacture.setAnnee(declarationFacture.getDateoperation().getYear() + 1900);

            declarationFactureDao.save(declarationFacture);
            return 1;
        }}
        public double Trouvertrim( Date myDate){

            if((myDate.getMonth() +1) <= 3){
                return 1;
            }
            else if((myDate.getMonth() +1) > 3 && (myDate.getMonth() +1) <= 6){
                return 2;
            }
            else if((myDate.getMonth() +1) > 6 && (myDate.getMonth() +1) <= 9){
                return 3;
            }

            else {
                return 4;}
        }
    public List<DeclarationFacture> findBySocieteSourceIceAndAnnee(String ice, double annee) {
        return declarationFactureDao.findBySocieteSourceIceAndAnnee(ice, annee);
    }
    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTypeFacture(String ice, double annee, String typefacture) {
        return declarationFactureDao.findBySocieteSourceIceAndAnneeAndTypeFacture(ice, annee, typefacture);
    }

        }

