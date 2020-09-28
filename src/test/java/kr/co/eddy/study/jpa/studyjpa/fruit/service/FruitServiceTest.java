package kr.co.eddy.study.jpa.studyjpa.fruit.service;


import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import kr.co.eddy.study.jpa.studyjpa.fruit.repository.FruitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback(false)
public class FruitServiceTest {
    @Autowired
    private FruitRepository fruitRepository;

    @Test
    public void 과일등록_후_저장결과가져오기() {

        //given
        Fruit fruit = new Fruit((long)1, "사과", (long)300);
        fruitRepository.save(fruit);

        //when
        Fruit fruitFinded = fruitRepository.findById(fruit.getId()).get();

        //then
        assertThat(fruitFinded.getName()).isEqualTo(fruit.getName());
        assertThat(fruitFinded.getPrice()).isEqualTo(fruit.getPrice());

    }

}
