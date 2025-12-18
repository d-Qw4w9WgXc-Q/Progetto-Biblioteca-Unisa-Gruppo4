package it.unisa.diem.inginf.biblioteca.ui;

import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.Libro;
import it.unisa.diem.inginf.biblioteca.types.Prestito;
import it.unisa.diem.inginf.biblioteca.types.Utente;
import javafx.beans.property.ObjectProperty;


public class EditMenu {
    
    private ObjectProperty<String> type;
    
    private Menu<Utente> menuUtente;
    private Menu<Libro> menuLibro;
    private Menu<Prestito> menuPrestito;
    
    
    public EditMenu(Biblioteca b, ObjectProperty<String> type) {
        this.type = type;
        
        menuUtente = new MenuUtente(b);
        menuLibro = new MenuLibro(b);
        menuPrestito = new MenuPrestito(b);

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
                menuPrestito.show((Prestito)ob);
                break;
            default: throw new RuntimeException(selection);
        }
    }
}
