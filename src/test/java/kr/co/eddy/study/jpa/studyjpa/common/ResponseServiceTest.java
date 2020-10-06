package kr.co.eddy.study.jpa.studyjpa.common;

import kr.co.eddy.study.jpa.studyjpa.common.service.ResponseService;
import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ResponseServiceTest {
    private static final ResponseService responseService = new ResponseService();

    @DisplayName("SingleReulst 테스트")
    @Test
    public void SingleResult테스트() {
        Fruit fruit = Fruit.builder().id(1l).name("사과").price(300L).build();

        SingleResult<Fruit> singleResult = responseService.getSingleResult(fruit);
        assertThat(singleResult.getResultCode()).isEqualTo(0000);
        assertThat(singleResult.getResultMessage()).isEqualTo("SUCCESS");
        assertThat(singleResult.getData()).isEqualTo(fruit);
    }


    @DisplayName("ListReulst 테스트")
    @Test
    public void ListResult테스트() {

        Fruit fruit = Fruit.builder().id((long)1).name("사과").price((long)300).build();
        Fruit fruit2 = Fruit.builder().id((long)2).name("사과").price((long)400).build();
        Fruit fruit3 = Fruit.builder().id((long)3).name("사과").price((long)500).build();
        Fruit fruit4 = Fruit.builder().id((long)4).name("배").price((long)1000).build();
        Fruit fruit5 = Fruit.builder().id((long)5).name("배").price((long)300).build();
        Fruit fruit6 = Fruit.builder().id((long)6).name("바나나").price((long)900).build();
        List<Fruit> fruits = Arrays.asList(fruit, fruit2, fruit3, fruit4, fruit5, fruit6);

        ListResult<Fruit> listResult = responseService.getListResult(fruits);
        assertThat(listResult.getResultCode()).isEqualTo(0000);
        assertThat(listResult.getResultMessage()).isEqualTo("SUCCESS");
        assertThat(listResult.getList()).isEqualTo(fruits);
    }
}
