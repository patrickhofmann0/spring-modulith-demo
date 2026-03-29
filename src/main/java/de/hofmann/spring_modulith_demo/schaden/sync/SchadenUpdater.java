package de.hofmann.spring_modulith_demo.schaden.sync;

import de.hofmann.spring_modulith_demo.schaden.internal.Schaden;
import de.hofmann.spring_modulith_demo.schaden.internal.SchadenService;
import de.hofmann.spring_modulith_demo.vertrag.VertragCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class SchadenUpdater {

    private final SchadenService schadenService;

    @ApplicationModuleListener
    public void onSchadenUpdated(VertragCreatedEvent event) {
        log.info("Insert/Update Schäden for vertrag {}", event.vertragId());
        updateSchaden(event.vertragId());
    }

    private void updateSchaden(Long vertragId) {
        int v = (int) (Math.random() * 10);

        IntStream.range(0, v).forEach(i -> {
            Schaden schaden = new Schaden();
            schaden.setVertragId(vertragId);
            schaden.setName("Schaden " + i);
            schadenService.save(schaden);
        });
    }


}
