package kr.co.eddy.study.jpa.studyjpa.fruit.repository;

import kr.co.eddy.study.jpa.studyjpa.fruit.domain.Fruit;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

}
