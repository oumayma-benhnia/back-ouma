package com.example.demo2.service;

import com.example.demo2.bean.DeclarationFacture;
import com.example.demo2.bean.DeclarationTva;
import com.example.demo2.bean.Societe;
import com.example.demo2.bean.TypeDeclarationTva;
import com.example.demo2.dao.DeclarationTvaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeclarationTvaService {
    @Autowired
    TypeDeclarationTvaService typeDeclarationTvaService;
    @Autowired
    private DeclarationTvaDao declarationTvaDao;
    @Autowired
    SocieteService societeService;
    @Autowired
    DeclarationFactureService declarationFactureService;
   public DeclarationTva findByRef(String ref) {
            return declarationTvaDao.findByRef(ref);
        }
    @Transactional
    public int deleteByRef(String ref) {
        return declarationTvaDao.deleteByRef(ref);
    }

    public List<DeclarationTva> findBySocieteIce(String ice) {
        return declarationTvaDao.findBySocieteIce(ice);
    }
    @Transactional
    public int deleteBySocieteIce(String ice) {
        return declarationTvaDao.deleteBySocieteIce(ice);
    }

    public List<DeclarationTva> findByTypeDeclarationTvaRef(String ref) {
        return declarationTvaDao.findByTypeDeclarationTvaRef(ref);
    }
    @Transactional
    public int deleteByTypeDeclarationTvaRef(String ref) {
        return declarationTvaDao.deleteByTypeDeclarationTvaRef(ref);
    }
    public List<DeclarationTva> findAll() {
        return declarationTvaDao.findAll();
    }
    public int save(DeclarationTva declarationTva){
        declarationTva.setRef(System.currentTimeMillis()+"");// générer une référence unique pour cette déclaration en utilisant la méthode System.currentTimeMillis()
        if (findByRef(declarationTva.getRef())!=null){
            return -1;
        }
        Societe s = societeService.findByIce(declarationTva.getSociete().getIce());
        declarationTva.setSociete(s);
        TypeDeclarationTva t = typeDeclarationTvaService.findByRef(declarationTva.getTypeDeclarationTva().getRef());
        declarationTva.setTypeDeclarationTva(t);
        if (s==null){
            return  -2;
        }
        else if (t==null){
            return -3;
        }else {
            declarationTvaDao.save(declarationTva);
            List<DeclarationFacture> declarationFactures = new ArrayList<DeclarationFacture>();
            double tvac = 0,tvap = 0,dtva = 0;
            if (declarationTva.getTypeDeclarationTva().getLibelle().equals("trimestrielle")){
                declarationFactures = declarationFactureService.findBySocieteSourceIceAndAnneeAndTrim(declarationTva.getSociete().getIce(),declarationTva.getAnnee(),declarationTva.getTrim());
            }else {
                declarationFactures = declarationFactureService.findBySocieteSourceIceAndAnneeAndMois(declarationTva.getSociete().getIce(),declarationTva.getAnnee(),declarationTva.getMois());
            }
            DeclarationTva myDeclarationTva = findByRef(declarationTva.getRef());
            for (DeclarationFacture declarationFacture:declarationFactures){
                if (declarationFacture.getTypeFacture().equals("type-1")){
                    tvac += declarationFacture.getMontantTVA();
                    declarationFacture.setDeclarationTva(myDeclarationTva);
                    declarationFactureService.update(declarationFacture);
                }else {
                    tvap += declarationFacture.getMontantTVA();
                    declarationFacture.setDeclarationTva(myDeclarationTva);
                    declarationFactureService.update(declarationFacture);
                }
            }
            myDeclarationTva.setTvacollecter(tvac);
            myDeclarationTva.setTvaperdue(tvap);
            dtva = tvac - tvap;
            myDeclarationTva.setDifftva(dtva);
            declarationTvaDao.save(myDeclarationTva);
            return 1;
        }
    }
   /* public DeclarationTvaVo2 findfacturesandcalcultva(DeclarationTvaVo1 declarationTvaVo1){
        DeclarationTvaVo2 declarationTvaVo2 = new DeclarationTvaVo2();
        List<DeclarationFacture> facturesvente = new ArrayList<DeclarationFacture>();
        List<DeclarationFacture> facturesachat = new ArrayList<DeclarationFacture>();
        double tvacollecter = 0,tvadeductible = 0,differencetva = 0;
        if (declarationTvaVo1.getTypedeclarationtva().equals("TDTV1")){
            facturesvente = declarationFactureService.findBySocieteSourceIceAndAnneeAndTrimAndTypeOperation(declarationTvaVo1.getSocieteref(),declarationTvaVo1.getAnnee(),declarationTvaVo1.getTrim(),"type-1");
            facturesachat = declarationFactureService.findBySocieteSourceIceAndAnneeAndTrimAndTypeOperation(declarationTvaVo1.getSocieteref(),declarationTvaVo1.getAnnee(),declarationTvaVo1.getTrim(),"type-2");
        }else {
            facturesvente = declarationFactureService.findBySocieteSourceIceAndAnneeAndMoisAndTypeOperation(declarationTvaVo1.getSocieteref(),declarationTvaVo1.getAnnee(),declarationTvaVo1.getMois(),"type-1");
            facturesachat = declarationFactureService.findBySocieteSourceIceAndAnneeAndMoisAndTypeOperation(declarationTvaVo1.getSocieteref(),declarationTvaVo1.getAnnee(),declarationTvaVo1.getMois(),"type-2");
        }
        for (DeclarationFacture declarationFacture: facturesvente) {
            tvacollecter += declarationFacture.getMontantTVA();
        }
        for (DeclarationFacture declarationFacture:facturesachat) {
            tvadeductible += declarationFacture.getMontantTVA();
        }
        declarationTvaVo2.setListfacturevente(facturesvente);
        declarationTvaVo2.setListfactureachat(facturesachat);
        declarationTvaVo2.setTvacollecter(tvacollecter);
        declarationTvaVo2.setTvadeductible(tvadeductible);
        differencetva = tvacollecter - tvadeductible;
        declarationTvaVo2.setDifferencetva(differencetva);
        return declarationTvaVo2;
    }*/
   public List<DeclarationTva> findByAnneeAndMois(double annee, double mois) {
       return declarationTvaDao.findByAnneeAndMois(annee, mois);
   }

    public List<DeclarationTva> findByAnneeAndTrim(double annee, double trim) {
        return declarationTvaDao.findByAnneeAndTrim(annee, trim);
    }
}
