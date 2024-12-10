package com.example.RestServer.service;

import com.example.RestServer.entity.Country;
import com.example.RestServer.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    public Country saveCountry(Country country) {
        return repository.save(country);
    }

    public void deleteCountry(Long id) {
        repository.deleteById(id);
    }

    public Country updateCountry(Long id, Country updatedCountry) {
        return repository.findById(id).map(country -> {
            country.setName(updatedCountry.getName());
            country.setContinent(updatedCountry.getContinent());
            country.setPopulation(updatedCountry.getPopulation());
            return repository.save(country);
        }).orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
    }


}