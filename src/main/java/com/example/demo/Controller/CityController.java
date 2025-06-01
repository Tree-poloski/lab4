package com.example.demo.Controller;

import com.example.demo.models.City;
import com.example.demo.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CityController {

    CityService cityService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }


}