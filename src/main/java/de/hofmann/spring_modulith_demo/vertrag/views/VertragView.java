package de.hofmann.spring_modulith_demo.vertrag.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import de.hofmann.spring_modulith_demo.vertrag.VertragSchadenZuordnungen;
import de.hofmann.spring_modulith_demo.vertrag.internal.Vertrag;
import de.hofmann.spring_modulith_demo.vertrag.internal.VertragService;

import java.util.List;

@Route("vertrag")
public class VertragView extends VerticalLayout {

    private final VertragService vertragService;
    private final VertragSchadenZuordnungen vertragSchadenZuordnungen;

    private final Grid<Vertrag> vertragGrid = new Grid<>(Vertrag.class);

    public VertragView(VertragService vertragService,
                       VertragSchadenZuordnungen vertragSchadenZuordnungen) {
        this.vertragService = vertragService;
        this.vertragSchadenZuordnungen = vertragSchadenZuordnungen;
    }

    @Override
    public void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        this.add(new Button("Add", e -> {
            vertragService.createVertrag("Test");
            vertragGrid.setItems(vertragService.findAll());
        }));

        vertragGrid.setItems(vertragService.findAll());
        vertragGrid.addItemClickListener(e -> {
            Vertrag vertrag = e.getItem();
            var dialog = new Dialog();
            dialog.setHeight("50%");
            var vertragLayout = new VerticalLayout();
            dialog.add(vertragLayout);
            vertragLayout.add("Vertrag: " + vertrag.getName());
            List<String> zugeordneteSchaeden = getSchaeden(vertrag.getId());
            zugeordneteSchaeden.forEach(schaden ->
                    vertragLayout.add(new Paragraph("Schaden: " + schaden)));
            dialog.open();
        });

        this.setSizeFull();
        this.add(vertragGrid);
    }

    private List<String> getSchaeden(Long id) {
        return vertragSchadenZuordnungen.getSchaedenByVertragId(id);
    }

}
