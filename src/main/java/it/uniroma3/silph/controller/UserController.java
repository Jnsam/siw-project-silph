package it.uniroma3.silph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.silph.model.User;
import it.uniroma3.silph.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", this.userService.findAll());
        return "userList";
    }
    
    @RequestMapping("/addUser")
    public String addCustomer(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userService.findById(id));
    	return "showUser";
    }
}
