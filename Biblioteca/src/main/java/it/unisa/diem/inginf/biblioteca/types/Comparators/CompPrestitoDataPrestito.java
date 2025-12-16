package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Prestito;

import java.util.Comparator;

/**
 *
 * @author nebbi
 */
public class CompPrestitoDataPrestito implements Comparator<Prestito> {
    
    @Override
    public int compare(Prestito p1, Prestito p2){
        return p1.getDataPrestito().compareTo(p2.getDataPrestito());
    }
    
}
