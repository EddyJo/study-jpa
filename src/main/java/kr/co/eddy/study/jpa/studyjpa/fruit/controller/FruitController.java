package kr.co.eddy.study.jpa.studyjpa.fruit.controller;

import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import kr.co.eddy.study.jpa.studyjpa.fruit.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    @Autowired(required=true)
    FruitService fruitService;

    @PostMapping(value = "/fruit", produces = "application/json; charset=UTF-8")
    public Fruit postFruit(@RequestBody Fruit fruit) {

        return fruitService.save(fruit);
    }

    @GetMapping(value = "/fruit/{id}", produces = "application/json; charset=UTF-8")
    public Fruit getFruit(@PathVariable Long id) {
        return fruitService.findFruitById(id);
    }

    @GetMapping(value = "/fruits/{name}", produces = "application/json; charset=UTF-8")
    public List<Fruit> getFruit(@PathVariable String name) {
        return fruitService.findFruitByName(name);
    }


    @GetMapping(value = "/fruits", produces = "application/json; charset=UTF-8")
    public List<Fruit> getFruit() {
        return fruitService.findAllFruit();
    }



}
