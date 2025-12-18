package it.unisa.diem.inginf.biblioteca.ui;

import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.*;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.event.*;
import javafx.beans.binding.*;


public class App extends Application {
    @Override
    public void start(Stage stage) {
        
        Biblioteca biblioteca = new Biblioteca();
        
        
        ChoiceBox<String> mode = new ChoiceBox<>();
        mode.getItems().addAll("Utenti", "Libri", "Prestiti");
        mode.setValue("Utenti");
        
        ListView<Utente> utenti = new ListView<>(biblioteca.getUtenti());
        ListView<Libro> libri = new ListView<>(biblioteca.getLibri());
        ListView<Prestito> prestiti = new ListView<>(biblioteca.getPrestiti());
        
        utenti.setPrefSize(1000, 400);
        libri.setPrefSize(1000, 400);
        prestiti.setPrefSize(1000, 400);
        
        
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setPrefSize(700, 400);
        
        
        scrollpane.contentProperty().bind(new ObjectBinding<Node>() {
            @Override
            protected Node computeValue() {
                bind(mode.valueProperty());
                String selected = mode.getValue();
                if ("Utenti".equals(selected)) return utenti;
                else if ("Libri".equals(selected)) return libri;
                else if ("Prestiti".equals(selected)) return prestiti;
                throw new RuntimeException("Invalid choice");
            }
        });
        
        Button add = new Button("+");
        Button remove = new Button("-");
        Button modify = new Button("*");
        
        add.setPrefSize(40, 40);
        remove.setPrefSize(40, 40);
        modify.setPrefSize(40, 40);
        
        EditMenu editMenu = new EditMenu(biblioteca, mode.valueProperty());
        
        add.setOnAction((ActionEvent ev) -> {
            editMenu.show(null);
        });
        
        modify.setOnAction((ActionEvent ev) -> {
            editMenu.show(((ListView<?>) scrollpane.getContent()).getSelectionModel().getSelectedItem());
        });
        
        remove.setOnAction((ActionEvent ev) -> {
            String selection = mode.getValue();
            switch(selection) {
                case "Utenti":
                    biblioteca.eliminaUtente(utenti.getSelectionModel().getSelectedItem());
                    break;
                case "Libri":
                    biblioteca.eliminaLibro(libri.getSelectionModel().getSelectedItem());
                    break;
                case "Prestiti":
                    biblioteca.eliminaPrestito(prestiti.getSelectionModel().getSelectedItem());
                    break;
            }
        });
        
        
        biblioteca.registraUtente(new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it"));
        biblioteca.registraUtente(new Utente("Matteo", "Nebbia", "0612709400", "m.nebbia@studenti.unisa.it"));
        biblioteca.registraUtente(new Utente("Marianna", "Vollaro", "0612707631", "m.vollaro@studenti.unisa.it"));
        

        
        HBox controls = new HBox(add, modify, remove);
        
        GridPane grid = new GridPane();
        grid.add(mode, 0, 1);
        grid.add(scrollpane, 0, 2);
        grid.add(controls, 0, 3);
        Scene scene = new Scene(grid, 700, 500);
        stage.setScene(scene);
        stage.show();
    }
}
