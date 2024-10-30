package vish.dima.crud.CrudSecurity.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vish.dima.crud.CrudSecurity.security.PersonDetails;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails= (PersonDetails)authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }
}
