package com.mii.metrodata.clientappsima.clientappsima.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.metrodata.clientappsima.clientappsima.models.Status;
import com.mii.metrodata.clientappsima.clientappsima.services.StatusService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/status")
@AllArgsConstructor
public class StatusController {
    private StatusService statusService;

    @GetMapping
    public String index(Model model){
        List<Status> statuss = statusService.getAll();
        model.addAttribute("statuss", statuss);
        return "view/status";
    }
    
    @GetMapping("/create")
    public String createView(Status status){
        return "view/status";
    }

    @PostMapping
    public String create(Status status){
        statusService.create(status);
        return "redirect:/status";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id,Model model){
        model.addAttribute("status", statusService.getById(id));
        return "status/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Status status){
        statusService.update(id, status);
        return "redirect:/status";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        statusService.delete(id);
        return "redirect:/status";
    }
}