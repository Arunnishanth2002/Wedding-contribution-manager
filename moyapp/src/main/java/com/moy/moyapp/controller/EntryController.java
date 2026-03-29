package com.moy.moyapp.controller;

import java.util.*;
import org.springframework.web.bind.annotation.RestController;
import com.moy.moyapp.entity.Entry;
import com.moy.moyapp.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class EntryController
{
    @Autowired
    private EntryService service;

    @PostMapping("/entry")
    public Entry saveEntry(@RequestBody Entry entry)
    {
        return service.saveEntry(entry);
    }

    @GetMapping("/entries")
    public List<Entry> getAllEntries()
    {
        return service.getAllEntries();
    }

    @GetMapping("/search/name")
    public List<Entry>searchByName(@RequestParam String name)
    {
    return service.searchByName(name);
    }

    @GetMapping("/search/village")
    public List<Entry>searchByVillage(@RequestParam String village)
    {
        return service.searchByVillage(village);
    }

}
