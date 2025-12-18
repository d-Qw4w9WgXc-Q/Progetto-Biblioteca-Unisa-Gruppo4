package it.unisa.diem.inginf.biblioteca;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import it.unisa.diem.inginf.biblioteca.types.*;
import it.unisa.diem.inginf.biblioteca.ui.App;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
    
    private Biblioteca(BibliotecaData dati) {
        utenti = FXCollections.observableArrayList(dati.getUtenti());
        libri = FXCollections.observableArrayList(dati.getLibri());
        prestiti = FXCollections.observableArrayList(dati.getPrestiti());
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
    
    public void toFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(new BibliotecaData(utenti, libri, prestiti));
        }
    }
    
    public static Biblioteca fromFile(String filename) {
        BibliotecaData dati;
        
        try{
            FileInputStream fin = new FileInputStream(filename);
            try (ObjectInputStream ois = new ObjectInputStream(fin)) {
                dati = (BibliotecaData)ois.readObject();
            }
        } catch(IOException | ClassNotFoundException e) {
            return new Biblioteca();
        }
        
        return new Biblioteca(dati);
}
    
    public static void main(String[] args) {
        App.launch(App.class, args);
    }
}

class BibliotecaData implements Serializable {
    ArrayList<Utente> utenti;
    ArrayList<Libro> libri;
    ArrayList<Prestito> prestiti;

    public BibliotecaData(Collection<Utente> utenti, Collection<Libro> libri, Collection<Prestito> prestiti) {
        this.utenti = new ArrayList<>(utenti);
        this.libri = new ArrayList<>(libri);
        this.prestiti = new ArrayList<>(prestiti);
    }

    public ArrayList<Utente> getUtenti() {
        return utenti;
    }

    public ArrayList<Libro> getLibri() {
        return libri;
    }

    public ArrayList<Prestito> getPrestiti() {
        return prestiti;
    }
}