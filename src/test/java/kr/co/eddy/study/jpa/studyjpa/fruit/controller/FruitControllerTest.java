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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


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

        mockMvc.perform(post("/fruit").contentType(MediaType.APPLICATION_JSON).content(content).characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("사과")))
                .andDo(print());
    }



}
