package it.unisa.diem.inginf.biblioteca.ui;

import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.*;
import it.unisa.diem.inginf.biblioteca.types.Comparators.*;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Ricerca {
    private final Biblioteca biblioteca;
    private final ChoiceBox campiLibri;
    private final ChoiceBox campiUtenti;
    private final ChoiceBox categoria;
    
    private final Stage stage;
    
    private ChoiceBox menu;
    private ListView lUtenti;
    private ListView lLibri;

    private final TextField ricerca;
    
    public Ricerca(Biblioteca biblioteca, ChoiceBox menu, ListView lUtenti, ListView lLibri) {
        this.biblioteca = biblioteca;
        
        this.menu = menu;
        this.lUtenti = lUtenti;
        this.lLibri = lLibri;
        
        categoria = new ChoiceBox();
        categoria.getItems().addAll("Utenti", "Libri");
        categoria.getSelectionModel().select("Utenti");
        
        campiUtenti = new ChoiceBox();
        campiUtenti.getItems().addAll("Nome", "Cognome", "Matricola");
        
        campiLibri = new ChoiceBox();
        campiLibri.getItems().addAll("Titolo", "Autori", "ISBN");
        
        VBox campo = new VBox(categoria, campiUtenti);
        
        categoria.valueProperty().addListener(new ChangeListener<String>() {
            
            @Override
            public void changed(ObservableValue ov, String oldValue, String newValue) {
                switch(newValue) {
                    case "Utenti":
                        campo.getChildren().set(1, campiUtenti);
                        break;
                    case "Libri":
                        campo.getChildren().set(1, campiLibri);
                        break;
                }
            }
        });
        
        ricerca = new TextField();
        Button ok = new Button("Cerca");
        
        GridPane grid = new GridPane();
        grid.add(campo, 0, 0);
        grid.add(ricerca, 0, 1);
        grid.add(ok, 1, 1);
        Scene scene = new Scene(grid, 300, 150);
        stage = new Stage();
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        
        ok.setOnAction((ActionEvent ev) -> {
            switch((String)categoria.getValue()) {
                case "Utenti":
                    cercaUtente();
                    break;
                case "Libri":
                    cercaLibro();
                    break;
            }
        });
    }
    
    public void show() {
        stage.show();
    }
    
    private void cercaUtente() {
        menu.getSelectionModel().select("Utenti");
        Utente u = null;
        
        switch((String)campiUtenti.getValue()) {
            case "Nome":
                u = biblioteca.cercaUtente(new Utente(ricerca.getText(), null, null, null), new CompUtenteNome());
                break;
            case "Cognome":
                u = biblioteca.cercaUtente(new Utente(null, ricerca.getText(), null, null), new CompUtenteCognome());
                break;
            case "Matricola":
                u = biblioteca.cercaUtente(new Utente(null, null, ricerca.getText(), null), new CompUtenteMatricola());
                break;
            default:
                u = null;
                break;
        }
        
        lUtenti.getSelectionModel().select(u);
    }
    
    
    private void cercaLibro() {
        menu.getSelectionModel().select("Libri");
        Libro l = null;
        
        switch((String)campiLibri.getValue()) {
            case "Titolo":
                l = biblioteca.cercaLibro(new Libro(ricerca.getText(), null, null, 0, 0), new CompLibroTitolo());
                break;
            case "ISBN":
                l = biblioteca.cercaLibro(new Libro(null, ricerca.getText(), null, 0, 0), new CompLibroISBN());
                break;
            case "Autori":
                for(Libro libro : biblioteca.getLibri()) {
                    if(libro.getAutori().contains(ricerca.getText())) {
                        l = libro;
                        break;
                    }
                }
                break;
            default:
                l = null;
                break;
        }
        
        lLibri.getSelectionModel().select(l);
    }
}
