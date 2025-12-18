package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Libro;

import java.util.Comparator;

/**
 * Comparator che ordina i libri in base all'ISBN.
 * @author nebbi
 */
public class CompLibroISBN implements Comparator<Libro> {
    
    /**
     * Confronta due libri in base all'ISBN.
     * @param l1 primo libro
     * @param l2 secondo libro
     * @return confronto lessicografico degli ISBN
     */
    @Override
    public int compare(Libro l1, Libro l2){
        return l1.getISBN().compareTo(l2.getISBN());
    }
    
}
