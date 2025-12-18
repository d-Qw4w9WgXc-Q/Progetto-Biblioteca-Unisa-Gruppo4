package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Libro;
import java.util.Comparator;

/**
 * Comparator che ordina i libri in base agli autori.
 * Considera equivalenti due libri se condividono almeno un autore.
 * @author nebbi
 */
public class CompLibroAutori implements Comparator<Libro> {
    
    /**
     * Confronta due libri in base agli autori.
     * @param l1 primo libro
     * @param l2 secondo libro
     * @return 0 se condividono un autore, altrimenti confronto lessicografico sul primo autore
     */
    @Override
    public int compare(Libro l1, Libro l2){
        
        for(String autore : l1.getAutori()){
            if(l2.getAutori().contains(autore))
                return 0;
        }
        return l1.getAutori().toArray()[0].toString().compareTo(l2.getAutori().toArray()[0].toString());
    }
}
