/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Utente;
import java.util.Comparator;

/**
 * Comparator che ordina gli utenti in base al cognome.
 * @author nebbi
 */
public class CompUtenteCognome implements Comparator<Utente>{
    
    /**
     * Confronta due utenti in base al cognome.
     * @param u1 primo utente
     * @param u2 secondo utente
     * @return confronto lessicografico dei cognomi
     */
    @Override
    public int compare(Utente u1, Utente u2){
        return u1.getCognome().compareTo(u2.getCognome());
    }
}
