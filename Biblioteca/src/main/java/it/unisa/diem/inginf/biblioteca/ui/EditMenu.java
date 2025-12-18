package it.unisa.diem.inginf.biblioteca.ui;

import it.unisa.diem.inginf.biblioteca.Biblioteca;
import it.unisa.diem.inginf.biblioteca.types.*;
import javafx.beans.property.*;


/**
 * Dispatcher che apre il menu di edit corretto (utente/libro/prestito) in base alla selezione corrente.
 */
public class EditMenu {
    
    private ObjectProperty<String> type;
    
    private Menu<Utente> menuUtente;
    private Menu<Libro> menuLibro;
    private Menu<Prestito> menuPrestito;
    
    
    /**
     * Crea un dispatcher di menu di edit in base al tipo selezionato.
     * @param b biblioteca di riferimento
     * @param type property con selezione ("Utenti", "Libri", "Prestiti")
     */
    public EditMenu(Biblioteca b, ObjectProperty<String> type) {
        this.type = type;
        
        menuUtente = new MenuUtente(b);
        menuLibro = new MenuLibro(b);
        menuPrestito = new MenuPrestito(b);

    }
    
    /**
     * Mostra il menu relativo alla selezione corrente, in modalità modifica se {@code ob} non è nullo.
     * @param ob oggetto selezionato (utente/libro/prestito) oppure {@code null} per creazione
     */
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
