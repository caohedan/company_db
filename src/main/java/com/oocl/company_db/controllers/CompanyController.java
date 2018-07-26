package com.oocl.company_db.controllers;

import com.oocl.company_db.entities.Company;
import com.oocl.company_db.resposities.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private CompanyRepository repository;

    @Autowired
    public CompanyController(CompanyRepository repository){
        this.repository = repository;
    }

    @Transactional
    @PostMapping(path = "" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company){
        return  repository.save(company);
    }
    @GetMapping(path = "")
    public List<Company> findAll(){
        return repository.findAll();
    }

}
