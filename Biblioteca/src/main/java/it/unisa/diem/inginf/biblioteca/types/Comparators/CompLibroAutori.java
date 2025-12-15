package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Libro;
import java.util.Comparator;

/**
 *
 * @author nebbi
 */
public class CompLibroAutori implements Comparator<Libro> {
    
    @Override
    public int compare(Libro l1, Libro l2){
        
        for(String autore : l1.getAutori()){
            if(l2.getAutori().contains(autore))
                return 0;
        }
        return l1.getAutori().toArray()[0].toString().compareTo(l2.getAutori().toArray()[0].toString());
    }
}
