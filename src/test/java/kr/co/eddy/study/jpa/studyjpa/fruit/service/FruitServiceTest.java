package kr.co.eddy.study.jpa.studyjpa.fruit.service;


import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import kr.co.eddy.study.jpa.studyjpa.fruit.repository.FruitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback(false)
public class FruitServiceTest {

    @Autowired
    FruitRepository fruitRepository;

    @Test
    public void 과일등록() {
        FruitService fruitService = new FruitService();
        Fruit fruit = new Fruit((long)1, "사과", (long)300);
        fruitService.setFruitRepository(fruitRepository);

        Fruit returnedFruit = fruitService.save(fruit);

        assertThat(returnedFruit.getName()).isEqualTo("사과");
        assertThat(returnedFruit.getPrice()).isEqualTo((long)300);
    }

    @Test
    public void 과일찾기_id로() {
        //given
        FruitService fruitService = new FruitService();
        Fruit fruit = new Fruit((long)1, "사과", (long)300);
        fruitService.setFruitRepository(fruitRepository);
        fruitService.save(fruit);

        //when
        Fruit returnedFruit = fruitService.findFruitById(1);

        //then
        assertThat(returnedFruit.getName()).isEqualTo("사과");
        assertThat(returnedFruit.getPrice()).isEqualTo((long)300);
    }

    @Test
    public void 과일찾기_이름으로_리스트() {
        //given
        FruitService fruitService = new FruitService();

        fruitService.setFruitRepository(fruitRepository);
        fruitService.save(new Fruit((long)1, "사과", (long)300));
        fruitService.save(new Fruit((long)2, "사과", (long)400));
        fruitService.save(new Fruit((long)3, "사과", (long)600));

        //when
        List<Fruit> returnedFruitList = fruitService.findFruitByName("사과");

        //then
        assertThat(returnedFruitList).hasSize(3);
    }

}
