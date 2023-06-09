package com.example.demo2.ws;

import com.example.demo2.bean.TypeDeclarationTva;
import com.example.demo2.service.TypeDeclarationTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/typedeclarationtva")
public class TypeDeclarationTvaRest {

    @GetMapping("ref/{ref}")
    public TypeDeclarationTva findByRef(@PathVariable String ref) {
        return typeDeclarationTvaService.findByRef(ref);
    }

    @GetMapping("libelle/{libelle}")
    public TypeDeclarationTva findByLibelle(@PathVariable String libelle) {
        return typeDeclarationTvaService.findByLibelle(libelle);
    }
    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return typeDeclarationTvaService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<TypeDeclarationTva> findAll() {
        return typeDeclarationTvaService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody TypeDeclarationTva typeDeclarationTva) {
        return typeDeclarationTvaService.save(typeDeclarationTva);
    }

    @Autowired
    TypeDeclarationTvaService typeDeclarationTvaService;
}
