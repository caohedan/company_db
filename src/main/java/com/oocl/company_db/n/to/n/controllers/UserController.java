package com.oocl.company_db.n.to.n.controllers;

import com.oocl.company_db.n.to.n.entities.User;
import com.oocl.company_db.n.to.n.resposities.UserResposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/Users")
public class UserController {
    private  UserResposity resposity;
    @Autowired
    public UserController(UserResposity resposity) {
        this.resposity = resposity;
    }
  @PostMapping(path = "")
    public User add(@RequestBody User user){
//      user.getGroups().stream().forEach(group -> {
//          List<User> users = group.getUsers();
//          users.add(user);
//          group.setUsers(users);
//      });
        return  resposity.save(user);

  }
}
