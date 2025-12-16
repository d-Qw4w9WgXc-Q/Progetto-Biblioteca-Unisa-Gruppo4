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


public class EditMenu {
    
    private Biblioteca biblioteca;
    private ObjectProperty<String> type;
    
    private MenuUtente menuUtente;
    private MenuLibro menuLibro;
    
    
    public EditMenu(Biblioteca b, ObjectProperty<String> type) {
        biblioteca = b;
        this.type = type;
        
        menuUtente = new MenuUtente(b);
        menuLibro = new MenuLibro(b);

    }
    
    public void show(Object ob) {
        String selection = type.getValue();
        switch(selection) {
            case "Utenti":
                menuUtente.show((Utente)ob);
                break;
            case "Libri":
                menuLibro.show((Libro)ob);
                break;
            case "Prestiti":
                // menuPrestiti.show((Prestito)ob);
                break;
            default: throw new RuntimeException(selection);
        }
    }
}
