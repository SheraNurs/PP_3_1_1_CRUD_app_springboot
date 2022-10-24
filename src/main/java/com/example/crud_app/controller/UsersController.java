package com.example.crud_app.controller;

import com.example.crud_app.model.User;
import com.example.crud_app.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/")
    public String printUsers(Model model) {

        List<User> allUsers = usersService.getAllUsers();
        model.addAttribute("allUs", allUsers);
        return "users";
    }

    @RequestMapping ("/addNewUsers")
    public String addNewUsers(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users_info";
    }

    @RequestMapping("/saveUsers")
    public String saveUsers(@ModelAttribute("user") User user) {
        usersService.saveUsers(user);
        return "redirect:/";
    }

    @RequestMapping("edit/{id}")
    public String updateUserGet(@PathVariable("id") int id, Model model) {
        model.addAttribute(usersService.getUsers(id));
        return "edit";
    }

    @RequestMapping("/edit")
    public String updateInfo(@ModelAttribute("user") User user){
        usersService.updateUsers(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUsers")
    public String deleteUsers(@RequestParam("userId") int id) {
        usersService.deleteUsers(id);
        return "redirect:/";
    }

}
