package com.oocl.company_db.one.to.one.controllers;

import com.oocl.company_db.one.to.one.entities.Leader;
import com.oocl.company_db.one.to.one.resposities.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v2/Leaders")
public class LeaderController {
    private LeaderRepository repository;

    @Autowired
    public LeaderController(LeaderRepository repository){

        this.repository = repository;
    }

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public Leader save (@RequestBody Leader leader)
    {
        if(leader.getKlass()!=null) {
            leader.getKlass().setLeader(leader);
        }
        return repository.save(leader);
    }
    @Transactional
    @PutMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update (@RequestBody Leader leader)
    {
        if(leader.getKlass()!=null) {
            leader.getKlass().setLeader(leader);
        }
         repository.save(leader);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @Transactional
    @GetMapping(path ="",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Leader> getAll()
    {
        return  repository.findAll();
    }
    @Transactional
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Leader delete(@PathVariable("id")Long id) {
        Leader one = repository.findOne(id);
        repository.delete(one);
        return one;
    }

}
