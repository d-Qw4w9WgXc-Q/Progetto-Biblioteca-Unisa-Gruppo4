package it.unisa.diem.inginf.biblioteca.types;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Objects;

public class Libro {
    private String titolo;
    private String ISBN;
    private Collection<String> autori;
    private int nCopie;
    private int annoPubblicazione;

    public Libro(String titolo, String ISBN, Collection<String> autori, int nCopie, int annoPublicazione) {
        this.titolo = titolo;
        this.ISBN = ISBN;
        this.nCopie = nCopie;
        this.annoPubblicazione = annoPublicazione;
        
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

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }
    
    @Override
    public String toString() {
        String ret = String.format("Titolo: %s, ISBN: %s, Numero copie: %d, Anno publicazione: %d, Autori:\n", titolo, ISBN, nCopie, annoPubblicazione);
        for(String autore : autori) {
            ret += "- " + autore + "\n";
        }
        
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.titolo);
        hash = 89 * hash + Objects.hashCode(this.ISBN);
        hash = 89 * hash + Objects.hashCode(this.autori);
        hash = 89 * hash + this.nCopie;
        hash = 89 * hash + this.annoPubblicazione;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.nCopie != other.nCopie) {
            return false;
        }
        if (this.annoPubblicazione != other.annoPubblicazione) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        return Objects.equals(this.autori, other.autori);
    }
    
    
}

