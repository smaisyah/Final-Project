package com.mii.metrodata.clientappsima.clientappsima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.metrodata.clientappsima.clientappsima.models.Loan;
import com.mii.metrodata.clientappsima.clientappsima.services.LoanService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/loan")
@AllArgsConstructor
public class LoanController {
    private LoanService loanService;

    @GetMapping("/create")
    public String createView(Loan loan){
        return "loan/create-form";
    }

    @PostMapping
    public String create(Loan loan){
        loanService.create(loan);
        return "redirect:/loan";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id,Model model){
        model.addAttribute("loan", loanService.getById(id));
        return "loan/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Loan loan){
        loanService.update(id, loan);
        return "redirect:/loan";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        loanService.delete(id);
        return "redirect:/loan";
    }
}