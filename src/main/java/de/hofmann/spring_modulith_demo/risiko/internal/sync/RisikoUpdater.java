package de.hofmann.spring_modulith_demo.risiko.internal.sync;

import de.hofmann.spring_modulith_demo.vertrag.VertragCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class RisikoUpdater {

    @ApplicationModuleListener
    public void onVertragCreated(VertragCreatedEvent event) {
        Objects.requireNonNull(event.vertragId(), "VertragCreatedEvent vertragId must not be null");
        updateRisiko(event.vertragId());
    }

    private void updateRisiko(Long vertragId) {
        log.info("Insert/Update Risiken for vertrag {}", vertragId);
    }
}
