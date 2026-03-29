package de.hofmann.spring_modulith_demo.schaden.view;

import com.vaadin.flow.router.Route;
import de.hofmann.spring_modulith_demo.schaden.termin.TerminService;

@Route("schaden")
public class SchadenView {

    private final TerminService terminService;

    public SchadenView(TerminService terminService) {
        this.terminService = terminService;
    }
}
