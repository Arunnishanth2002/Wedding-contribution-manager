package com.moy.moyapp.controller;

import com.moy.moyapp.entity.Entry;
import com.moy.moyapp.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private EntryService service;

    @GetMapping("/add")
    public String addPage()
    {
        return "add-entry";
    }

    @PostMapping("/save")
    public String saveEntry(Entry entry)
    {
        service.saveEntry(entry);
        return "redirect:/search";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }

    @GetMapping("/search/name")
    public String searchByName(@RequestParam String name, Model model) {
        List<Entry> entries = service.searchByName(name);
        model.addAttribute("entries", entries);
        return "search";
    }

    @GetMapping("/search/village")
    public String searchByVillage(@RequestParam String village, Model model) {
        List<Entry> entries = service.searchByVillage(village);
        model.addAttribute("entries", entries);
        return "search";
    }

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> export() throws Exception {

        ByteArrayInputStream in = service.exportToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=moy_data.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
}