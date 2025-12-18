
package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Utente;
import java.util.Comparator;

/**
 * Comparator che ordina gli utenti in base alla matricola.
 * @author nebbi
 */
public class CompUtenteMatricola implements Comparator<Utente> {
    
    /**
     * Confronta due utenti in base alla matricola.
     * @param u1 primo utente
     * @param u2 secondo utente
     * @return confronto lessicografico delle matricole
     */
    @Override
    public int compare(Utente u1, Utente u2){
        return u1.getMatricola().compareTo(u2.getMatricola());
    }
}
