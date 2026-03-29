package de.hofmann.spring_modulith_demo.schaden.internal;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchadenService {

    private final SchadenRepository schadenRepository;

    public SchadenService(SchadenRepository schadenRepository) {
        this.schadenRepository = schadenRepository;
    }

    public void save(Schaden schaden) {
        this.schadenRepository.save(schaden);
    }

    public List<Schaden> findByVertragId(Long vertragId) {
        return schadenRepository.findByVertragId(vertragId);
    }
}
