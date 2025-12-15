package it.unisa.diem.inginf.biblioteca.ui;

import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.*;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;


public class App extends Application {
    @Override
    public void start(Stage stage) {
        
        Biblioteca biblioteca = new Biblioteca();
        
        
        ChoiceBox mode = new ChoiceBox();
        mode.getItems().addAll("Utenti", "Libri", "Prestiti");
        mode.setValue("Utenti");
        
        ListView utenti = new ListView(biblioteca.getUtenti());
        ListView libri = new ListView(biblioteca.getLibri());
        ListView prestiti = new ListView(biblioteca.getPrestiti());
        
        utenti.setPrefSize(1000, 400);
        libri.setPrefSize(1000, 400);
        prestiti.setPrefSize(1000, 400);
        
        
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setPrefSize(700, 400);
        
        
        scrollpane.contentProperty().bind(new ObjectBinding() {
            @Override
            protected Object computeValue() {
                Property p = mode.valueProperty();
                bind(p);
                if(p.getValue() == "Utenti") return utenti;
                else if(p.getValue() == "Libri") return libri;
                else if(p.getValue() == "Prestiti") return prestiti;
                throw new RuntimeException("Invalid choice");
            }
        });
        
        Button add = new Button("+");
        Button remove = new Button("-");
        
        AddMenu addmenu = new AddMenu(biblioteca, mode.valueProperty());
        
        add.setOnAction((ActionEvent ev) -> {
            addmenu.show();
        });
        
        remove.setOnAction((ActionEvent ev) -> {
            String selection = (String)mode.getValue();
            switch(selection) {
                case "Utenti":
                    biblioteca.eliminaUtente((Utente)utenti.getSelectionModel().getSelectedItem());
                    break;
                case "Libri":
                    biblioteca.eliminaLibro((Libro)libri.getSelectionModel().getSelectedItem());
                    break;
                case "Prestiti":
                    biblioteca.eliminaPrestito((Prestito)prestiti.getSelectionModel().getSelectedItem());
                    break;
            }
        });
        
        
        biblioteca.registraUtente(new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it"));
        biblioteca.registraUtente(new Utente("Matteo", "Nebbia", "0612709400", "m.nebbia@studenti.unisa.it"));
        
        add.setPrefSize(40, 40);
        remove.setPrefSize(40, 40);
        
        HBox controls = new HBox(add, remove);
        
        GridPane grid = new GridPane();
        grid.add(mode, 0, 1);
        grid.add(scrollpane, 0, 2);
        grid.add(controls, 0, 3);
        Scene scene = new Scene(grid, 700, 500);
        stage.setScene(scene);
        stage.show();
    }
}
