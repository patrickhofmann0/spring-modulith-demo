package de.hofmann.spring_modulith_demo.schaden.adapter;

import de.hofmann.spring_modulith_demo.schaden.internal.Schaden;
import de.hofmann.spring_modulith_demo.schaden.internal.SchadenService;
import de.hofmann.spring_modulith_demo.vertrag.VertragSchadenZuordnungen;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VertragSchadenZuordnungenAdapter implements VertragSchadenZuordnungen {

    private final SchadenService schadenService;

    @Override
    public List<String> getSchaedenByVertragId(Long vertragId) {
        return schadenService.findByVertragId(vertragId)
                .stream()
                .map(Schaden::getName)
                .toList();
    }
}
