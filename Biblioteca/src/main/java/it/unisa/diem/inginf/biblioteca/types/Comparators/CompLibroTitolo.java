package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Libro;
import java.util.Comparator;

/**
 * Comparator che ordina i libri in base al titolo.
 * @author nebbi
 */
public class CompLibroTitolo implements Comparator<Libro> {
    
    /**
     * Confronta due libri in base al titolo.
     * @param l1 primo libro
     * @param l2 secondo libro
     * @return confronto lessicografico dei titoli
     */
    @Override
    public int compare(Libro l1, Libro l2){
        return l1.getTitolo().compareTo(l2.getTitolo());
    }
}
