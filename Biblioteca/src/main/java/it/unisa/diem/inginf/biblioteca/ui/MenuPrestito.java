package it.unisa.diem.inginf.biblioteca.ui;


import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.*;
import java.time.ZoneId;
import java.util.Date;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.*;


public class MenuPrestito implements Menu<Prestito> {
    
    private Stage stage;
    
    private ListView<Utente> utenti;
    private ListView<Libro> libri;
    
    private DatePicker data;
    
    private Button ok;
    
    Biblioteca biblioteca;
    
    public MenuPrestito(Biblioteca b) {
        GridPane gridPrestiti = new GridPane();
        gridPrestiti.setVgap(13);
        
        this.biblioteca = b;
        
        Scene scene = new Scene(gridPrestiti, 700, 400);
        
        stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        
        
        utenti = new ListView<>(b.getUtenti());
        libri = new ListView<>(b.getLibri());
        
        data = new DatePicker();
        
        ok = new Button("Ok");
        Button annulla = new Button("Annulla");
        annulla.setOnAction((ActionEvent ev) -> {
            stage.close();
        });
        
        HBox controlli = new HBox(ok, annulla);
        controlli.setSpacing(3);
        
        gridPrestiti.add(new Label("Utente:"), 0, 0);
        gridPrestiti.add(new Label("Scadenza:"), 1, 0);
        gridPrestiti.add(new Label("Libro:"), 2, 0);
        
        gridPrestiti.add(utenti, 0, 1);
        gridPrestiti.add(data, 1, 1);
        gridPrestiti.add(libri, 2, 1);
        gridPrestiti.add(controlli, 0, 2);
    }

    @Override
    public void show(Prestito ob) {
        if(ob == null) {
            show();
            return;
        }
        
        stage.show();
    }

    @Override
    public void show() {
        ok.setOnAction((ActionEvent ev) -> {
            Libro l = libri.getSelectionModel().getSelectedItem();
            Utente u = utenti.getSelectionModel().getSelectedItem();
            
            if(u.getLibri().toArray().length >= 3 || l.getnCopie() <= 0)
                throw new RuntimeException("Prestito invalido");
            
            biblioteca.registraPrestito(new Prestito(
                    new Date(),
                    Date.from(data.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    l,
                    u
            ));
            
            l.setnCopie(l.getnCopie() - 1);
            u.getLibri().add(l);
            
            stage.close();
        });
        
        stage.show();
    }
}
