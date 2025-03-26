package com.example.fatura.controller;

import com.example.fatura.model.Fatura;
import com.example.fatura.repository.FaturaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private FaturaRepository repository;

    @PostMapping
    public ResponseEntity<Fatura> cadastrarFatura(@RequestBody Fatura fatura){
        Fatura novaFatura = repository.save(fatura);
        return ResponseEntity.ok(novaFatura);
    }

    @GetMapping
    public List<Fatura> faturas(){
        return repository.findAll();
    }
}
