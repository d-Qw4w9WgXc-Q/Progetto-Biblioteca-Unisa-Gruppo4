package it.unisa.diem.inginf.biblioteca.types;

import java.util.Objects;
import java.util.Collection;
import java.util.ArrayList;


public class Utente {
    private String nome;
    private String cognome;
    private String matricola;
    private String email;
    private Collection<Libro> libri;

    public Utente(String nome, String cognome, String matricola, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.email = email;
        libri = new ArrayList();
    }
    
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Libro> getLibri() {
        return libri;
    }
    
    
    
    @Override
    public String toString() {
        String ret = String.format("Nome: %s, Cognome: %s, Matricola: %s, Email: %s, Libri:\n", nome, cognome, matricola, email);
        
        for(Libro l : libri) {
            ret += "- " + l.getTitolo() + "\n";
        }
        
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.cognome);
        hash = 83 * hash + Objects.hashCode(this.matricola);
        hash = 83 * hash + Objects.hashCode(this.email);
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
