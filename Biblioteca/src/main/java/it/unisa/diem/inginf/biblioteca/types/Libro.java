package it.unisa.diem.inginf.biblioteca.types;

import java.util.Collection;
import java.util.ArrayList;

public class Libro {
    private String titolo;
    private String ISBN;
    private Collection<String> autori;
    private int nCopie;
    private int annoPublicazione;

    Libro(String titolo, String ISBN, Collection<String> autori, int nCopie, int annoPublicazione) {
        this.titolo = titolo;
        this.ISBN = ISBN;
        this.nCopie = nCopie;
        this.annoPublicazione = annoPublicazione;
        
        this.autori = new ArrayList<>(autori);
    }
    
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Collection<String> getAutori() {
        return autori;
    }

    public void setAutori(Collection<String> autori) {
        this.autori = autori;
    }

    public int getnCopie() {
        return nCopie;
    }

    public void setnCopie(int nCopie) {
        this.nCopie = nCopie;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }
    
    // TODO toString
}

