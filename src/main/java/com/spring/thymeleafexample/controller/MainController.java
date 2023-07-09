package com.spring.thymeleafexample.controller;

import com.spring.thymeleafexample.entity.Serviceman;
import com.spring.thymeleafexample.service.ServicemanService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/servicemen")
public class MainController {
    private final ServicemanService servicemanService;

    public MainController(ServicemanService servicemanService) {
        this.servicemanService = servicemanService;
    }

    @GetMapping
    public String getAllServiceman(Model model) {
        List<Serviceman> servicemen = servicemanService.getAllServicemen();
        System.out.println(servicemen);
        model.addAttribute("servicemen", servicemen);
        return "index";
    }

    @GetMapping("/create")
    public String createServiceman() {
        return "create";
    }

    @PostMapping("/create")
    public String createServiceman(@ModelAttribute("serviceman") Serviceman serviceman, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.hasErrors());
            return "index";
        }
        servicemanService.saveServiceman(serviceman);
        return "redirect:/servicemen";
    }

    @GetMapping("/edit/{id}")
    public String getServiceManEdit(@PathVariable Integer id, Model model) {
        Serviceman serviceman = servicemanService.getOneServicemanById(id);
        model.addAttribute("serviceman", serviceman);
        return "edit";
    }

    @PostMapping("/edit")
    public String editServiceman(@ModelAttribute("serviceman") Serviceman serviceman, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.hasErrors());
            return "index";
        }
        System.out.println(serviceman.getId());
        servicemanService.updateServiceman(serviceman.getId(), serviceman);
        return "redirect:/servicemen";
    }
}