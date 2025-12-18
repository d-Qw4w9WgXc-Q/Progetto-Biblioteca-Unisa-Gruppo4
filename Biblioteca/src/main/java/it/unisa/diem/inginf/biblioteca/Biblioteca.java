package it.unisa.diem.inginf.biblioteca;

import java.util.Comparator;
import it.unisa.diem.inginf.biblioteca.types.*;
import it.unisa.diem.inginf.biblioteca.ui.App;
import javafx.collections.*;

/**
 * Modello in memoria della biblioteca.
 * Gestisce collezioni osservabili di utenti, libri e prestiti con operazioni base di ricerca, ordinamento e rimozione.
 */
public class Biblioteca {

    ObservableList<Utente> utenti;
    ObservableList<Libro> libri;
    ObservableList<Prestito> prestiti;
    
    /**
     * Crea una nuova biblioteca vuota (liste osservabili per utenti, libri e prestiti).
     */
    public Biblioteca() {
        utenti = FXCollections.observableArrayList();
        libri = FXCollections.observableArrayList();
        prestiti = FXCollections.observableArrayList();
    }
    
    /**
     * Registra un utente nella biblioteca.
     * @param e utente da aggiungere
     * @return {@code true} se aggiunto
     */
    public boolean registraUtente(Utente e) {
        return utenti.add(e);
    }
    
    /**
     * Cerca un utente confrontandolo con un comparatore.
     * @param e utente da cercare
     * @param c comparatore usato per l'uguaglianza (0 = match)
     * @return utente trovato o {@code null}
     */
    public Utente cercaUtente(Utente e, Comparator<Utente> c) {
        for(Utente utente : utenti) {
            if(c.compare(utente, e) == 0) return utente;
        }
        
        return null;
    }
    
    /**
     * Restituisce la lista osservabile degli utenti.
     * @return lista utenti
     */
    public ObservableList<Utente> getUtenti() {
        return utenti;
    }
    
    /**
     * Ordina gli utenti con il comparatore fornito.
     * @param c comparatore di ordinamento
     */
    public void ordinaUtenti(Comparator<Utente> c) {
        utenti.sort(c);
    }
    
    /**
     * Elimina un utente dalla lista.
     * @param e utente da rimuovere
     * @return {@code true} se rimosso
     */
    public boolean eliminaUtente(Utente e) {
        return utenti.remove(e);
    }
    
    /**
     * Elimina un utente confrontandolo con un comparatore.
     * @param e utente da rimuovere
     * @param c comparatore usato per l'uguaglianza (0 = match)
     * @return {@code true} se rimosso
     */
    public boolean eliminaUtente(Utente e, Comparator<Utente> c) {
        for(Utente utente : utenti) {
            if(c.compare(e, utente) == 0) {
                utenti.remove(utente);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Registra un libro nella biblioteca.
     * @param e libro da aggiungere
     * @return {@code true} se aggiunto
     */
    public boolean registraLibro(Libro e) {
        return libri.add(e);
    }
    
    /**
     * Cerca un libro confrontandolo con un comparatore.
     * @param e libro da cercare
     * @param c comparatore usato per l'uguaglianza (0 = match)
     * @return libro trovato o {@code null}
     */
    public Libro cercaLibro(Libro e, Comparator<Libro> c) {
        for(Libro libro : libri) {
            if(c.compare(libro, e) == 0) return libro;
        }
        
        return null;
    }
    
    /**
     * Restituisce la lista osservabile dei libri.
     * @return lista libri
     */
    public ObservableList<Libro> getLibri() {
        return libri;
    }
    
    /**
     * Ordina i libri con il comparatore fornito.
     * @param c comparatore di ordinamento
     */
    public void ordinaLibri(Comparator<Libro> c) {
        libri.sort(c);
    }
    
    /**
     * Elimina un libro dalla lista.
     * @param e libro da rimuovere
     * @return {@code true} se rimosso
     */
    public boolean eliminaLibro(Libro e) {
        return libri.remove(e);
    }
    
    /**
     * Elimina un libro confrontandolo con un comparatore.
     * @param e libro da rimuovere
     * @param c comparatore usato per l'uguaglianza (0 = match)
     * @return {@code true} se rimosso
     */
    public boolean eliminaLibro(Libro e, Comparator<Libro> c) {
        for(Libro libro : libri) {
            if(c.compare(e, libro) == 0) {
                libri.remove(libro);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Registra un prestito nella biblioteca.
     * @param e prestito da aggiungere
     * @return {@code true} se aggiunto
     */
    public boolean registraPrestito(Prestito e) {
        return prestiti.add(e);
    }
    
    /**
     * Elimina un prestito dalla lista.
     * @param e prestito da rimuovere
     * @return {@code true} se rimosso
     */
    public boolean eliminaPrestito(Prestito e) {
        return prestiti.remove(e);
    }
    
    /**
     * Elimina un prestito confrontandolo con un comparatore.
     * @param e prestito da rimuovere
     * @param c comparatore usato per l'uguaglianza (0 = match)
     * @return {@code true} se rimosso
     */
    public boolean eliminaPrestito(Prestito e, Comparator<Prestito> c) {
        for(Prestito prestito : prestiti) {
            if(c.compare(e, prestito) == 0) {
                prestiti.remove(prestito);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Restituisce la lista osservabile dei prestiti.
     * @return lista prestiti
     */
    public ObservableList<Prestito> getPrestiti() {
        return prestiti;
    }
    
    /**
     * Ordina i prestiti con il comparatore fornito.
     * @param c comparatore di ordinamento
     */
    public void ordinaPrestiti(Comparator<Prestito> c) {
        prestiti.sort(c);
    }
    
    /**
     * Avvia l'applicazione JavaFX.
     * @param args argomenti da linea di comando
     */
    public static void main(String[] args) {
        App.launch(App.class, args);
    }
}
