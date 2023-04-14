package com.example.demo2.dao;

import com.example.demo2.bean.Tva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TvaDao extends JpaRepository< Tva ,Long> {
public Tva findByRef(String ref);
public  int deleteByRef(String ref);
}
