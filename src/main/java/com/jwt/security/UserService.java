package com.jwt.security;

import com.jwt.security.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store = new ArrayList<>();

    public UserService() {
        System.out.println("show data");
        store.add(new User(UUID.randomUUID().toString(),"Akash Gupta", "akashgupta2856@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"vaibhav Gupta", "vaibhavgupta2856@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"safar Gupta", "sagargupta2856@gmail.com"));

    }
    public List<User> getUser(){
        return this.store;
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
