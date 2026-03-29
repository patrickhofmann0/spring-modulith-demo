package de.hofmann.spring_modulith_demo.vertrag.internal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VertragRepository extends CrudRepository<Vertrag, Long> {

    List<Vertrag> findAll();
}
