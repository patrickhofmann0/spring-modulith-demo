package de.hofmann.spring_modulith_demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

class ArchitectureTests {
    ApplicationModules modules = ApplicationModules.of(SpringModulithDemoApplication.class);

    @Test
    void verifyArchitecture() {
        // Dieser Befehl prüft die package-info.java Regeln
        modules.verify();
    }

    @Test
    void writeDocumentation() throws IOException {
        new Documenter(modules)
                .writeDocumentation();         // Generiert eine Übersicht pro Modul (Apadua-Stil)

        // all-docs.adoc → index.adoc umbenennen, damit Asciidoctor index.html erzeugt
        Path docsDir = Path.of("target", "spring-modulith-docs");
        Files.move(
                docsDir.resolve("all-docs.adoc"),
                docsDir.resolve("index.adoc"),
                StandardCopyOption.REPLACE_EXISTING
        );
    }
}