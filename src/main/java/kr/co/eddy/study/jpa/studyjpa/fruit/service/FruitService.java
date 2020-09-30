package kr.co.eddy.study.jpa.studyjpa.fruit.service;

import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import kr.co.eddy.study.jpa.studyjpa.fruit.repository.FruitRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    @Setter
    @Autowired
    private FruitRepository fruitRepository;


    public Fruit save(Fruit fruit) {

        return fruitRepository.save(fruit);
    }

    public Fruit findFruitById(long id) {
        return fruitRepository.findById(id).get();
    }

    public List<Fruit> findFruitByName(String name) {
        return fruitRepository.findByName(name);
    }
}