package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Libro;

import java.util.Comparator;

/**
 *
 * @author nebbi
 */
public class CompLibroISBN implements Comparator<Libro> {
    
    @Override
    public int compare(Libro l1, Libro l2){
        return l1.getISBN().compareTo(l2.getISBN());
    }
    
}
