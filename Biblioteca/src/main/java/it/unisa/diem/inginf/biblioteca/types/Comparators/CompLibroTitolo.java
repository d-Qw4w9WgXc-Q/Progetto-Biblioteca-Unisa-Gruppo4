package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Libro;
import java.util.Comparator;

/**
 *
 * @author nebbi
 */
public class CompLibroTitolo implements Comparator<Libro> {
    
    @Override
    public int compare(Libro l1, Libro l2){
        return l1.getTitolo().compareTo(l2.getTitolo());
    }
}
