package it.unisa.diem.inginf.biblioteca.types;

import java.io.Serializable;
import java.util.Objects;
import java.util.Collection;
import java.util.ArrayList;


/**
 * Rappresenta un utente della biblioteca con dati anagrafici e l'elenco dei libri presi in prestito.
 */
public class Utente implements Serializable {
    private String nome;
    private String cognome;
    private String matricola;
    private String email;
    private Collection<Libro> libri;

    /**
     * Crea un utente.
     * @param nome nome
     * @param cognome cognome
     * @param matricola matricola
     * @param email email
     */
    public Utente(String nome, String cognome, String matricola, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.email = email;
        libri = new ArrayList<>();
    }
    
    /**
     * Restituisce il nome.
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il cognome.
     * @return cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Restituisce la matricola.
     * @return matricola
     */
    public String getMatricola() {
        return matricola;
    }

    /**
     * Restituisce l'email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta il nome.
     * @param nome nuovo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Imposta il cognome.
     * @param cognome nuovo cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Imposta la matricola.
     * @param matricola nuova matricola
     */
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    /**
     * Imposta l'email.
     * @param email nuova email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce i libri attualmente in prestito all'utente.
     * @return collezione di libri
     */
    public Collection<Libro> getLibri() {
        return libri;
    }
    
    
    
    /**
     * Restituisce una rappresentazione testuale dell'utente.
     * @return stringa descrittiva
     */
    @Override
    public String toString() {
        String ret = String.format("Nome: %s, Cognome: %s, Matricola: %s, Email: %s, Libri:\n", nome, cognome, matricola, email);
        
        for(Libro l : libri) {
            ret += "- " + l.getTitolo() + "\n";
        }
        
        return ret;
    }

    /**
     * Calcola l'hash dell'utente.
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.cognome);
        hash = 83 * hash + Objects.hashCode(this.matricola);
        hash = 83 * hash + Objects.hashCode(this.email);
        return hash;
    }

    /**
     * Confronta due utenti per uguaglianza sui campi principali.
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
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.matricola, other.matricola)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }
    
    
}
