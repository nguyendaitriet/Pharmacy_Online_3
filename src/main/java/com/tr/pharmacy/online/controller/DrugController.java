package com.tr.pharmacy.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/drugs")
public class DrugController {

    @GetMapping
    public ModelAndView showDrugList() {
        return new ModelAndView("/drug-management/list");
    }
}
