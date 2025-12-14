package it.unisa.diem.inginf.biblioteca;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import it.unisa.diem.inginf.biblioteca.types.*;
import it.unisa.diem.inginf.biblioteca.ui.App;
import javafx.collections.*;

public class Biblioteca {

    ObservableList<Utente> utenti;
    ObservableList<Libro> libri;
    ObservableList<Prestito> prestiti;
    
    public Biblioteca() {
        utenti = FXCollections.observableArrayList();
        libri = FXCollections.observableArrayList();
        prestiti = FXCollections.observableArrayList();
    }
    
    public boolean registraUtente(Utente e) {
        return utenti.add(e);
    }
    
    public Utente cercaUtente(Utente e, Comparator<Utente> c) {
        for(Utente utente : utenti) {
            if(c.compare(utente, e) == 0) return utente;
        }
        
        return null;
    }
    
    public ObservableList<Utente> getUtenti() {
        return utenti;
    }
    
    public void ordinaUtenti(Comparator<Utente> c) {
        utenti.sort(c);
    }
    
    public boolean eliminaUtente(Utente e) {
        return utenti.remove(e);
    }
    
    public boolean eliminaUtente(Utente e, Comparator<Utente> c) {
        for(Utente utente : utenti) {
            if(c.compare(e, utente) == 0) {
                utenti.remove(utente);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean registraLibro(Libro e) {
        return libri.add(e);
    }
    
    public Libro cercaLibro(Libro e, Comparator<Libro> c) {
        for(Libro libro : libri) {
            if(c.compare(libro, e) == 0) return libro;
        }
        
        return null;
    }
    
    public ObservableList<Libro> getLibri() {
        return libri;
    }
    
    public void ordinaLibri(Comparator<Libro> c) {
        libri.sort(c);
    }
    
    public boolean eliminaLibro(Libro e) {
        return libri.remove(e);
    }
    
    public boolean eliminaLibro(Libro e, Comparator<Libro> c) {
        for(Libro libro : libri) {
            if(c.compare(e, libro) == 0) {
                libri.remove(libro);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean registraPrestito(Prestito e) {
        return prestiti.add(e);
    }
    
    public boolean eliminaPrestito(Prestito e) {
        return prestiti.remove(e);
    }
    
    public boolean eliminaPrestito(Prestito e, Comparator<Prestito> c) {
        for(Prestito prestito : prestiti) {
            if(c.compare(e, prestito) == 0) {
                prestiti.remove(prestito);
                return true;
            }
        }
        
        return false;
    }
    
    public ObservableList<Prestito> getPrestiti() {
        return prestiti;
    }
    
    public void ordinaPrestiti(Comparator<Prestito> c) {
        prestiti.sort(c);
    }
    
    public static void main(String[] args) {
        App.launch(App.class, args);
    }
}
