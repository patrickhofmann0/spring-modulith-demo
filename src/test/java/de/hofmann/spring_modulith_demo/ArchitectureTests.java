package de.hofmann.spring_modulith_demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ArchitectureTests {
    ApplicationModules modules = ApplicationModules.of(SpringModulithDemoApplication.class);

    @Test
    void verifyArchitecture() {
        // Dieser Befehl prüft die package-info.java Regeln
        modules.verify();
    }

    @Test
    void writeDocumentation() {
        new Documenter(modules)
                .writeDocumentation();         // Generiert eine Übersicht pro Modul (Apadua-Stil)
    }
}