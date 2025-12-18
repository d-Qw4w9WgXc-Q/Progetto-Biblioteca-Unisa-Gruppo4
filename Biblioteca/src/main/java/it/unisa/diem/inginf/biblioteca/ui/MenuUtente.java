package it.unisa.diem.inginf.biblioteca.ui;

import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.*;


/**
 * Finestra JavaFX per creare o modificare un {@link it.unisa.diem.inginf.biblioteca.types.Utente}.
 */
public class MenuUtente implements Menu<Utente> {
    
    private Stage stage;
    
    private TextField tNome;
    private TextField tCognome;
    private TextField tMatricola;
    private TextField tEmail;
    
    private Button ok;
    
    private Biblioteca biblioteca;
    
    /**
     * Crea il menu per inserimento/modifica utenti.
     * @param biblioteca biblioteca di riferimento
     */
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
    /**
     * Mostra la finestra in modalità modifica.
     * @param u utente da modificare (se {@code null} apre la modalità creazione)
     */
    @Override
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
    /**
     * Mostra la finestra in modalità creazione di un nuovo utente.
     */
    @Override
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
