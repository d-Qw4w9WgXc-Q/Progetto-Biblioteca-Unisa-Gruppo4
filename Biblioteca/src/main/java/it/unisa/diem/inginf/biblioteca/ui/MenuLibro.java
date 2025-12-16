package it.unisa.diem.inginf.biblioteca.ui;


import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.*;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.event.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;


public class MenuLibro {
    
    private Stage stage;
    
    TextField tTitolo;
    TextField tISBN;
    TextField tAutori;
    TextField tAnnoPubblicazione;
    TextField tNumeroCopie;
    
    Button ok;
    
    Biblioteca biblioteca;
    
    
    public MenuLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        
        GridPane gridLibri = new GridPane();
        gridLibri.setVgap(13);
        
        stage = new Stage();
        stage.setAlwaysOnTop(true);

        Scene scene = new Scene(gridLibri, 300, 300);
        stage.setScene(scene);

        
        tTitolo = new TextField();
        tISBN = new TextField();
        tAutori = new TextField();
        tAnnoPubblicazione = new TextField();
        tNumeroCopie = new TextField();
        
        Label lTitolo = new Label("Titolo: ");
        Label lISBN = new Label("ISBN: ");
        Label lAutori = new Label("Autori (separati da ','): ");
        Label lAnnoPubblicazione = new Label("Anno: ");
        Label lNumeroCopie = new Label("Numero copie: ");
        
        ok = new Button("OK");
        Button annulla = new Button("Annulla");
        annulla.setOnAction((ActionEvent ev) -> {
            stage.close();
        });
        
        gridLibri.add(lTitolo, 0, 0);
        gridLibri.add(tTitolo, 1, 0);
        
        gridLibri.add(lISBN, 0, 1);
        gridLibri.add(tISBN, 1, 1);
        
        gridLibri.add(lAutori, 0, 2);
        gridLibri.add(tAutori, 1, 2);
        
        gridLibri.add(lAnnoPubblicazione, 0, 3);
        gridLibri.add(tAnnoPubblicazione, 1, 3);
        
        gridLibri.add(lNumeroCopie, 0, 4);
        gridLibri.add(tNumeroCopie, 1, 4);

        
        gridLibri.add(ok, 0, 5);
        gridLibri.add(annulla, 1, 5);
        
        
    }
    
    // Modifica Libro
    public void show(Libro l) {
        if(l == null) {
            show();
            return;
        }
        tTitolo.setText(l.getTitolo());
        tISBN.setText(l.getISBN());
        tAutori.setText(String.join(", ", l.getAutori()));
        tNumeroCopie.setText(Integer.toString(l.getnCopie()));
        tAnnoPubblicazione.setText(Integer.toString(l.getAnnoPubblicazione()));
        
        
        ok.setOnAction((ActionEvent ev) -> {
            l.setTitolo(tTitolo.getText());
            l.setISBN(tISBN.getText());
            l.setAutori(Arrays.asList(tAutori.getText().split("\\s*,\\s*")));
            l.setnCopie(Integer.parseInt(tNumeroCopie.getText()));
            l.setAnnoPubblicazione(Integer.parseInt(tAnnoPubblicazione.getText()));
            stage.close();
        });
        
        stage.show();
    }
    
    // Aggiungi nuovo libro
    public void show() {
        tTitolo.setText(null);
        tISBN.setText(null);
        tAutori.setText(null);
        tAnnoPubblicazione.setText(null);
        tNumeroCopie.setText(null);
        
        ok.setOnAction((ActionEvent ev) -> {
            biblioteca.registraLibro(new Libro(
                    tTitolo.getText(),
                    tISBN.getText(),
                    Arrays.asList(tAutori.getText().split(" *, *")),
                    Integer.parseInt(tNumeroCopie.getText()),
                    Integer.parseInt(tAnnoPubblicazione.getText())
            ));
            stage.close();
        });
        
        stage.show();
    }
}
