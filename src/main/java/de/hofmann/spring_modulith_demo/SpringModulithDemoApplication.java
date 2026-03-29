package de.hofmann.spring_modulith_demo;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.aura.Aura;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@StyleSheet(Aura.STYLESHEET)
@StyleSheet("styles.css")
public class SpringModulithDemoApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(SpringModulithDemoApplication.class, args);
	}

}
