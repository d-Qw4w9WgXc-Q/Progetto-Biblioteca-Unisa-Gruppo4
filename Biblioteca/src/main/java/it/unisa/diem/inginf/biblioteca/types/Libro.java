package it.unisa.diem.inginf.biblioteca.types;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Rappresenta un libro della biblioteca (titolo, ISBN, autori, numero di copie e anno di pubblicazione).
 */
public class Libro {
    private String titolo;
    private String ISBN;
    private Collection<String> autori;
    private int nCopie;
    private int annoPubblicazione;

    /**
     * Crea un libro.
     * @param titolo titolo
     * @param ISBN codice ISBN
     * @param autori collezione di autori
     * @param nCopie numero di copie disponibili
     * @param annoPublicazione anno di pubblicazione
     */
    public Libro(String titolo, String ISBN, Collection<String> autori, int nCopie, int annoPublicazione) {
        this.titolo = titolo;
        this.ISBN = ISBN;
        this.nCopie = nCopie;
        this.annoPubblicazione = annoPublicazione;
        
        this.autori = new ArrayList<>(autori);
    }
    
    /**
     * Restituisce il titolo.
     * @return titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Imposta il titolo.
     * @param titolo nuovo titolo
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Restituisce l'ISBN.
     * @return ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Imposta l'ISBN.
     * @param ISBN nuovo ISBN
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Restituisce gli autori.
     * @return collezione autori
     */
    public Collection<String> getAutori() {
        return autori;
    }

    /**
     * Imposta gli autori.
     * @param autori collezione autori
     */
    public void setAutori(Collection<String> autori) {
        this.autori = autori;
    }

    /**
     * Restituisce il numero di copie.
     * @return numero copie
     */
    public int getnCopie() {
        return nCopie;
    }

    /**
     * Imposta il numero di copie.
     * @param nCopie nuovo numero copie
     */
    public void setnCopie(int nCopie) {
        this.nCopie = nCopie;
    }

    /**
     * Restituisce l'anno di pubblicazione.
     * @return anno di pubblicazione
     */
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    /**
     * Imposta l'anno di pubblicazione.
     * @param annoPubblicazione nuovo anno di pubblicazione
     */
    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }
    
    /**
     * Restituisce una rappresentazione testuale del libro.
     * @return stringa descrittiva
     */
    @Override
    public String toString() {
        String ret = String.format("Titolo: %s, ISBN: %s, Numero copie: %d, Anno publicazione: %d, Autori:\n", titolo, ISBN, nCopie, annoPubblicazione);
        for(String autore : autori) {
            ret += "- " + autore + "\n";
        }
        
        return ret;
    }

    /**
     * Calcola l'hash del libro.
     * @return hash code
     */
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

    /**
     * Confronta due libri per uguaglianza sui campi principali.
     * @param obj oggetto da confrontare
     * @return {@code true} se uguali
     */
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
