package com.example.demo.Controllers;

import com.example.demo.models.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private static final List<Flight> flights = new ArrayList<>();

    static {
        // Ініціалізація списку рейсів
        flights.add(new Flight(1L, "Kyiv", "Lviv", LocalDateTime.now().plusHours(1),
                LocalDateTime.now().plusHours(2), 1500.0, "KL100", LocalDateTime.now()));
        flights.add(new Flight(2L, "Odesa", "Kharkiv", LocalDateTime.now().plusHours(3),
                LocalDateTime.now().plusHours(5), 2000.0, "OK200", LocalDateTime.now()));
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        return flights.stream()
                .filter(flight -> flight.getId().equals(id))
                .findFirst()
                .map(flight -> new ResponseEntity<>(flight, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        flight.setId((long) (flights.size() + 1));
        flight.setCreationDate(LocalDateTime.now());
        flights.add(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        boolean removed = flights.removeIf(flight -> flight.getId().equals(id));
        return removed ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}