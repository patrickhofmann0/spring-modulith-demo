package de.hofmann.spring_modulith_demo.schaden.internal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SchadenRepository extends CrudRepository<Schaden, Long> {

    List<Schaden> findByVertragId(Long vertragId);
    List<Schaden> findAll();


}
