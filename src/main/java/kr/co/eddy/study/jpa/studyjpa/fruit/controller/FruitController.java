package kr.co.eddy.study.jpa.studyjpa.fruit.controller;

import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import kr.co.eddy.study.jpa.studyjpa.fruit.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

    @Autowired(required=true)
    FruitService fruitService;

    @PostMapping("/fruit")
    public Fruit postFruit(@RequestBody Fruit fruit) {

        return fruitService.save(fruit);
    }

}
