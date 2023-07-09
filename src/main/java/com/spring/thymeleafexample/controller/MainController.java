package com.spring.thymeleafexample.controller;

import com.spring.thymeleafexample.entity.Serviceman;
import com.spring.thymeleafexample.service.ServicemanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String createServiceman(Model model) {
        // Додатковий код для створення нового військовослужбовця
        return "create";
    }
}