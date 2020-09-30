package kr.co.eddy.study.jpa.studyjpa.fruit.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;

import kr.co.eddy.study.jpa.studyjpa.fruit.service.FruitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;




@WebMvcTest(FruitController.class)
@AutoConfigureMockMvc
public class FruitControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FruitService fruitService;


    private static Fruit fruit = Fruit.builder().name("사과").price((long)300).build();

    @DisplayName("/fruit POST 호출")
    @Test
    public void POST과일등록() throws Exception {


        String content = objectMapper.writeValueAsString(fruit);
        Fruit responseFruit = Fruit.builder().id(1L).name("사과").price((long)300).build();
        given(fruitService.save(fruit)).willReturn(responseFruit);

        mockMvc.perform(post("/fruit").contentType(MediaType.APPLICATION_JSON).content(content).characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("사과")))
                .andDo(print());
    }


    @DisplayName("/fruit/{id} GET 호출")
    @Test
    public void GET과일ID로_조회() throws Exception {

        Fruit fruit = Fruit.builder().id((long)1).name("사과").price((long)300).build();


        given(fruitService.findFruitById((long)1)).willReturn(fruit);


        mockMvc.perform(get("/fruit/1").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("사과")))
                .andExpect(jsonPath("$.price", is(300)))
                .andDo(print());
    }

    @DisplayName("/fruits/{name} GET 호출")
    @Test
    public void GET_과일이름으로_과일리스트_조회() throws Exception {


        Fruit fruit = Fruit.builder().id((long)1).name("사과").price((long)300).build();
        Fruit fruit2 = Fruit.builder().id((long)2).name("사과").price((long)400).build();
        Fruit fruit3 = Fruit.builder().id((long)3).name("사과").price((long)500).build();
        List<Fruit> fruits = Arrays.asList(fruit, fruit2, fruit3);


        given(fruitService.findFruitByName("사과")).willReturn(fruits);


        mockMvc.perform(get("/fruits/사과").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("/fruits/{name} GET 호출")
    @Test
    public void GET_전체과일리스트_조회() throws Exception {

        Fruit fruit = Fruit.builder().id((long)1).name("사과").price((long)300).build();
        Fruit fruit2 = Fruit.builder().id((long)2).name("사과").price((long)400).build();
        Fruit fruit3 = Fruit.builder().id((long)3).name("사과").price((long)500).build();
        Fruit fruit4 = Fruit.builder().id((long)4).name("배").price((long)1000).build();
        Fruit fruit5 = Fruit.builder().id((long)5).name("배").price((long)300).build();
        Fruit fruit6 = Fruit.builder().id((long)6).name("바나나").price((long)900).build();
        List<Fruit> fruits = Arrays.asList(fruit, fruit2, fruit3, fruit4, fruit5, fruit6);


        given(fruitService.findAllFruit()).willReturn(fruits);


        mockMvc.perform(get("/fruits").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("/fruits/{name}?oreder=orderkey GET 호출")
    @Test
    public void GET_전체과일리스트_조회_Sorting() throws Exception {

        Fruit fruit = Fruit.builder().id((long)1).name("사과").price((long)300).build();
        Fruit fruit2 = Fruit.builder().id((long)2).name("사과").price((long)400).build();
        Fruit fruit3 = Fruit.builder().id((long)3).name("사과").price((long)500).build();
        Fruit fruit4 = Fruit.builder().id((long)4).name("배").price((long)1000).build();
        Fruit fruit5 = Fruit.builder().id((long)5).name("배").price((long)300).build();
        Fruit fruit6 = Fruit.builder().id((long)6).name("바나나").price((long)900).build();
        List<Fruit> fruits = Arrays.asList(fruit, fruit2, fruit3, fruit4, fruit5, fruit6);


        given(fruitService.findAllFruit("price")).willReturn(fruits);


        mockMvc.perform(get("/fruits?order=price").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }




}
