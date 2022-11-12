package com.company.springauth.api;

import com.company.springauth.model.Manager;
import com.company.springauth.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApplicationController {
    private final ManagerService managerService;


    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Manager> allManager = managerService.getAll();
        model.addAttribute("All manager ", allManager);
        return "index";
    }

    @RequestMapping("/new")
    public String newManagerPage(Model model) {
        Manager manager = new Manager();
        model.addAttribute(manager);
        return "new_manager";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveManager(@ModelAttribute("manager") Manager manager) {
        managerService.save(manager);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditManagerPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_manager");
        Manager manager = managerService.getById(id);
        mav.addObject("manager", manager);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteManagerPage(@PathVariable(name = "id") Long id) {
        managerService.delete(id);
        return "redirect:/";
    }
}
