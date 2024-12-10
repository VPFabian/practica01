package com.example.RestServer.controller;

import com.example.RestServer.entity.Country;
import com.example.RestServer.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryService service;

    @GetMapping
    public List<Country> getAllCountries() {
        return service.getAllCountries();
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return service.saveCountry(country);
    }
    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country updatedCountry) {
        return service.updateCountry(id, updatedCountry);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        service.deleteCountry(id);
    }
}