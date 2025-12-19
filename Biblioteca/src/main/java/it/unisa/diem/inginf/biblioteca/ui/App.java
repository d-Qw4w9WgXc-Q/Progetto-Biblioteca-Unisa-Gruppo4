package it.unisa.diem.inginf.biblioteca.ui;

import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.*;
import it.unisa.diem.inginf.biblioteca.types.Comparators.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.event.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


/**
 * Applicazione JavaFX della biblioteca: mostra liste (utenti, libri, prestiti) e consente aggiunta/modifica/rimozione.
 */
public class App extends Application {
    /**
     * Entry point JavaFX: costruisce UI e connette i controlli alle liste osservabili della biblioteca.
     * @param stage primary stage
     */
    @Override
    public void start(Stage stage) {
        final Biblioteca biblioteca;
        
        biblioteca = Biblioteca.fromFile("ArchivioBiblioteca");
        
        
        ChoiceBox<String> mode = new ChoiceBox<>();
        mode.getItems().addAll("Utenti", "Libri", "Prestiti");
        mode.setValue("Utenti");
        

        ListView<Utente> lvUtenti = new ListView<>(biblioteca.getUtenti());
        ListView<Libro> lvLibri = new ListView<>(biblioteca.getLibri());
        ListView<Prestito> lvPrestiti = new ListView<>(biblioteca.getPrestiti());

        
        lvUtenti.setPrefSize(1000, 400);
        lvLibri.setPrefSize(1000, 400);
        lvPrestiti.setPrefSize(1000, 400);
        
        ChoiceBox sortUtenti = new ChoiceBox();
        sortUtenti.getItems().addAll("Nome", "Cognome", "Matricola");
        sortUtenti.valueProperty().addListener(new SortUtenti(biblioteca));
        
        ChoiceBox sortLibri = new ChoiceBox();
        sortLibri.getItems().addAll("Titolo", "Autori");
        sortLibri.valueProperty().addListener(new SortLibri(biblioteca));
        
        ChoiceBox sortPrestiti = new ChoiceBox();
        sortPrestiti.getItems().addAll("Data Prestito", "Data Restituzione");
        sortPrestiti.valueProperty().addListener(new SortPrestiti(biblioteca));
        
        
        VBox utenti = new VBox(new HBox(new Label("Ordina per: "), sortUtenti), lvUtenti);
        VBox libri = new VBox(new HBox(new Label("Ordina per: "), sortLibri), lvLibri);
        VBox prestiti = new VBox(new HBox(new Label("Ordina per: "), sortPrestiti), lvPrestiti);
        
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setPrefSize(700, 400);
        
        
        scrollpane.contentProperty().bind(new ObjectBinding() {
            @Override
            protected Object computeValue() {
                Property p = mode.valueProperty();
                bind(p);
                String val = (String)p.getValue();
                switch(val) {
                    case "Utenti": return utenti;
                    case "Libri": return libri;
                    case "Prestiti": return prestiti;
                    default: throw new RuntimeException("Invalid choice");
                }

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
            sortUtenti.getSelectionModel().select(null);
            sortLibri.getSelectionModel().select(null);
            sortPrestiti.getSelectionModel().select(null);
            editMenu.show(null);
        });
        
        modify.setOnAction((ActionEvent ev) -> {
            sortUtenti.getSelectionModel().select(null);
            sortLibri.getSelectionModel().select(null);
            sortPrestiti.getSelectionModel().select(null);
            editMenu.show(((ListView)(((VBox)scrollpane.getContent()).getChildren().getLast())).getSelectionModel().getSelectedItem());
        });
        
        remove.setOnAction((ActionEvent ev) -> {
            String selection = mode.getValue();
            switch(selection) {
                case "Utenti":
                    biblioteca.eliminaUtente(lvUtenti.getSelectionModel().getSelectedItem());
                    break;
                case "Libri":
                    biblioteca.eliminaLibro(lvLibri.getSelectionModel().getSelectedItem());
                    break;
                case "Prestiti":
                    Prestito p = lvPrestiti.getSelectionModel().getSelectedItem();
                    Libro l = p.getLibro();
                    l.setnCopie(l.getnCopie() + 1);
                    biblioteca.eliminaPrestito(p);
                    biblioteca.ordinaLibri(new CompLibroTitolo());
                    break;
            }
        });
        
        
        
        Ricerca r = new Ricerca(biblioteca, mode, lvUtenti, lvLibri);
        Button searchmenu = new Button("Cerca..");
        
        searchmenu.setOnAction((ActionEvent ev) -> {
            r.show();
        });
        
        Button save = new Button("Salva");
        save.setOnAction((ActionEvent ev) -> {
            try{
                biblioteca.toFile("ArchivioBiblioteca");
            } catch(IOException e) {
            }
        });
        
        HBox controls = new HBox(add, modify, remove, searchmenu, save);
        
        GridPane grid = new GridPane();
        grid.add(mode, 0, 1);
        grid.add(scrollpane, 0, 2);
        grid.add(controls, 0, 3);
        Scene scene = new Scene(grid, 700, 500);
        stage.setScene(scene);
        stage.show();
    }
}
                
                
class SortUtenti implements ChangeListener<String> {
    
    Biblioteca biblioteca;
    
    public SortUtenti(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    @Override
    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
        switch(newValue) {
            case "Nome":
                biblioteca.ordinaUtenti(new CompUtenteNome());
                break;
            case "Cognome":
                biblioteca.ordinaUtenti(new CompUtenteCognome());
                break;
            case "Matricola":
                biblioteca.ordinaUtenti(new CompUtenteMatricola());
                break;
        }
    }
}

class SortLibri implements ChangeListener<String> {
    
    Biblioteca biblioteca;
    
    public SortLibri(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    @Override
    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
        switch(newValue) {
            case "Titolo":
                biblioteca.ordinaLibri(new CompLibroTitolo());
                break;
            case "Autori":
                biblioteca.ordinaLibri(new CompLibroAutori());
                break;
        }
    }
}

class SortPrestiti implements ChangeListener<String> {
    
    Biblioteca biblioteca;
    
    public SortPrestiti(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    @Override
    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
        switch(newValue) {
            case "Data Prestito":
                    biblioteca.ordinaPrestiti(new CompPrestitoDataPrestito());
                break;
            case "Data Restituzione":
                    biblioteca.ordinaPrestiti(new CompPrestitoDataRestituzione());
                break;
        }
    }
}