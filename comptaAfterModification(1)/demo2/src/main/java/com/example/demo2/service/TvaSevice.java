package com.example.demo2.service;

import com.example.demo2.bean.Tva;
import com.example.demo2.dao.TvaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TvaSevice {
    @Autowired
    private TvaDao tvaDao;

    public Tva findByRef(String ref) {
        return tvaDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return tvaDao.deleteByRef(ref);
    }

    public List<Tva> findAll() {
        return tvaDao.findAll();
    }
    public int save(Tva tva){
        tvaDao.save(tva);
        return 1;
    }
}
