package com.example.demo2.ws;

import com.example.demo2.bean.Tva;
import com.example.demo2.service.TvaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tva")
public class TvaRest {
    @Autowired
    TvaSevice tvaService;
    @GetMapping("/ref/{ref}")
    public Tva findByRef(@PathVariable String ref) {
        return tvaService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return tvaService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Tva> findAll() {
        return tvaService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Tva tva) {
        return tvaService.save(tva);
    }
}