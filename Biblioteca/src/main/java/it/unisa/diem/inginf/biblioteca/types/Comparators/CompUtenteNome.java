package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Utente;
import java.util.Comparator;

/**
 * Comparator che ordina gli utenti in base al nome.
 * @author nebbi
 */

public class CompUtenteNome implements Comparator<Utente> {

    /**
     * Confronta due utenti in base al nome.
     * @param u1 primo utente
     * @param u2 secondo utente
     * @return confronto lessicografico dei nomi
     */
    @Override
    public int compare(Utente u1, Utente u2) {
        return u1.getNome().compareTo(u2.getNome());
    }
}
