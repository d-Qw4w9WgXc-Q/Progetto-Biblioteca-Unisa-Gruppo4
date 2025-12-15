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


public class AddMenu {
    
    private Biblioteca biblioteca;
    
    private Scene scene;
    private Stage stage;
    
    private GridPane gridUtenti;
    private GridPane gridLibri;
    private GridPane gridPrestiti;
    
    
    public AddMenu(Biblioteca b, ObjectProperty<String> type) {
        biblioteca = b;
        
        
        createUtenti();
        createLibri();
        createPrestiti();

        scene = new Scene(gridUtenti);
        
        stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        
        scene.rootProperty().bind(new ObjectBinding() {
            @Override
            protected Object computeValue() {
                bind(type);
                String selection = type.getValue();
                switch(selection) {
                    case "Utenti":
                        stage.setHeight(300);
                        stage.setWidth(300);
                        return gridUtenti;
                    case "Libri":
                        stage.setHeight(300);
                        stage.setWidth(300);
                        return gridLibri;
                    case "Prestiti":
                        stage.setHeight(400);
                        stage.setWidth(700);
                        return gridPrestiti;
                    default: throw new RuntimeException("Invalid Choice");
                }
            }
        });

    }
    
    
    private void createUtenti() {
        gridUtenti = new GridPane();
        gridUtenti.setVgap(13);
        
        TextField tNome = new TextField();
        TextField tCognome = new TextField();
        TextField tMatricola = new TextField();
        TextField tEmail = new TextField();
        
        Label lNome = new Label("Nome: ");
        Label lCognome = new Label("Cognome: ");
        Label lMatricola = new Label("Matricola: ");
        Label lEmail = new Label("Email: ");
        
        Button ok = new Button("OK");
        Button annulla = new Button("Annulla");
        annulla.setOnAction((ActionEvent ev) -> {
            stage.close();
        });
        
        gridUtenti.add(lNome, 0, 0);
        gridUtenti.add(tNome, 1, 0);
        
        gridUtenti.add(lCognome, 0, 1);
        gridUtenti.add(tCognome, 1, 1);
        
        gridUtenti.add(lMatricola, 0, 2);
        gridUtenti.add(tMatricola, 1, 2);
        
        gridUtenti.add(lEmail, 0, 3);
        gridUtenti.add(tEmail, 1, 3);
        
        
        gridUtenti.add(ok, 0, 4);
        gridUtenti.add(annulla, 1, 4);
        
        ok.setOnAction((ActionEvent ev) -> {
            biblioteca.registraUtente(new Utente(tNome.getText(), tCognome.getText(), tMatricola.getText(), tEmail.getText()));
            stage.close();
        });
    }
    
    private void createLibri() {
        gridLibri = new GridPane();
    }
    
    private void createPrestiti() {
        gridPrestiti = new GridPane();
    }
    
    public void show() {
        stage.show();
    }
}
