package com.thehecklers.sburrestdemo.Coffee;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoffeeDataLoader {
    private final CoffeeRepository coffeeRepository;

    public CoffeeDataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        coffeeRepository.saveAll(List.of(new Coffee("Cafe Cereza")
                , new Coffee("Cafe Ganador")
                , new Coffee("Cafe Lareno")
                , new Coffee("Cafe Tres Pontas")));
    }
}