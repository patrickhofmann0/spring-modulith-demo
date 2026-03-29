package de.hofmann.spring_modulith_demo.vertrag.internal;

import de.hofmann.spring_modulith_demo.vertrag.VertragCreatedEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VertragService {

    private final VertragRepository vertragRepository;
    private final ApplicationEventPublisher events;

    @Transactional
    public Vertrag createVertrag(String name) {
        Vertrag vertrag = new Vertrag();
        vertrag.setName(name);
        vertrag = vertragRepository.save(vertrag);
        events.publishEvent(new VertragCreatedEvent(vertrag.getId()));
        return vertrag;
    }

    public Vertrag findVertragById(Long id) {
        return vertragRepository.findById(id).orElseThrow(() -> new RuntimeException("Vertrag nicht gefunden"));
    }


    public List<Vertrag> findAll() {
        return vertragRepository.findAll();
    }
}
