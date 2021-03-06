package kr.co.eddy.study.jpa.studyjpa.fruit.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name="TB_FRUIT")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fruit {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Long price;
}
