package com.oocl.company_db.n.to.n.controllers;

import com.oocl.company_db.n.to.n.entities.Group;
import com.oocl.company_db.n.to.n.entities.User;
import com.oocl.company_db.n.to.n.resposities.GroupResposity;
import com.oocl.company_db.n.to.n.resposities.UserResposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/Users")
public class UserController {
    private UserResposity resposity;

    @Autowired
    public UserController(UserResposity resposity) {
        this.resposity = resposity;
    }

    @Autowired
    GroupResposity groupResposity;
    @GetMapping(path = "/groups")
    public  List<Group> getALL(){
        return groupResposity.findAll();
    }
    @PostMapping(path = "")
    public User add(@RequestBody User user) {
        user.getGroups().stream().forEach(group -> {
            List<User> users = group.getUsers();
            users.add(user);
            group.setUsers(users);
        });
        return resposity.save(user);

    }

    @PutMapping(path = "")
    public ResponseEntity<Object> update(@RequestBody User user) {
        user.getGroups().stream().forEach(group -> {
            List<User> users = group.getUsers();
            for (User u : users) {
                if (u.getId() == user.getId())
                    u = user;
            }
            group.setUsers(users);
        });
        resposity.save(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping(path = "")
    public List<User> getAll(){
        return resposity.findAll();
    }
    @DeleteMapping(path ="/{id}")
    public  User delete(@PathVariable Long id){
        User user = resposity.findOne(id);
       List<Group> groups =  user.getGroups();
       for(Group group:groups){
           List<User> users = group.getUsers();
           users.remove(user);
           group.setUsers(users);
       }

        resposity.delete(user);
        return  user;

    }
}