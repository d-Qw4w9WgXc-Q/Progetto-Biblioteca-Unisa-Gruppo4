package it.unisa.diem.inginf.biblioteca;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import it.unisa.diem.inginf.biblioteca.types.*;
import java.util.Arrays;

public class Biblioteca {

    Collection<Utente> utenti;
    Collection<Libro> libri;
    Collection<Prestito> prestiti;
    
    public Biblioteca() {
        utenti = new TreeSet<>();
        libri = new TreeSet<>();
        prestiti = new TreeSet<>();
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
    
    public Collection<Utente> elencoUtenti(Comparator<Utente> c) {
        return null; // TODO
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
    
    Collection<Libro> elencoLibri(Comparator<Libro> c) {
        return null; // TODO
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
    
    public static void main(String[] args) {
        Utente u = new Utente("Mario", "Rossi", "0612709907", "m.rossi15@studenti.unisa.it");
        System.out.println(u);
        
        String[] autori = {"Mario", "Gianni"};
        Libro l = new Libro("Asdafsd", "isbn", Arrays.asList(autori), 15, 1970);
        System.out.println(l);
    }
}
