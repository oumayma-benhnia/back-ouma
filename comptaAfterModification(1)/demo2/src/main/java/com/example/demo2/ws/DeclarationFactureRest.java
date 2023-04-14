package com.example.demo2.ws;

import com.example.demo2.bean.DeclarationFacture;
import com.example.demo2.service.DeclarationFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/declarationFacture")
public class DeclarationFactureRest {
    @Autowired
    private DeclarationFactureService declarationFactureService;

    @PostMapping("/")
    public int save(@RequestBody DeclarationFacture declarationFacture) {
        return declarationFactureService.save(declarationFacture);
    }
    @GetMapping("/ref/{ref}")
    public DeclarationFacture findByRef(@PathVariable String ref) {
        return declarationFactureService.findByRef(ref);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByTypeFactureref(@PathVariable String ref) {
        return declarationFactureService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<DeclarationFacture> findAll() {
        return declarationFactureService.findAll();
    }
    @GetMapping("/societeSource/ice/{ice}/annee/{annee}/trim/{trim}")
    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTrim(@PathVariable String ice,@PathVariable double annee,@PathVariable double trim) {
        return declarationFactureService.findBySocieteSourceIceAndAnneeAndTrim(ice, annee, trim);
    }
    @GetMapping("/societeSource/ice/{ice}/annee/{annee}/mois/{mois}/m2")
    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndMois(@PathVariable String ice,@PathVariable double annee,@PathVariable double mois) {
        return declarationFactureService.findBySocieteSourceIceAndAnneeAndMois(ice, annee, mois);
    }
    @GetMapping("/societeSource/ice/{ice}/annee/{annee}/trim/{trim}/typeoperation/{typeoperation}")
    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTrimAndTypeOperation(@PathVariable String ice, @PathVariable double annee,@PathVariable double trim,@PathVariable String typeoperation) {
        return declarationFactureService.findBySocieteSourceIceAndAnneeAndTrimAndTypeOperation(ice, annee, trim, typeoperation);
    }
    @GetMapping("/societeSource/ice/{ice}/annee/{annee}/mois/{mois}/typeoperation/{typeoperation}/m2")
    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndMoisAndTypeOperation(@PathVariable String ice, @PathVariable double annee,@PathVariable double mois,@PathVariable String typeoperation) {
        return declarationFactureService.findBySocieteSourceIceAndAnneeAndMoisAndTypeOperation(ice, annee, mois, typeoperation);
    }
    @PutMapping("/")
    public int update(@RequestBody DeclarationFacture declarationFacture) {
        return declarationFactureService.update(declarationFacture);
    }
    @GetMapping("/societeSource/ice/{ice}/typefacture/{typefacture}")
    public List<DeclarationFacture> findBySocieteSourceIceAndTypeFacture(@PathVariable String ice,@PathVariable String typefacture) {
        return declarationFactureService.findBySocieteSourceIceAndTypeOperation(ice, typefacture);
    }
    @GetMapping("/societeSource/ice/{ice}/annee/{annee}")
    public List<DeclarationFacture> findBySocieteSourceIceAndAnnee(@PathVariable String ice, @PathVariable double annee) {
        return declarationFactureService.findBySocieteSourceIceAndAnnee(ice, annee);
    }
    @GetMapping("/societeSource/ice/{ice}/annee/{annee}/typefacture/{typefacture}")
    public List<DeclarationFacture> findBySocieteSourceIceAndAnneeAndTypeFacture( @PathVariable String ice, @PathVariable double annee, @PathVariable String typefacture) {
        return declarationFactureService.findBySocieteSourceIceAndAnneeAndTypeFacture(ice, annee, typefacture);
    }
}
