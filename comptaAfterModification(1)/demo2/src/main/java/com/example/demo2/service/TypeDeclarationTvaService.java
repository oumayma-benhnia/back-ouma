package com.example.demo2.service;

import com.example.demo2.bean.TypeDeclarationTva;
import com.example.demo2.dao.TypedeclarationTvaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class TypeDeclarationTvaService {

    public TypeDeclarationTva findByRef(String ref) {
        return typeDeclarationTvaDao.findByRef(ref);
    }

    public TypeDeclarationTva findByLibelle(String libelle) {
        return typeDeclarationTvaDao.findByLibelle(libelle);
    }

    @Transactional
    public int deleteByRef(String ref) {
        int resultdeclarationtva = declarationTvaService.deleteByTypeDeclarationTvaRef(ref);
        int resulttypedeclarationtva = typeDeclarationTvaDao.deleteByRef(ref);
        return resultdeclarationtva + resulttypedeclarationtva;
    }

    public List<TypeDeclarationTva> findAll() {
        return typeDeclarationTvaDao.findAll();
    }

    public int save(TypeDeclarationTva typeDeclarationTva){
        if (findByRef(typeDeclarationTva.getRef())!=null){
            return -1;
        }else {
            typeDeclarationTvaDao.save(typeDeclarationTva);
            return 1;
        }
    }

    @Autowired
    TypedeclarationTvaDao typeDeclarationTvaDao;
    @Autowired
    DeclarationTvaService declarationTvaService;
}