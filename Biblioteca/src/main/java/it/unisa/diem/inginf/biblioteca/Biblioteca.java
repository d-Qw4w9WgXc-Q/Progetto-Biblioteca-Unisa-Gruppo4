package it.unisa.diem.inginf.biblioteca;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import it.unisa.diem.inginf.biblioteca.types.*;

public class Biblioteca {

    Collection<Utente> utenti;
    Collection<Libro> libri;
    Collection<Prestito> prestiti;
    
    Biblioteca() {
        utenti = new TreeSet<>();
        libri = new TreeSet<>();
        prestiti = new TreeSet<>();
    }
    
    boolean registraUtente(Utente e) {
        return utenti.add(e);
    }
    
    Utente cercaUtente(Utente e, Comparator<Utente> c) {
        for(Utente utente : utenti) {
            if(c.compare(utente, e) == 0) return utente;
        }
        
        return null;
    }
    
    Collection<Utente> elencoUtenti(Comparator<Utente> c) {
        return null; // TODO
    }
    
    boolean eliminaUtente(Utente e) {
        return utenti.remove(e);
    }
    
    boolean eliminaUtente(Utente e, Comparator<Utente> c) {
        for(Utente utente : utenti) {
            if(c.compare(e, utente) == 0) {
                utenti.remove(utente);
                return true;
            }
        }
        
        return false;
    }
    
    boolean registraLibro(Libro e) {
        return libri.add(e);
    }
    
    Libro cercaLibro(Libro e, Comparator<Libro> c) {
        for(Libro libro : libri) {
            if(c.compare(libro, e) == 0) return libro;
        }
        
        return null;
    }
    
    Collection<Libro> elencoLibri(Comparator<Libro> c) {
        return null; // TODO
    }
    
    boolean eliminaLibro(Libro e) {
        return libri.remove(e);
    }
    
    boolean eliminaLibro(Libro e, Comparator<Libro> c) {
        for(Libro libro : libri) {
            if(c.compare(e, libro) == 0) {
                libri.remove(libro);
                return true;
            }
        }
        
        return false;
    }
    
    boolean registraPrestito(Prestito e) {
        return prestiti.add(e);
    }
    
    boolean eliminaPrestito(Prestito e) {
        return prestiti.remove(e);
    }
    
    boolean eliminaPrestito(Prestito e, Comparator<Prestito> c) {
        for(Prestito prestito : prestiti) {
            if(c.compare(e, prestito) == 0) {
                prestiti.remove(prestito);
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
