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
import javafx.beans.property.*;


public class App extends Application {
    @Override
    public void start(Stage stage) {
        
        Biblioteca biblioteca = new Biblioteca();
        
        ChoiceBox mode = new ChoiceBox();
        mode.getItems().addAll("Utenti", "Libri", "Prestiti");
        mode.setValue("Utenti");
        
        VBox l_utenti = new VBox();
        VBox l_libri = new VBox();
        VBox l_prestiti = new VBox();
        
        l_utenti.getChildren().add(new Label("Test"));
        
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setPrefSize(500, 400);
        
        
        scrollpane.contentProperty().bind(new ObjectBinding() {
            @Override
            protected Object computeValue() {
                Property p = mode.valueProperty();
                bind(p);
                if(p.getValue() == "Utenti") return l_utenti;
                else if(p.getValue() == "Libri") return l_libri;
                else if(p.getValue() == "Prestiti") return l_prestiti;
                throw new RuntimeException("Invalid choice");
            }
        });
        
        Button add = new Button("+");
        Button remove = new Button("-");
        
        add.setPrefSize(40, 40);
        remove.setPrefSize(40, 40);
        
        HBox controls = new HBox(add, remove);
        
        GridPane grid = new GridPane();
        grid.add(mode, 0, 1);
        grid.add(scrollpane, 0, 2);
        grid.add(controls, 0, 3);
        Scene scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
