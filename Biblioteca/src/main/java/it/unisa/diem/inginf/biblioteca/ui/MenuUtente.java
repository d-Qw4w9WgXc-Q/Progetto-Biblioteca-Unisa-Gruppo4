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


public class MenuUtente {
    
    private Stage stage;
    
    TextField tNome;
    TextField tCognome;
    TextField tMatricola;
    TextField tEmail;
    
    Button ok;
    
    Biblioteca biblioteca;
    
    public MenuUtente(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        
        GridPane gridUtenti = new GridPane();
        gridUtenti.setVgap(13);
        
        stage = new Stage();
        stage.setAlwaysOnTop(true);

        Scene scene = new Scene(gridUtenti, 300, 300);
        stage.setScene(scene);

        
        tNome = new TextField();
        tCognome = new TextField();
        tMatricola = new TextField();
        tEmail = new TextField();
        
        Label lNome = new Label("Nome: ");
        Label lCognome = new Label("Cognome: ");
        Label lMatricola = new Label("Matricola: ");
        Label lEmail = new Label("Email: ");
        
        ok = new Button("OK");
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
        
        
    }
    
    // Modifica Utente
    public void show(Utente u) {
        if(u == null) {
            show();
            return;
        }
        tNome.setText(u.getNome());
        tCognome.setText(u.getCognome());
        tMatricola.setText(u.getMatricola());
        tEmail.setText(u.getEmail());
        
        ok.setOnAction((ActionEvent ev) -> {
            u.setNome(tNome.getText());
            u.setCognome(tCognome.getText());
            u.setMatricola(tMatricola.getText());
            u.setEmail(tEmail.getText());
            stage.close();
        });
        
        stage.show();
    }
    
    // Aggiungi nuovo utente
    public void show() {
        tNome.setText(null);
        tCognome.setText(null);
        tMatricola.setText(null);
        tEmail.setText(null);
        
        ok.setOnAction((ActionEvent ev) -> {
            biblioteca.registraUtente(new Utente(
                    tNome.getText(),
                    tCognome.getText(),
                    tMatricola.getText(),
                    tEmail.getText()
            ));
            stage.close();
        });
        
        stage.show();
    }
    
}
