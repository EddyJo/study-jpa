package kr.co.eddy.study.jpa.studyjpa.fruit.service;

import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import kr.co.eddy.study.jpa.studyjpa.fruit.repository.FruitRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Fruit> findAllFruit() {
        return fruitRepository.findAll();
    }

    public List<Fruit> findAllFruit(String orderKey) {
        if(null == orderKey) {
            return findAllFruit();
        }
        return fruitRepository.findAll(Sort.by(Sort.Direction.DESC, orderKey));
    }

    public Fruit updateFruit(Long id,Fruit fruit) {

        Optional<Fruit> fruitSelectd = fruitRepository.findById(id);

        fruitSelectd.ifPresent( selectedFruit -> {
                selectedFruit.setName(fruit.getName());
                selectedFruit.setPrice(fruit.getPrice());

        });

        return fruitRepository.save(fruitSelectd.get());
    }
}
