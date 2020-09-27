package kr.co.eddy.study.jpa.studyjpa.fruit.repository;

import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

}
