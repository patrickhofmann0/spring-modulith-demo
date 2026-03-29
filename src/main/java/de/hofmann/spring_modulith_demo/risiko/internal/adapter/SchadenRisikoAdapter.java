package de.hofmann.spring_modulith_demo.risiko.internal.adapter;

import de.hofmann.spring_modulith_demo.schaden.SchadenRisikoZuordnung;

public class SchadenRisikoAdapter implements SchadenRisikoZuordnung {

    @Override
    public String getRisikoDetailsForSchaden(Long schadenId) {
        // Hier könnte die Logik implementiert werden, um die Risiko-Details basierend auf der Schaden-ID zu ermitteln.
        // Zum Beispiel könnte eine Datenbankabfrage oder eine externe API-Aufruf erfolgen.
        return "Risiko-Details für Schaden-ID: " + schadenId;
    }

}
