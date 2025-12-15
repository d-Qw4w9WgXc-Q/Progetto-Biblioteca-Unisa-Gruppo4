
package it.unisa.diem.inginf.biblioteca.types.Comparators;

import it.unisa.diem.inginf.biblioteca.types.Utente;
import java.util.Comparator;

/**
 *
 * @author nebbi
 */
public class CompUtenteMatricola implements Comparator<Utente> {
    
    @Override
    public int compare(Utente u1, Utente u2){
        return u1.getMatricola().compareTo(u2.getMatricola());
    }
}
