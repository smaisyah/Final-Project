package com.mii.metrodata.clientappsima.clientappsima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.metrodata.clientappsima.clientappsima.models.Submition;
import com.mii.metrodata.clientappsima.clientappsima.services.SubmitionService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/submition")
@AllArgsConstructor
public class SubmitionController {
    private SubmitionService submitionService;

    @GetMapping("/create")
    public String createView(Submition submition){
        return "submition/create-form";
    }

    @PostMapping
    public String create(Submition submition){
        submitionService.create(submition);
        return "redirect:/submition";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id,Model model){
        model.addAttribute("submition", submitionService.getById(id));
        return "submition/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Submition submition){
        submitionService.update(id, submition);
        return "redirect:/submition";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        submitionService.delete(id);
        return "redirect:/submition";
    }
}